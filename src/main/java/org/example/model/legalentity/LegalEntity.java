package org.example.model.legalentity;

import javax.persistence.*;
import java.util.Map;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;


@Data
@Entity
@Table(name = "legal_entity", schema = "prepurchase")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class LegalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "inn", nullable = false, length = 10)
    private String inn;

    @Column(name = "ogrn", nullable = false, length = 20)
    private String ogrn;

    @Column(name = "legal_address")
    private String legalAddress;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "billing_details")
    @Type(type = "jsonb")
    private Map<String, String> billingDetails;

    @Column(name = "additional_info")
    private String additionalInfo;
}
