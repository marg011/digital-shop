package magazin.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesktopComputerDto {
    private long serialNumber;
    private String manufacturer;
    private int price;
    private int itemsInStock;

    private DesktopForm form;
}
