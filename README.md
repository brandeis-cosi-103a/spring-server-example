# spring-server-example
Example of a Spring Boot application as one sub-module in a multi-module Maven project

The directory layout is:
```
example/
  pom.xml       <--- Parent pom
  generator/    <--- Submodule #1 (non-Spring project)
    pom.xml     <--- Submodule #1 pom
    src/
      ...
  server/       <--- Submodule #2 (Spring project)
    pom.xml     <--- Submodule #2 pom
    src/
      ...
```

There are 2 submodules here. Each inherits everything from the parent pom. The submodules can add
their own dependencies.

The `generator` project does not have a Spring dependency - it's just plain old Java.

The `server` project is a Spring project, and contains a simple JSON RPC service which generates
random numbers. The actual number generation is delegated to the
[RandomNumberGenerator](example/generator/src/main/java/edu/brandeis/cosi103a/springexample/generator/RandomNumberGenerator.java)
class in the `generator` project, so the `server` project has a dependency on the `generator` project
(seen in the server's pom.xml)
Some configuration exists in
[AppConfig.java](example/server/src/main/java/edu/brandeis/cosi103a/springexample/server/AppConfig.java)
which lets Spring know how to create and inject the
[RandomNumberGenerator](example/generator/src/main/java/edu/brandeis/cosi103a/springexample/generator/RandomNumberGenerator.java)
class into the application.

There is also an example of installing the Guava module in
[App.java](example/server/src/main/java/edu/brandeis/cosi103a/springexample/server/App.java). This is
not necessary in this example, but is needed when trying to serialize or parse Guava objects, such
as `ImmutableList`.
