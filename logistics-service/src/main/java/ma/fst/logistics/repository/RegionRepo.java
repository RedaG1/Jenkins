package ma.fst.logistics.repository;

import ma.fst.logistics.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegionRepo extends JpaRepository<Region, Long> {
    List<Region> findAllByImpactedIsTrue();
    Optional<Region> findRegionByUserMail(String mail);
    List<Region> findAllByLogisticalHubIsTrue();
}
