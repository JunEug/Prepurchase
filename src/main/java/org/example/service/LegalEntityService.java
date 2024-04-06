package org.example.service;

import org.example.model.legalentity.LegalEntity;
import org.example.model.legalentity.LegalEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LegalEntityService {

    private final LegalEntityRepository legalEntityRepository;

    @Autowired
    public LegalEntityService(LegalEntityRepository legalEntityRepository) {
        this.legalEntityRepository = legalEntityRepository;
    }

    @Transactional
    public LegalEntity addLegalEntity(LegalEntity legalEntity) {
        return legalEntityRepository.save(legalEntity);
    }

    @Transactional
    public void deleteLegalEntityById(Long id) {
        legalEntityRepository.deleteById(id);
    }

    public LegalEntity getLegalEntityById(Long id) {
        return legalEntityRepository.findById(id).orElse(null);
    }

    public LegalEntity updateLegalEntity(Long id, LegalEntity legalEntity) {
        LegalEntity existingEntity = legalEntityRepository.findById(id).orElse(null);
        if (existingEntity != null) {
            existingEntity.setCompanyName(legalEntity.getCompanyName());
            existingEntity.setInn(legalEntity.getInn());
            existingEntity.setOgrn(legalEntity.getOgrn());
            existingEntity.setLegalAddress(legalEntity.getLegalAddress());
            existingEntity.setContactPerson(legalEntity.getContactPerson());
            existingEntity.setContactPhone(legalEntity.getContactPhone());
            existingEntity.setContactEmail(legalEntity.getContactEmail());
            existingEntity.setBillingDetails(legalEntity.getBillingDetails());
            existingEntity.setAdditionalInfo(legalEntity.getAdditionalInfo());
            return legalEntityRepository.save(existingEntity);
        } else {
            return null;
        }
    }
}
