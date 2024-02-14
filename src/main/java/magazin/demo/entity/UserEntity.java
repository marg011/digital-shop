package magazin.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import magazin.demo.dto.Role;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<MonitorEntity> monitors;

    @OneToMany(mappedBy = "user")
    private Set<HardDiskEntity> hardDisks;

    @OneToMany(mappedBy = "user")
    private Set<DesktopComputerEntity> desktopComputers;

    @OneToMany(mappedBy = "user")
    private Set<LaptopEntity> laptops;


}