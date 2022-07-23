package io.npee.spring.validation.domain;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PriceValidator implements ConstraintValidator<ValidPrice, PriceV3> {

    @Override
    public void initialize(ValidPrice constraintAnnotation) {
    }

    @Override
    public boolean isValid(PriceV3 price, ConstraintValidatorContext context) {
//       if (price.getMin() == null && price.getMax() == null || price.getMax() >= price.getMin()) {
//           return true;
//       } else {
//           context.disableDefaultConstraintViolation();
//           context
//               .buildConstraintViolationWithTemplate("가격이 유효하지 않습니다!")
//               .addConstraintViolation();
//           return false;
//       }

        return price.getMin() == null && price.getMax() == null || price.getMax() >= price.getMin();
    }
}
