package com.example.demo.domain.planet.mission.model;

import com.example.demo.common.model.BaseEntity;
import com.example.demo.domain.planet.definition.Amount;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Getter
@ToString(callSuper = true)
public class Mission extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    @Type(type = "mission-enum")
    @Column(columnDefinition = "missions_definition")
    private MissionDefinitionEnum missionDefinition;

    @Embedded private Amount amount;
}
