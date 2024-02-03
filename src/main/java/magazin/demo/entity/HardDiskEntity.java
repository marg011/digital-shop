package magazin.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "жесткие_диски")
@Data
public class HardDiskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "серийный_номер")
    private int serialNumber;

    @Column(name = "производитель")
    private String manufacturer;

    @Column(name = "цена")
    private int price;

    @Column(name = "количество")
    private int quantity;

    @Column(name = "память")
    private int memory;

}
