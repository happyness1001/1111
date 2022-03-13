package ln.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class address_distance {
    String from_address;
    String to_address;
    double distance;

  /*  public address_distance(String from_address, String to_address, double distance) {
        this.from_address = from_address;
        this.to_address = to_address;
        this.distance = distance;
    }*/
}
