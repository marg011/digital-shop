package magazin.demo.repository;

import magazin.demo.entity.HardDisksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorsRepository extends JpaRepository<HardDisksEntity, Integer> {
}