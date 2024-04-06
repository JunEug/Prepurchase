package org.example.service;


import org.example.model.legalentityseller.LegalEntitySeller;
import org.example.model.legalentityseller.LegalEntitySellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.List;

@Service
public class LegalEntitySellerService {

    @Autowired
    private LegalEntitySellerRepository repository;

    public List<LegalEntitySeller> getAllSellers() {
        return repository.findAll();
    }

    public Optional<LegalEntitySeller> getSellerById(Long id) {
        return repository.findById(id);
    }

    public LegalEntitySeller createSeller(LegalEntitySeller seller) {
        return repository.save(seller);
    }

    public LegalEntitySeller updateSeller(Long id, LegalEntitySeller sellerDetails) {
        Optional<LegalEntitySeller> optionalSeller = repository.findById(id);
        if (optionalSeller.isPresent()) {
            LegalEntitySeller seller = optionalSeller.get();
            seller.setCompanyName(sellerDetails.getCompanyName());
            // Здесь установите остальные поля
            return repository.save(seller);
        } else {
            throw new RuntimeException("Seller not found with id: " + id);
        }
    }

    public void deleteSeller(Long id) {
        repository.deleteById(id);
    }
}
