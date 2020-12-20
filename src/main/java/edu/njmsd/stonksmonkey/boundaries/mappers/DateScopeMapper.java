package edu.njmsd.stonksmonkey.boundaries.mappers;

import edu.njmsd.stonksmonkey.api.dto.DateScopeDto;
import edu.njmsd.stonksmonkey.domain.models.DateScope;
import org.springframework.stereotype.Component;

@Component
public class DateScopeMapper implements Mapper<DateScopeDto, DateScope> {

    @Override
    public DateScope map(DateScopeDto source) {
        return switch (source) {
            case MONTH -> DateScope.MONTH_BY_DAYS;
            case YEAR -> DateScope.YEAR_BY_MONTHS;
        };
    }
}
