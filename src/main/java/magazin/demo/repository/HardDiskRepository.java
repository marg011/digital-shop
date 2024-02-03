package magazin.demo.repository;

import magazin.demo.entity.HardDiskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HardDiskRepository extends JpaRepository<HardDiskEntity, Integer> {
}