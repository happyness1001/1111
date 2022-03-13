import gsh.pojo.Address;
import gsh.pojo.Bill;
import gsh.pojo.GroupBuyingOrderToB;
import gsh.pojo.GroupMemberOrderToB;
import gsh.service.GroupBuyingToBStrategy;

import java.util.ArrayList;
import java.util.Date;

public class test03GroupToB {
    public static void main(String[] args) {

        System.out.println(1);
        Address address = new Address();
        Bill bill = new Bill();
        GroupMemberOrderToB groupMemberOrderToB1 = new GroupMemberOrderToB("18104603919","A",5, (float) 500.2,bill,1,address, new Date(),"无");
        GroupMemberOrderToB groupMemberOrderToB2 = new GroupMemberOrderToB("15900383037","B",5, (float) 500.2,bill,1,address, new Date(),"无");
        GroupMemberOrderToB groupMemberOrderToB3 = new GroupMemberOrderToB("15900267071","C",5, (float) 500.2,bill,1,address, new Date(),"无");
        GroupMemberOrderToB groupMemberOrderToB4 = new GroupMemberOrderToB("13502084667","D",5, (float) 500.2,bill,1,address, new Date(),"无");
        ArrayList<GroupMemberOrderToB> groupMemberOrderToBS = new ArrayList<>();
        groupMemberOrderToBS.add(groupMemberOrderToB1);
        groupMemberOrderToBS.add(groupMemberOrderToB2);
        groupMemberOrderToBS.add(groupMemberOrderToB3);
        groupMemberOrderToBS.add(groupMemberOrderToB4);
        GroupBuyingOrderToB groupBuyingOrderToB = new GroupBuyingOrderToB("111",groupMemberOrderToBS,new Date(),address,"010235014");
        GroupBuyingToBStrategy groupBuyingToBStrategy = new GroupBuyingToBStrategy();
        groupBuyingToBStrategy.doStrategy(groupBuyingOrderToB);


    }
}
