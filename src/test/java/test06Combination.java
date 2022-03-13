import gsh.pojo.Bill;
import gsh.service.CombinationStrategy;

public class test06Combination {

    public static void main(String[] args) {
        Bill bill = new Bill();
        CombinationStrategy combinationStrategy = new CombinationStrategy();
        combinationStrategy.doCombinationStrategy(bill);
    }
}
