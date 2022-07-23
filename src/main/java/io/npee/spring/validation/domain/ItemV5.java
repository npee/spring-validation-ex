package io.npee.spring.validation.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemV5 {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Valid
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="isDetermined", column=@Column(name="isDeterminedToBuy")),
        @AttributeOverride(name="max", column=@Column(name="buyPriceMax")),
        @AttributeOverride(name="min", column=@Column(name="buyPriceMin")),
    })
    @Column(insertable = false, updatable = false)
    @NotNull
    @ValidPrice
    private PriceV3 buyPrice;

    @Valid
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="isDetermined", column=@Column(name="isDeterminedToRent")),
        @AttributeOverride(name="max", column=@Column(name="rentPriceMax")),
        @AttributeOverride(name="min", column=@Column(name="rentPriceMin")),
    })
    @Column(insertable = false, updatable = false)
    @NotNull
    @ValidPrice
    private PriceV3 rentPrice;

    public ItemV5(String name, PriceV3 buyPrice, PriceV3 rentPrice) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.rentPrice = rentPrice;
    }
}
