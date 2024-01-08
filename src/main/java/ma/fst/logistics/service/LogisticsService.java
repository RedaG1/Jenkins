package ma.fst.logistics.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import ma.fst.logistics.model.DistributionRoute;
import ma.fst.logistics.model.Logistics;
import ma.fst.logistics.repository.LogisticsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogisticsService {
    private final LogisticsRepo repo;
//    private final DistributionRouteRepository routeRepository;
//    private final AidServiceProxy aidServiceProxy;  // Communicate with Aid Service
//
//    public DistributionRoute planDistributionRoute(DistributionRoute distributionRoute) {
//        // Validate and process distribution route planning
//        // Communicate with Aid Service to fetch aid-related information
//        AidInformation aidInformation = aidServiceProxy.getAidInformation(distributionRoute.getAidId());
//        distributionRoute.setAidInformation(aidInformation);
//
//        // Save the distribution route to the database
//        return routeRepository.save(distributionRoute);
//    }
//
//    public DistributionRoute getDistributionRoute(Long routeId) {
//        // Retrieve distribution route from the database
//        return routeRepository.findById(routeId)
//                .orElseThrow(() -> new EntityNotFoundException("Distribution route not found with ID: " + routeId));
//    }

    public Logistics add(Logistics registry) {
        return repo.save(registry);
    }
    public Logistics update(Logistics registry) {
        return repo.save(registry);
    }
    public Logistics get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Logistics by id "+id+" not found"));
    }
    public List<Logistics> getAll() {
        return repo.findAll();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
