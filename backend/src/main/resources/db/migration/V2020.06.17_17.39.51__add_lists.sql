
    alter table if exists recipe 
       add column ingredient_definitions ingredient_definition[];

    alter table if exists recipe 
       add column strings text[];
