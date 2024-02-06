package magazin.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import magazin.demo.enums.DesktopForm;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DesktopComputerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long serialNumber;
    private String manufacturer;
    private int price;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private DesktopForm form;
}
