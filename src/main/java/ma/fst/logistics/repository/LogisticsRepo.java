package ma.fst.logistics.repository;

import ma.fst.logistics.model.Logistics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogisticsRepo extends JpaRepository<Logistics, Long> {
}
