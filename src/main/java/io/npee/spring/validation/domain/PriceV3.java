package io.npee.spring.validation.domain;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class PriceV3 {

    private Boolean isDetermined;
    private Integer min;
    private Integer max;
}
