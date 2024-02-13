package magazin.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "hard_disks_entity")
@Data
public class HardDiskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long serialNumber;
    private String manufacturer;
    private int price;
    private int quantity;
    private int memory;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
