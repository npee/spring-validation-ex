package io.npee.spring.validation.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemV3 {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @NotNull
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="isDetermined", column=@Column(name="isDeterminedToBuy")),
        @AttributeOverride(name="max", column=@Column(name="buyPriceMax")),
        @AttributeOverride(name="min", column=@Column(name="buyPriceMin")),
    })
    @Column(insertable = false, updatable = false)
    private PriceV2 buyPrice;

    @NotNull
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="isDetermined", column=@Column(name="isDeterminedToRent")),
        @AttributeOverride(name="max", column=@Column(name="rentPriceMax")),
        @AttributeOverride(name="min", column=@Column(name="rentPriceMin")),
    })
    @Column(insertable = false, updatable = false)
    private PriceV2 rentPrice;

    public ItemV3(String name, PriceV2 buyPrice, PriceV2 rentPrice) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.rentPrice = rentPrice;
    }
}
