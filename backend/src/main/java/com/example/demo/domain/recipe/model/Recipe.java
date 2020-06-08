package com.example.demo.domain.recipe.model;

import com.example.demo.common.model.BaseEntity;
import com.example.demo.domain.recipe.definition.CategoryEnum;
import com.example.demo.domain.recipe.definition.DifficultyEnum;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Table(
	uniqueConstraints = @UniqueConstraint(name = "unique_recipe_constraint", columnNames = {"name"})
)
public class Recipe extends BaseEntity {

	@NaturalId
	private String name;

	@Enumerated(value = EnumType.STRING)
	private DifficultyEnum difficulty;

	@Enumerated(value = EnumType.STRING)
	private CategoryEnum category;

}
