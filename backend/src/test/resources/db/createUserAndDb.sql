-- This is just used to initialise the DB for the integration test and keep the Flyway migration files clean
CREATE USER demouser;
CREATE DATABASE demo_db WITH OWNER demouser;