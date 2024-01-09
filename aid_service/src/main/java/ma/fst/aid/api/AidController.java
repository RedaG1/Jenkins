package ma.fst.aid.api;

import lombok.RequiredArgsConstructor;
import ma.fst.aid.model.AidInformation;
import ma.fst.aid.service.AidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AidController {
    private final AidService service;

    @PostMapping("/submit") // requesting an aid
    public ResponseEntity<AidInformation> addAid(@RequestBody AidInformation aidInformation) {
        return new ResponseEntity<>(service.add(aidInformation), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<AidInformation> updateAid(@RequestBody AidInformation aidInformation) {
        return new ResponseEntity<>(service.update(aidInformation), HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<AidInformation> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }
    @GetMapping("/find/all")
    public ResponseEntity<List<AidInformation>> findAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
