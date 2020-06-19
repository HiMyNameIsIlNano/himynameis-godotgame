package com.example.demo.domain.recipe.definition;

import com.example.demo.common.definition.BaseDefinition;
import javax.persistence.DiscriminatorValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@DiscriminatorValue("string")
@Getter
public class StringBasedDefinition extends BaseDefinition {

	public StringBasedDefinition(String id) {
		super(id);
	}
}
