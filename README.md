# simplelog

Simple mobile app based application for daily log of feelings

using:
* Spring Boot
* Spring MVC - REST
* Gradle 

## to build

```
./gradlew build
```

# to start 

```
java -jar -Dspring.profiles.active=test build/libs/simple-log-0.1.0.jar
```
## profiles
* development - used during development, expects local mongodb to be runninhg
* test - used during test with remote mongodb
* openshift - used after push to openshift using mongo on openshift

# hosting

The OpenShift `jbossews` cartridge documentation can be found at:

http://openshift.github.io/documentation/oo_cartridge_guide.html#tomcat


