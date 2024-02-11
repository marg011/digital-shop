package magazin.demo.repository;

import magazin.demo.entity.DesktopComputerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesktopComputerRepository extends JpaRepository<DesktopComputerEntity, Long> {
}
