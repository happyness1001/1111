import gsh.controller.DoStrategyImpl;
import gsh.controller.StrategyActivity;
import gsh.pojo.Address;
import gsh.pojo.Bill;
import gsh.pojo.NormalBuyingToB;
import gsh.pojo.NormalOrderToB;
import gsh.service.StrategyFactory;

import java.util.ArrayList;
import java.util.Date;

import static java.lang.Character.getName;

public class test {

    public static void main(String[] args) {

        Address address = new Address();
        NormalOrderToB normalOrderToB1 = new NormalOrderToB("1810460",18,"0110203",1,1,address,new Date(),"无");
        NormalOrderToB normalOrderToB2 = new NormalOrderToB("1590038",17,"0230431",1,2,address,new Date(),"加麻加辣");
        ArrayList<NormalOrderToB> normalOrderToBS = new ArrayList<>();
        normalOrderToBS.add(normalOrderToB1);
        normalOrderToBS.add(normalOrderToB2);
        Bill bill = new Bill();
        NormalBuyingToB normalBuyingToB = new NormalBuyingToB("订单ID",normalOrderToBS,"第233家分店",35,bill,address,new Date());


//        new StrategyActivity(StrategyFactory.getStrategy(NormalBuyingToB.class.getSimpleName())).execute(normalBuyingToB);
//        构造impl，传入订单
        new DoStrategyImpl().doStrategyActivity(normalBuyingToB);

    }
}
