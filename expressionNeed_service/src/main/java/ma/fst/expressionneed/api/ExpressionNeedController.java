package ma.fst.expressionneed.api;

import lombok.RequiredArgsConstructor;
import ma.fst.expressionneed.model.ExpressionNeed;
import ma.fst.expressionneed.service.ExpressionNeedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ExpressionNeedController {
    private final ExpressionNeedService service;
    @PostMapping("/submit")
    public ResponseEntity<ExpressionNeed> addExpressionNeed(@RequestBody ExpressionNeed expressionNeed) {
        return new ResponseEntity<>(service.add(expressionNeed), HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<ExpressionNeed> updateExpressionNeed(@RequestBody ExpressionNeed expressionNeed) {
        return new ResponseEntity<>(service.update(expressionNeed), HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<ExpressionNeed> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }
    // capture assistances submitted by user
    @GetMapping("/find/all/byuser")
    public ResponseEntity<List<ExpressionNeed>> findAllByUser(@RequestParam String mail) {
        return new ResponseEntity<>(service.getAllByUserMail(mail), HttpStatus.OK);
    }
    @GetMapping("/find/all")
    public ResponseEntity<List<ExpressionNeed>> findAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
