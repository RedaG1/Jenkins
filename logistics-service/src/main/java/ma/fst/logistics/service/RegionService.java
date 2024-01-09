package ma.fst.logistics.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.fst.logistics.model.Region;
import ma.fst.logistics.repository.RegionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepo repo;

    public Region addRegion(Region region) {
        return repo.saveAndFlush(region);
    }
    public List<Region> getAllRegions() {
        return repo.findAll();
    }
    public Region getRegionById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("region by id "+id+" not found"));
    }
    public List<Region> getImpactedRegions() {
        return repo.findAllByImpactedIsTrue();
    }
    public List<Region> getLogisticalHubRegion() {
        return repo.findAllByLogisticalHubIsTrue();
    }
    public void deleteRegion(Long id) {
        repo.deleteById(id);
    }
}
