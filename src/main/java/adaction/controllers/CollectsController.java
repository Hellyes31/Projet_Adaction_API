package adaction.controllers;

import adaction.models.Collect;
import adaction.services.CollectsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/collects")
@CrossOrigin(origins = "http://localhost:5173")
public class CollectsController {
    private final CollectsService collectsService;

    public CollectsController(CollectsService collectsService) {
        this.collectsService = collectsService;
    }

    @GetMapping
    public List<Collect> getAllCollects() {
        return collectsService.getAllCollects();
    }

    @PostMapping
    public ResponseEntity<Collect> createCollect(@RequestBody Collect collect) {
        Collect collectCreated = collectsService.createCollect(collect);
        return new ResponseEntity<>(collectCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Collect> getCollectById(@PathVariable String id) {
        Optional<Collect> collect = collectsService.getCollectById(id);

        if (collect.isPresent()) {
            return new ResponseEntity<>(collect.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Collect> updateCollect(@PathVariable String id, @RequestBody Collect collectDetails) {
        Optional<Collect> updatedCollect = collectsService.updateCollect(id, collectDetails);

        if (updatedCollect.isPresent()) {
            return new ResponseEntity<>(updatedCollect.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollect(@PathVariable String id) {
        boolean deleted = collectsService.deleteCollect(id);

        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}