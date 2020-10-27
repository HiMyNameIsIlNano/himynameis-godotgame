package com.example.demo.domain.planet.definition;

import lombok.Getter;

public enum UnitOfMeasureEnum {
    GRAMS("Gr"),
    KILOS("Kg"),
    MILLILITERS("ml"),
    CENTILITERS("cc"),
    LITERS("l");

    @Getter private final String label;

    UnitOfMeasureEnum(String label) {
        this.label = label;
    }
}
