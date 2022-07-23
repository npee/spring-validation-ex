package io.npee.spring.validation.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PriceV3 {

    private Boolean isDetermined;

    @NotNull
    private Integer max;
    private Integer min;
}
