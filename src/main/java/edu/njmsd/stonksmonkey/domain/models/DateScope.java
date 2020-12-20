package edu.njmsd.stonksmonkey.domain.models;

public enum DateScope {
    MONTH_BY_DAYS, YEAR_BY_MONTHS;

    static final DateScope defaultValue = MONTH_BY_DAYS;
}
