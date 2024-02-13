package magazin.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import magazin.demo.enums.LaptopSize;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LaptopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long serialNumber;
    private String manufacturer;
    private int price;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private LaptopSize laptopSize;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
