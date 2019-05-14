# Create project


https://guides.gradle.org/creating-multi-project-builds/

https://stackoverflow.com/questions/44493378/whats-the-difference-between-implementation-and-compile-in-gradle

## Initialize a project with gradle

```
gradle init
```

## Include a project to gradle wrapper

Include `user-service` project into gradle wrapper

`settings.gradle`
```gradle
rootProject.name = 'microservices'

include 'user-service'
```