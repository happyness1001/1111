import gsh.pojo.Address;
import gsh.pojo.Bill;
import gsh.pojo.NormalBuyingToB;
import gsh.pojo.NormalOrderToB;
import gsh.service.NormalBuyingToBStrategy;

import java.util.ArrayList;
import java.util.Date;

public class test01NormalToB {
    public static void main(String[] args) {

        Address address = new Address();
        NormalOrderToB normalOrderToB1 = new NormalOrderToB("1810460",18,"0110203",1,1,address,new Date(),"无");
        NormalOrderToB normalOrderToB2 = new NormalOrderToB("1590038",17,"0230431",1,2,address,new Date(),"加麻加辣");
        ArrayList<NormalOrderToB> normalOrderToBS = new ArrayList<>();
        normalOrderToBS.add(normalOrderToB1);
        normalOrderToBS.add(normalOrderToB2);
        Bill bill = new Bill();
        NormalBuyingToB normalBuyingToB = new NormalBuyingToB("订单ID",normalOrderToBS,"第233家分店",35,bill,address,new Date());
        NormalBuyingToBStrategy normalBuyingToBStrategy = new NormalBuyingToBStrategy();
        normalBuyingToBStrategy.doStrategy(normalBuyingToB);

    }
}
