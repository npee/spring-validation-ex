package io.npee.spring.validation.domain;

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
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer price;

    public Item(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
