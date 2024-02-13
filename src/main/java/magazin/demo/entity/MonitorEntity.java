package magazin.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "monitors_entity")
public class MonitorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long serialNumber;
    private String manufacturer;
    private int price;
    private int quantity;
    private int diagonal;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
