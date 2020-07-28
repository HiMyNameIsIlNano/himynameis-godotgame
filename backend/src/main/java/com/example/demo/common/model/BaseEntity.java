package com.example.demo.common.model;

import com.example.demo.common.definition.EnumDefinitionType;
import com.example.demo.common.definition.StringListType;
import com.example.demo.common.definition.TypedListType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import lombok.ToString;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@TypeDefs({
    @TypeDef(name = "ingredient-enum", typeClass = EnumDefinitionType.class),
    @TypeDef(
            name = "string-list",
            typeClass = StringListType.class,
            defaultForType = String[].class),
    @TypeDef(name = "typed-list", typeClass = TypedListType.class)
})
@ToString
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id-sequence")
    @SequenceGenerator(name = "id-sequence", sequenceName = "id_sequence", allocationSize = 3)
    private Long id;
}
