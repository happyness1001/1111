import gsh.controller.DoStrategyImpl;
import gsh.pojo.Address;
import gsh.pojo.Bill;
import gsh.pojo.NormalBuyingToB;
import gsh.pojo.NormalOrderToB;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.Date;

public class test extends HttpServlet {

    public static void main(String[] args) {

        Address address = new Address();
        NormalOrderToB normalOrderToB1 = new NormalOrderToB("1", 18, "0110203", 1, 1, address, new Date(), "无");
        NormalOrderToB normalOrderToB2 = new NormalOrderToB("1", 17, "0230431", 1, 2, address, new Date(), "加麻加辣");
        ArrayList<NormalOrderToB> normalOrderToBS = new ArrayList<>();
        normalOrderToBS.add(normalOrderToB1);
        normalOrderToBS.add(normalOrderToB2);
        Bill bill = new Bill();
        NormalBuyingToB normalBuyingToB = new NormalBuyingToB("1", normalOrderToBS, "第233家分店", 35, bill, address, new Date());

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DoStrategyImpl doStrategyImpl = (DoStrategyImpl) ctx.getBean("doStrategyImpl");
        doStrategyImpl.doStrategyActivity(normalBuyingToB);

//        new StrategyActivity(StrategyFactory.getStrategy(NormalBuyingToB.class.getSimpleName())).execute(normalBuyingToB);
//        构造impl，传入订单
//        new DoStrategyImpl().doStrategyActivity(normalBuyingToB);

    }
}
