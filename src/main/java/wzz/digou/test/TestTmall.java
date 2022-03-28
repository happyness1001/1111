/**
 * 模仿天猫整站ssm 教程 为how2j.cn 版权所有
 * 本教程仅用于学习使用，切勿用于非法用途，由此引起一切后果与本站无关
 * 供购买者学习，请勿私自传播，否则自行承担相关法律责任
 */

package wzz.digou.test;

import java.util.LinkedList;
import java.util.Queue;

public class TestTmall {

//    public static void main(String args[]){
//        //准备分类测试数据：
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try (
//                Connection c = DriverManager.getConnection("jdbc:mysql:/47.94.6.121:3306/shop_ssm?useUnicode=true&characterEncoding=utf8",
//                        "root", "123456");
//                Statement s = c.createStatement();
//        )
//        {
//            s.execute("delete from category");
//            for (int i = 1; i <=10 ; i++) {
//                String sqlFormat = "insert into category values (null, '测试分类%d')";
//                String sql = String.format(sqlFormat, i);
//                System.out.println(sql);
//                s.execute(sql);
//            }
//            System.out.println("已经成功创建10条分类测试数据");
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

    public static Queue<Integer> list = new LinkedList<>();

    public static void main(String args[]) {

    }

    public void sendToTradingMidOffice() throws InterruptedException {
        while (true) {
            if (!list.isEmpty()) {
                System.out.println(list.remove());
                //将normalOrder传给交易中台
                Thread.sleep(1);
            } else {
                Thread.sleep(100);
            }
        }
    }

    public void addList(int num) {
        synchronized (list) {
            list.add(num);
            list.notifyAll();
        }
    }

}
