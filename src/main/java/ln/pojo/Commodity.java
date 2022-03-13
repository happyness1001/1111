package ln.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commodity {
    private String commodity_id;//商品id
    private String cate_id;//商品类别id
    private String store_id;//商品仓库id
    private String name;//商品名称
    private String subtitle;//商品标题
    private String main_image;//商品图片
    private String sub_images;//商品副图
    private String detail;//商品细节
    private double price;//商品价格
    private int quantity;//商品数量
    private String location;//商品位置
    private int status;//商品状态，1代表上架，2代表下架，3代表揽收，4代表运输，5代表收货
    private String creat_time;//商品产生时间
    private String modify_time;//商品最后修改时间
}
