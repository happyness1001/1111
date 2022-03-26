import gsh.pojo.Address;
import gsh.pojo.Bill;
import gsh.pojo.ConsignmentContract;
import gsh.service.ConsignmentStrategy;

import java.util.Date;

public class test05Consignment {

    public static void main(String[] args) {
        Bill bill = new Bill();
        Address address1 = new Address();
        Address address2 = new Address();
        ConsignmentContract consignmentContract = new ConsignmentContract("111", "122", "154", 12, 500, bill, (String) "11", (double) 10, String.valueOf(new Date().getTime()), (double) 23, 12, address1, address2, new Date(), "无");
        ConsignmentStrategy consignmentStrategy = new ConsignmentStrategy();
        consignmentStrategy.doStrategy(consignmentContract);
    }

}
