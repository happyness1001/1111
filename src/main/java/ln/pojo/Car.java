package ln.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

//运输车辆
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    private String car_id;//车辆id
    private String dynamic_location;//车辆实时位置
    private String store_id;//所属仓库id
    private ArrayList<String> commodity_id;//所装商品id
}
