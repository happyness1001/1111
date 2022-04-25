package wzz.comparator;

import wzz.digou.pojo.Product;

import java.util.Comparator;


public class ProductScoreComparator implements Comparator<Product> {


    @Override
    public int compare(Product p1, Product p2) {
        return (int)(-(p1.getScore()*10-p2.getScore()*10));
    }
}
