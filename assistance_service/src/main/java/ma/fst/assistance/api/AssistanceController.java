package ma.fst.assistance.api;

import lombok.RequiredArgsConstructor;
import ma.fst.assistance.model.AssistanceRequest;
import ma.fst.assistance.service.AssistanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AssistanceController {
    private final AssistanceService assistanceService;

    @PostMapping("/submit")
    public ResponseEntity<AssistanceRequest> addAssistance(@RequestBody AssistanceRequest assistanceRequest) {
        return new ResponseEntity<>(assistanceService.addAssistance(assistanceRequest), HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<AssistanceRequest> updateAssistance(@RequestBody AssistanceRequest assistanceRequest) {
        return new ResponseEntity<>(assistanceService.updateAssistance(assistanceRequest), HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<AssistanceRequest> findAssistance(@PathVariable Long id) {
        return new ResponseEntity<>(assistanceService.findAssistanceById(id), HttpStatus.OK);
    }
    // capture assistances submitted by user
    @GetMapping("/find/all/byuser")
    public ResponseEntity<List<AssistanceRequest>> findAllByUser(@RequestParam String email) {
        return new ResponseEntity<>(assistanceService.findAssistanceByUserEmail(email), HttpStatus.OK);
    }
    @GetMapping("/find/all")
    public ResponseEntity<List<AssistanceRequest>> findAllAssistances() {
        return new ResponseEntity<>(assistanceService.findAll(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAssistance(@PathVariable Long id) {
        assistanceService.deleteAssistance(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("hello from assistance testing endpoint" ,HttpStatus.OK);
    }
}
