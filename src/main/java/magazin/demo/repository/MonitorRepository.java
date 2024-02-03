package magazin.demo.repository;

import magazin.demo.entity.MonitorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorRepository extends JpaRepository<MonitorEntity, Integer> {
}