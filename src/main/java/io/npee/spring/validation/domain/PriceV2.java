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
public class PriceV2 {

    private Boolean isDetermined;
    @NotNull
    private Integer min;
    private Integer max;
}
