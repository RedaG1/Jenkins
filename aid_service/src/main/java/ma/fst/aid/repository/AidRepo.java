package ma.fst.aid.repository;

import ma.fst.aid.model.AidInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AidRepo extends JpaRepository<AidInformation, Long> {
}
