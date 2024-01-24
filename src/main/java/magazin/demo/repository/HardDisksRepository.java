package magazin.demo.repository;

import magazin.demo.entity.HardDisksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HardDisksRepository extends JpaRepository<HardDisksEntity, Integer> {
}