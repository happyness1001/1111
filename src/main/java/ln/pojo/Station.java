package ln.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Station {
    private String station_id;//站点id
    private String station_name;//站点名称
    private String station_location;//站点位置
}
