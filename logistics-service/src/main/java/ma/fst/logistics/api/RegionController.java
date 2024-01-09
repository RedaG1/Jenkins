package ma.fst.logistics.api;

import lombok.RequiredArgsConstructor;
import ma.fst.logistics.model.Region;
import ma.fst.logistics.service.RegionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class RegionController {
    private final RegionService service;

    @PostMapping("/region/add")
    public ResponseEntity<Region> addRegion(@RequestBody Region region) {
        return new ResponseEntity<>(service.addRegion(region), HttpStatus.CREATED);
    }
    @GetMapping("/region/find/all")
    public ResponseEntity<List<Region>> findAll() {
        return new ResponseEntity<>(service.getAllRegions(), HttpStatus.OK);
    }
    @GetMapping("/region/find/{id}")
    public ResponseEntity<Region> findRegionById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getRegionById(id), HttpStatus.OK);
    }
    @GetMapping("/region/impacted/find")
    public ResponseEntity<List<Region>> findImpactedRegions() {
        return new ResponseEntity<>(service.getImpactedRegions(), HttpStatus.OK);
    }
    @GetMapping("/region/hub/find")
    public ResponseEntity<List<Region>> findLogisticalHubs() {
        return new ResponseEntity<>(service.getLogisticalHubRegion(), HttpStatus.OK);
    }
    @DeleteMapping("/region/delete/{id}")
    public ResponseEntity<?> deleteRegion(@PathVariable Long id) {
        service.deleteRegion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
