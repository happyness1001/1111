import gsh.pojo.Address;
import gsh.pojo.Bill;
import gsh.pojo.GroupBuyingOrderToC;
import gsh.pojo.GroupMemberOrderToC;
import gsh.service.GroupBuyingToCStrategy;

import java.util.ArrayList;
import java.util.Date;

public class test04GroupToC {
    public static void main(String[] args) {
        Bill bill = new Bill();
        Address address = new Address();
        GroupMemberOrderToC groupMemberOrderToC1 = new GroupMemberOrderToC("181", "A", 5, 155, bill, address, new Date(), "无");
        GroupMemberOrderToC groupMemberOrderToC2 = new GroupMemberOrderToC("0460", "A", 5, 155, bill, address, new Date(), "无");
        GroupMemberOrderToC groupMemberOrderToC3 = new GroupMemberOrderToC("3919", "A", 5, 155, bill, address, new Date(), "无");
        ArrayList<GroupMemberOrderToC> groupMemberOrderToCS = new ArrayList<>();
        groupMemberOrderToCS.add(groupMemberOrderToC1);
        groupMemberOrderToCS.add(groupMemberOrderToC2);
        groupMemberOrderToCS.add(groupMemberOrderToC3);

        GroupBuyingOrderToC groupBuyingOrderToC = new GroupBuyingOrderToC("111", "222", "010254012", groupMemberOrderToCS, new Date());
        GroupBuyingToCStrategy groupBuyingToCStrategy = new GroupBuyingToCStrategy();
        groupBuyingToCStrategy.doStrategy(groupBuyingOrderToC);
    }
}
