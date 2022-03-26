import gsh.pojo.*;
import gsh.service.NormalBuyingToBStrategy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;

public class test08Activity {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        NormalBuyingToBStrategy normalBuyingToBStrategy = (NormalBuyingToBStrategy) applicationContext.getBean("normalBuyingToBStrategy");
        Address address = new Address();
        NormalOrderToB normalOrderToB1 = new NormalOrderToB("1810460", 18, "0110203", 1, 1, address, new Date(), "无");
        NormalOrderToB normalOrderToB2 = new NormalOrderToB("1590038", 17, "0230431", 1, 2, address, new Date(), "加麻加辣");
        ArrayList<NormalOrderToB> normalOrderToBS = new ArrayList<>();
        normalOrderToBS.add(normalOrderToB1);
        normalOrderToBS.add(normalOrderToB2);
        Bill bill = new Bill();
        NormalBuyingToB normalBuyingToB = new NormalBuyingToB("订单ID", normalOrderToBS, "第233家分店", 35, bill, address, new Date());
        StrategyActivity strategyActivity = new StrategyActivity(normalBuyingToBStrategy);
        strategyActivity.execute(normalBuyingToB);

    }


}
