
    create table mission (
       id int8 not null,
        quantity int4 not null,
        unit_of_measure varchar(255),
        mission_definition missions_definition,
        mission_id int8,
        primary key (id)
    );

    create table planet (
       id int8 not null,
        category varchar(255),
        difficulty varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table if exists planet 
       drop constraint if exists unique_universe_constraint;

    alter table if exists planet 
       add constraint unique_universe_constraint unique (name);

    alter table if exists mission 
       add constraint FKlligic9cit2ayk8gt4k6wkpu1 
       foreign key (mission_id) 
       references planet;
