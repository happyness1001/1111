package ln.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String order_id;//物流单号
    private int order_type;//订单类型'1 代表进货 2 代表退货
    private String sent_location;//发货地址
    private String receive_location;//收货地址
    private String sent_phone_number;//寄件方电话
    private String receive_phone_number;//收件方电话
    private String creat_time;//下单时间
    private double order_price;//邮费


}
