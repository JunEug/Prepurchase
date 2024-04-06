package org.example.controller;


import org.example.model.legalentity.LegalEntity;
import org.example.service.LegalEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/legal-entities")
public class LegalEntityController {

    private final LegalEntityService legalEntityService;

    @Autowired
    public LegalEntityController(LegalEntityService legalEntityService) {
        this.legalEntityService = legalEntityService;
    }

    @PostMapping
    public ResponseEntity<LegalEntity> addLegalEntity(@RequestBody LegalEntity legalEntity) {
        LegalEntity savedLegalEntity = legalEntityService.addLegalEntity(legalEntity);
        return new ResponseEntity<>(savedLegalEntity, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLegalEntity(@PathVariable Long id) {
        legalEntityService.deleteLegalEntityById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LegalEntity> getLegalEntityById(@PathVariable Long id) {
        LegalEntity legalEntity = legalEntityService.getLegalEntityById(id);
        if (legalEntity != null) {
            return ResponseEntity.ok(legalEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LegalEntity> updateLegalEntity(@PathVariable Long id, @RequestBody LegalEntity legalEntity) {
        LegalEntity updatedEntity = legalEntityService.updateLegalEntity(id, legalEntity);
        if (updatedEntity != null) {
            return ResponseEntity.ok(updatedEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}