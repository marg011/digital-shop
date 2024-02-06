package magazin.demo.repository;

import magazin.demo.entity.DesktopComputerEntity;
import magazin.demo.entity.LaptopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<LaptopEntity, Long> {
}
