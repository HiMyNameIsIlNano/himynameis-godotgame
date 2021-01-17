# Demo Godot Game

This is a demo game I am writing to understand how `godot`, `gradle`, `protobuf`, `swagger`, `gRPC` and `postgresql` work. The game is just an experiment, and it is composed by a Front End and a Backe End.  
The communication between the Client (C#) and the Back End (Java Spring Boot) is two-ways. In order to have a registry with all the apis between the Front End and the Back End I am leveraging on `gRPC` and I am generating the endpoints out of some `*Service.proto` files.

# Back End 

## Spring Profiles
The application can make use of three profiles. One can decide to enable/disable the automatic generation of migration scripts by adding removing the `auto-generate-ddl`. 
The `no-security` profile can be activated in order to bypass http basic authentication when calling the rest endpoints. The `local` profile can be used to override the default configuration.

## Flyway Migrations
The intent is to be able to generate sql migration automatically starting from the Java entities. For this to work the `auto-generate-ddl` must be active.

## Swagger UI
In order to reach the swagger docs, one can jump to the following URL: http://localhost:8071/swagger-ui

## gRPC
The backend exposes `gRPC` services and will be called by the Client. Due to fact that the Front End is written in `C#`, the `:protobuf` project exports the services defined in the `*.proto` file(s) are exported as `java` and `C#` classes. 

## TODO
- [ ] Generic exception handling for REST controllers/Service
- [ ] Secure `gRPC` services
- [ ] How to gracefully manage client disconnect and reconnect 

# Front End

The Front End is basically written in `C#` because I wanted to learn a new Programming Language and this is one of the two programming languages supported by the `Godot` game engine.  

## More documentation for the Front End

Coming soon.