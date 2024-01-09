package ma.fst.logistics.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.fst.logistics.model.AidDistribution;
import ma.fst.logistics.model.DistributionRoute;
import ma.fst.logistics.repository.AidDistributionRepo;
import ma.fst.logistics.repository.DistributionRouteRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LogisticsService {
    private final DistributionRouteRepo routeRepository;
    private final AidDistributionRepo aidDistributionRepo;

    public DistributionRoute planDistributionRoute(DistributionRoute distributionRoute) {
        return routeRepository.save(distributionRoute);
    }

    public DistributionRoute getDistributionRoute(Long routeId) {
        return routeRepository.findById(routeId)
                .orElseThrow(() -> new EntityNotFoundException("Distribution route not found with ID: " + routeId));
    }

    public AidDistribution addAidDistribution(AidDistribution aidDistribution) {
        aidDistribution.setDistributionTime(LocalDateTime.now());
        return aidDistributionRepo.save(aidDistribution);
    }

    public AidDistribution getAidDistribution(Long id) {
        return aidDistributionRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("aid distribution by id " + id + " not found"));
    }

    public void deleteDistributionRoute(Long routeId) {
        routeRepository.deleteById(routeId);
    }

    public void deleteAidDistribution(Long id) {
        aidDistributionRepo.deleteById(id);
    }

//    public Map<String, Object> getDistributionRouteMap(Long routeId) {
//        DistributionRoute route = getDistributionRoute(routeId);
//
//        Map<String, Object> mapData = new HashMap<>();
//        mapData.put("routeId", route.getId());
//        mapData.put("mapUrl", "https://example.com/map?route=" + route.getId());
//
//        return mapData;
//    }
}
