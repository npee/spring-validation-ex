package io.npee.spring.validation.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemV2 {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    private PriceV2 price;

    public ItemV2(String name, PriceV2 price) {
        this.name = name;
        this.price = price;
    }
}
