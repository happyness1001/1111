package ln.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class order_commodity {
    private String order_id;//运单id
    private String commodity_id;//商品id
}
