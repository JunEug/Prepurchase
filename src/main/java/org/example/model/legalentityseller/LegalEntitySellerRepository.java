package org.example.model.legalentityseller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegalEntitySellerRepository extends JpaRepository<LegalEntitySeller, Long> {
}