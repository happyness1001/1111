package ln.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreHouse {
    private String store_id;//仓库id
    private String store_name;//仓库名
    private String store_location;//仓库地址


    public void shipment(String order) {
        System.out.println("出货");
    }

    ;

    public void purchase(String order) {
        System.out.println("进货");
    }

    ;
}
