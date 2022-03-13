package ln.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LngLat {
    private double longitude;
    private double latitude;
    private String address_name;
    private double distance;
}
