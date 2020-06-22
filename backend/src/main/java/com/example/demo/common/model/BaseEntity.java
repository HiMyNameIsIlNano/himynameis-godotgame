package com.example.demo.common.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id-sequence")
    @SequenceGenerator(name = "id-sequence", sequenceName = "id_sequence", allocationSize = 3)
    private Long id;
}
