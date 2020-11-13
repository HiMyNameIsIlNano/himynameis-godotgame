package com.example.demo.domain.planet.definition;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Amount {

    private int quantity;

    @Enumerated(value = EnumType.STRING)
    private UnitOfMeasureEnum unitOfMeasure;
}
