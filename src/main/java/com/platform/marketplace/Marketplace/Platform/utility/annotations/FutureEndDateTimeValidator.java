package com.platform.marketplace.Marketplace.Platform.utility.annotations;

import com.platform.marketplace.Marketplace.Platform.dto.EventDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class FutureEndDateTimeValidator implements ConstraintValidator<FutureEndDateTime, EventDTO> {
    @Override
    public void initialize(FutureEndDateTime constraintAnnotation) {

    }

    @Override
    public boolean isValid(EventDTO eventDTO, ConstraintValidatorContext context) {
        LocalDateTime startAt = eventDTO.getStartsAt();
        LocalDateTime endsAt = eventDTO.getEndsAt();
        if (startAt == null || endsAt == null) {
            return false;
        }
        return endsAt.isBefore(startAt);
    }
}
