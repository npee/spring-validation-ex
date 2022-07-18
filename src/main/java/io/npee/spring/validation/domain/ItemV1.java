package io.npee.spring.validation.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemV1 {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @NotNull
    private Integer price;

    public ItemV1(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
