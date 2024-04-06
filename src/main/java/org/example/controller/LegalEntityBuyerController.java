package org.example.controller;


import org.example.model.legalentitybuyer.LegalEntityBuyer;
import org.example.service.LegalEntityBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/legal-entities-buyer")
public class LegalEntityBuyerController {

    private final LegalEntityBuyerService legalEntityBuyerService;

    @Autowired
    public LegalEntityBuyerController(LegalEntityBuyerService legalEntityBuyerService) {
        this.legalEntityBuyerService = legalEntityBuyerService;
    }

    @PostMapping
    public ResponseEntity<LegalEntityBuyer> addLegalEntity(@RequestBody LegalEntityBuyer legalEntityBuyer) {
        LegalEntityBuyer savedLegalEntityBuyer = legalEntityBuyerService.addLegalEntity(legalEntityBuyer);
        return new ResponseEntity<>(savedLegalEntityBuyer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLegalEntity(@PathVariable Long id) {
        legalEntityBuyerService.deleteLegalEntityById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LegalEntityBuyer> getLegalEntityById(@PathVariable Long id) {
        LegalEntityBuyer legalEntityBuyer = legalEntityBuyerService.getLegalEntityById(id);
        if (legalEntityBuyer != null) {
            return ResponseEntity.ok(legalEntityBuyer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LegalEntityBuyer> updateLegalEntity(@PathVariable Long id, @RequestBody LegalEntityBuyer legalEntityBuyer) {
        LegalEntityBuyer updatedEntity = legalEntityBuyerService.updateLegalEntity(id, legalEntityBuyer);
        if (updatedEntity != null) {
            return ResponseEntity.ok(updatedEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}