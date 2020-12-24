package edu.njmsd.stonksmonkey.api.converters;

import edu.njmsd.stonksmonkey.api.dto.DateScopeDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Locale;

public class DateScopeDtoConverter implements Converter<String, DateScopeDto> {

    @Override
    public DateScopeDto convert(String source) {
        try {
            return DateScopeDto.valueOf(source.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unknown date scope");
        }
    }
}
