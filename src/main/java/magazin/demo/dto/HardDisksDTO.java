package magazin.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HardDisksDTO {

    @JsonIgnore
    private long id;


    private long serialNumber;
    private String manufacturer;
    private int price;
    private int quantity;
    private int memory;
}
