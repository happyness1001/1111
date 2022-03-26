import gsh.pojo.Address;
import gsh.pojo.Bill;
import gsh.pojo.FuturesContract;
import gsh.service.FuturesStrategy;

import java.util.Date;

public class test07Futures {

    public static void main(String[] args) {
        Bill bill = new Bill();
        Address address = new Address();
        FuturesContract futuresContract = new FuturesContract("111", "222", "333", bill, bill, 30, new Date(), new Date(), 1, address, address);
        FuturesStrategy futuresStrategy = new FuturesStrategy();
        futuresStrategy.doStrategy(futuresContract);
    }


}
