package org.example.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Map;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;


@Data
@Entity
@Table(name = "product", schema = "prepurchase")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    private BigDecimal sale;

    private String description;

    @Column(name = "destinationtime")
    private Integer destinationTime;

    @Column(name = "politics")
    @Type(type = "jsonb")
    private Map<String, String> politics;

    @Column(name = "waystodelivery")
    @Type(type = "jsonb")
    private Map<String, String> waysToDelivery;

    @Column(name = "waystopay")
    @Type(type = "jsonb")
    private Map<String, String> waysToPay;

    @Column(name = "deliveryprice")
    private BigDecimal deliveryPrice;

    @Column(name = "product_image_url")
    private String productImageUrl;

}