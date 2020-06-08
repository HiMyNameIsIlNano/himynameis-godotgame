package com.example.demo.domain.recipe.definition;

import com.example.demo.common.definition.BaseDefinition;
import javax.persistence.DiscriminatorValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@DiscriminatorValue("string")
@Getter
@AllArgsConstructor
public class StringBasedDefinition implements BaseDefinition {

	private String id;

}
