package magazin.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import magazin.demo.enums.DesktopForm;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesktopComputerDTO {
    private long id;
    private long serialNumber;
    private String manufacturer;
    private int price;
    private int quantity;
    private DesktopForm form;
}
