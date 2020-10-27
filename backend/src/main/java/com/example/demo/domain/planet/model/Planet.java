package com.example.demo.domain.planet.model;

import com.example.demo.common.model.BaseEntity;
import com.example.demo.domain.planet.definition.PlanetEnum;
import com.example.demo.domain.planet.definition.DifficultyEnum;
import com.example.demo.domain.planet.mission.model.Mission;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Entity
@Getter
@Table(
        uniqueConstraints =
                @UniqueConstraint(
                        name = "unique_universe_constraint",
                        columnNames = {"name"}))
public class Planet extends BaseEntity {

    @NaturalId private String name;

    @Enumerated(value = EnumType.STRING)
    private DifficultyEnum difficulty;

    @Enumerated(value = EnumType.STRING)
    private PlanetEnum category;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mission_id")
    private List<Mission> missions;

    /*@Type(
            type = "typed-list",
            parameters = {
                @Parameter(name = "type", value = "ingredient_definition"),
                @Parameter(name = "discriminatorValue", value = "ingredients")
            })
    @Column(columnDefinition = "ingredient_definition[]")
    private List<IngredientDefinition> ingredientDefinitions = new ArrayList<>();*/
}
