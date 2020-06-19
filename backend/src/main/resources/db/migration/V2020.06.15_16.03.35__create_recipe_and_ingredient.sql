
    create table ingredient (
       id int8 not null,
        quantity int4 not null,
        unit_of_measure varchar(255),
        ingredient_definition ingredient_definition,
        recipe_id int8,
        primary key (id)
    );

    create table recipe (
       id int8 not null,
        category varchar(255),
        difficulty varchar(255),
        name varchar(255),
        primary key (id)
    );

    alter table if exists recipe 
       drop constraint if exists unique_recipe_constraint;

    alter table if exists recipe 
       add constraint unique_recipe_constraint unique (name);

    alter table if exists ingredient 
       add constraint FKj0s4ywmqqqw4h5iommigh5yja 
       foreign key (recipe_id) 
       references recipe;
