package org.example.controller;

import org.example.model.legalentityseller.LegalEntitySeller;
import org.example.service.LegalEntitySellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/legal-entities-seller")
public class LegalEntitySellerController {


    @Autowired
    private LegalEntitySellerService service;

    @GetMapping
    public ResponseEntity<List<LegalEntitySeller>> getAllSellers() {
        List<LegalEntitySeller> sellers = service.getAllSellers();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LegalEntitySeller> getSellerById(@PathVariable Long id) {
        LegalEntitySeller seller = service.getSellerById(id)
                .orElseThrow(() -> new RuntimeException("Seller not found with id: " + id));
        return new ResponseEntity<>(seller, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LegalEntitySeller> createSeller(@RequestBody LegalEntitySeller seller) {
        LegalEntitySeller createdSeller = service.createSeller(seller);
        return new ResponseEntity<>(createdSeller, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LegalEntitySeller> updateSeller(@PathVariable Long id, @RequestBody LegalEntitySeller seller) {
        LegalEntitySeller updatedSeller = service.updateSeller(id, seller);
        return new ResponseEntity<>(updatedSeller, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Long id) {
        service.deleteSeller(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}