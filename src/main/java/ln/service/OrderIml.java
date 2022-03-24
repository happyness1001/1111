package ln.service;

import ln.dao.AddressDistanceDao;
import ln.dao.CommodityDao;
import ln.dao.OrderCommodityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ln.pojo.Commodity;
import ln.pojo.Order;

import java.util.*;

@Service
public class OrderIml  implements OrderService {



    @Autowired
    @Qualifier("commodityDao")
    private CommodityDao commodityDao;

    @Autowired
    @Qualifier("orderCommodityDao")
    private OrderCommodityDao orderCommodityDao;


    public static List<String> receiveLocations = new ArrayList<>();//收货地址集合
    public static List<String> sentLocation = new ArrayList<>();//发货地址，即当前仓库地址

    @Override
    public void match(Order order){
        List<Commodity> commodityList = getCommodityList(order);//根据订单获得该订单上的所有商品集合
        Map<String,String> name_location = new TreeMap<>();//定义一个商品名称与商品在仓库中的位置相对应的集合
        //遍历商品 将商品的名称与位置初始化
        for (Commodity commodity : commodityList) {
            name_location.put(commodity.getName(),commodity.getLocation());
        }
        //如果是发货订单的处理
        if (analyse(order) == 1){
            Set<String> commodity_name = name_location.keySet();//得到MAP集合的键——商品名称的集合
            //根据键遍历MAP集合 得到商品的地址的集合 并打印出来 帮助工作人员快速找到对应的商品的地址
            for (String name : commodity_name) {
                String location = name_location.get(name);
                System.out.println("发货订单，仓库发货," + "商品:" + name + " 位于:" + location + "  请工作人员尽快发货");
            }
            System.out.println("揽收完成完成输入“1”");
            while (true){
                Scanner scanner = new Scanner(System.in);
                int i = scanner.nextInt();

                //工作人员确认揽收后，改变该订单上的每一个商品的状态
                if (i == 1){
                    for (Commodity commodity : commodityList) {
                        commodity.setStatus(3);
                        String receiveLocation = order.getReceive_location();
                        receiveLocations.add(receiveLocation);
                        System.out.println("商品:" + commodity.getName() + "  已揽收");
                    }
                    sentLocation.add(order.getSent_location());

                    System.out.println("该运单商品全部揽收完毕，等待发货，发货完毕请输入”2“");
                    if (scanner.nextInt() == 2){
                        for (Commodity commodity : commodityList) {
                            commodity.setStatus(4);
                            System.out.println("商品:" + commodity.getName() + "  已发货");
                        }
                        System.out.println("该运单商品全部发货完毕，等待收货，确认收货请输入”3“");
                        if (scanner.nextInt() == 3){
                            for (Commodity commodity : commodityList) {
                                commodity.setStatus(5);
                                System.out.println("商品:" + commodity.getName() + "  已收货");
                            }
                            break;

                        }
                    }
                    //如果商品状态被改变，输出对应语句，结束处理
                }

            }



        }//退货订单的处理
        /*else if (analyse(order) == 2){
            System.out.println("退货订单，等待商品收货");
            while (true){
                break;
            }
        }*/

    }


    @Override
    public int analyse(Order order) {
        System.out.println("分析运单类型");

        return (order.getOrder_type());
    }

    @Override
    public String dispatch(String receive_location, String order_id) {
        Commodity commodity = commodityDao.getCommodityByID(order_id);
        if (commodity != null)
            System.out.println("分发订单给当前收货地址所属的仓库");

        return null;
    }

    @Override
    //根据订单获得该订单上的所有商品
    public List<Commodity> getCommodityList(Order order) {
        List<Commodity> commodities = new ArrayList<>();//存放该订单的所有商品的集合
        String order_id = order.getOrder_id();//获得订单id
        List<String> commodity_id_list = orderCommodityDao.get_by_order(order_id);//根据订单ID获得该订单中所有商品ID集合
        for (String commodity_id : commodity_id_list) {
            Commodity commodity = commodityDao.getCommodityByID(commodity_id);//根据每一个商品id获得商品
            commodities.add(commodity);//将该订单中的所有商品添加到商品集合中
        }
        return commodities;//返回该商品集合

    }



    @Override
    public void change(Order order) {
        System.out.println("请");
    }

/*    @Override
    public void add(){
        address_distance address_distance1 = new address_distance( "北北", "zz津", 11);
        addressDistanceService.deleteAddressDistance("北北", "zz津");
        System.out.println("添加成功");
    }*/





}
