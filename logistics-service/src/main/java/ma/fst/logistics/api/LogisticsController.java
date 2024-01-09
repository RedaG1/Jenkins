package ma.fst.logistics.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.fst.logistics.model.AidDistribution;
import ma.fst.logistics.model.DistributionRoute;
import ma.fst.logistics.service.LogisticsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class LogisticsController {
    private final LogisticsService service;

    @PostMapping("/distribution-routes")
    public ResponseEntity<DistributionRoute> planDistributionRoute(@RequestBody DistributionRoute distributionRoute) {
        return new ResponseEntity<>(service.planDistributionRoute(distributionRoute), HttpStatus.CREATED);

    }

    @GetMapping("/distribution-routes/{routeId}")
    public ResponseEntity<DistributionRoute> getDistributionRoute(@PathVariable Long routeId) {
        DistributionRoute route = service.getDistributionRoute(routeId);
        return new ResponseEntity<>(route, HttpStatus.OK);
    }

    @DeleteMapping("/distribution-routes/{routeId}")
    public ResponseEntity<?> deleteDistributionRoute(@PathVariable Long routeId) {
        try {
            service.deleteDistributionRoute(routeId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception exception) {
            log.error("delete distribution route Exception: " + exception.getMessage());
        }
        return new ResponseEntity<>("EXISTING_AID_DISTRIBUTION", HttpStatus.BAD_REQUEST);
    }

//    @GetMapping("/distribution-routes/{routeId}/map")
//    public ResponseEntity<Map<String, Object>> getDistributionRouteMap(@PathVariable Long routeId) {
//        Map<String, Object> routeMap = service.getDistributionRouteMap(routeId);
//        return ResponseEntity.ok(routeMap);
//    }

    @PostMapping("/aid-distribution")
    public ResponseEntity<?> addAidDistribution(@RequestBody AidDistribution aidDistribution) {
        try {
            return new ResponseEntity<>(service.addAidDistribution(aidDistribution), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Plan distribution route Exception: " + e.getMessage());
        }
        return new ResponseEntity<>("DISTRIBUTION_ROUTE_NOT_EXIST", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/aid-distribution/{id}")
    public ResponseEntity<AidDistribution> getAidDistribution(@PathVariable Long id) {
        return new ResponseEntity<>(service.getAidDistribution(id), HttpStatus.OK);
    }

    @DeleteMapping("/aid-distribution/{id}")
    public ResponseEntity<?> deleteAidDistribution(@PathVariable Long id) {
        service.deleteAidDistribution(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello from logistics service!", HttpStatus.OK);
    }
}
