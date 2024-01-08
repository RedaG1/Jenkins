package ma.fst.logistics.api;

import lombok.RequiredArgsConstructor;
import ma.fst.logistics.model.DistributionRoute;
import ma.fst.logistics.model.Logistics;
import ma.fst.logistics.service.LogisticsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class LogisticsController {
    private final LogisticsService service;

//    @PostMapping("/distribution-routes")
//    public ResponseEntity<DistributionRoute> planDistributionRoute(@RequestBody DistributionRoute distributionRoute) {
//        DistributionRoute createdRoute = service.planDistributionRoute(distributionRoute);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdRoute);
//    }
//
//    @GetMapping("/distribution-routes/{routeId}")
//    public ResponseEntity<DistributionRoute> getDistributionRoute(@PathVariable Long routeId) {
//        DistributionRoute route = service.getDistributionRoute(routeId);
//        return ResponseEntity.ok(route);
//    }

    @PostMapping("/add")
    public ResponseEntity<Logistics> addLogistics(@RequestBody Logistics registry) {
        return new ResponseEntity<>(service.add(registry), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Logistics> updateLogistics(@RequestBody Logistics registry) {
        return new ResponseEntity<>(service.update(registry), HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Logistics> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }
    @GetMapping("/find/all")
    public ResponseEntity<List<Logistics>> findAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello from logistics service!", HttpStatus.OK);
    }
}
