package io.npee.spring.validation.domain;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PriceV1 {

    private Boolean isDetermined;
    private Integer max;
    private Integer min;
}
