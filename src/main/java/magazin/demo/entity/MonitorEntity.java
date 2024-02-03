package magazin.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "мониторы")
@Data
public class MonitorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "серийный_номер")
    private long serialNumber;

    @Column(name = "производитель")
    private String manufacturer;

    @Column(name = "цена")
    private int price;

    @Column(name = "количество")
    private int quantity;

    @Column(name = "диагональ")
    private int diagonal;


}
