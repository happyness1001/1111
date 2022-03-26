import gsh.pojo.Address;
import gsh.pojo.Bill;
import gsh.pojo.NormalBuyingToC;
import gsh.pojo.NormalOrderToC;
import gsh.service.NormalBuyingToCStrategy;

import java.util.ArrayList;
import java.util.Date;

public class test02NormalToC {
    public static void main(String[] args) {
        NormalOrderToC normalOrderToC = new NormalOrderToC();
        ArrayList<NormalOrderToC> normalOrderToCS = new ArrayList<>();
        normalOrderToCS.add(normalOrderToC);
        Address address = new Address();
        Bill bill = new Bill();
        NormalBuyingToC normalBuyingToC = new NormalBuyingToC("1810460", address, normalOrderToCS, new Date(), "爷就是帅", "12", 2, bill);
        NormalBuyingToCStrategy normalBuyingToCStrategy = new NormalBuyingToCStrategy();
        normalBuyingToCStrategy.doStrategy(normalBuyingToC);
    }
}
