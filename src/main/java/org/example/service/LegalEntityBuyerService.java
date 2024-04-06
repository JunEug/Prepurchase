package org.example.service;

import org.example.model.legalentitybuyer.LegalEntityBuyer;
import org.example.model.legalentitybuyer.LegalEntityBuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LegalEntityBuyerService {

    private final LegalEntityBuyerRepository legalEntityBuyerRepository;

    @Autowired
    public LegalEntityBuyerService(LegalEntityBuyerRepository legalEntityBuyerRepository) {
        this.legalEntityBuyerRepository = legalEntityBuyerRepository;
    }

    @Transactional
    public LegalEntityBuyer addLegalEntity(LegalEntityBuyer legalEntityBuyer) {
        return legalEntityBuyerRepository.save(legalEntityBuyer);
    }

    @Transactional
    public void deleteLegalEntityById(Long id) {
        legalEntityBuyerRepository.deleteById(id);
    }

    public LegalEntityBuyer getLegalEntityById(Long id) {
        return legalEntityBuyerRepository.findById(id).orElse(null);
    }

    public LegalEntityBuyer updateLegalEntity(Long id, LegalEntityBuyer legalEntityBuyer) {
        LegalEntityBuyer existingEntity = legalEntityBuyerRepository.findById(id).orElse(null);
        if (existingEntity != null) {
            existingEntity.setCompanyName(legalEntityBuyer.getCompanyName());
            existingEntity.setInn(legalEntityBuyer.getInn());
            existingEntity.setOgrn(legalEntityBuyer.getOgrn());
            existingEntity.setLegalAddress(legalEntityBuyer.getLegalAddress());
            existingEntity.setContactPerson(legalEntityBuyer.getContactPerson());
            existingEntity.setContactPhone(legalEntityBuyer.getContactPhone());
            existingEntity.setContactEmail(legalEntityBuyer.getContactEmail());
            existingEntity.setBillingDetails(legalEntityBuyer.getBillingDetails());
            existingEntity.setAdditionalInfo(legalEntityBuyer.getAdditionalInfo());
            return legalEntityBuyerRepository.save(existingEntity);
        } else {
            return null;
        }
    }
}
