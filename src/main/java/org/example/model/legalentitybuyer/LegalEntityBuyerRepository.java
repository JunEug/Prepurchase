package org.example.model.legalentitybuyer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegalEntityBuyerRepository extends JpaRepository<LegalEntityBuyer, Long> {
}