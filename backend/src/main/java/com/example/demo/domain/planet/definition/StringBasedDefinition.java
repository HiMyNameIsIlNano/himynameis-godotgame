package com.example.demo.domain.planet.definition;

import com.example.demo.common.definition.BaseDefinition;
import javax.persistence.DiscriminatorValue;
import lombok.Getter;

@DiscriminatorValue("string")
@Getter
public class StringBasedDefinition extends BaseDefinition {

    public StringBasedDefinition(String id) {
        super(id);
    }
}
