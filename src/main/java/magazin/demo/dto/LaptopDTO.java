package magazin.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import magazin.demo.enums.LaptopSize;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaptopDTO {

    private long serialNumber;
    private String manufacturer;
    private int price;
    private int itemsInStock;

    private LaptopSize laptopSize;
}
