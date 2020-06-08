package com.example.demo.domain.recipe.definition;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Amount {

	private int quantity;

	@Enumerated(value = EnumType.STRING)
	private UnitOfMeasureEnum unitOfMeasure;

}
