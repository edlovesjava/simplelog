# simplelog

Simple mobile app based application for daily log of feelings

using:
* Spring Boot
* Spring MVC - REST
* Gradle 

# manage source code

## push master to openstack

```
git push 
```

## pushes master to github

```
git push github master
```

## to build

```
./gradlew build
```

## to build with maven

```
mvn clean install
```

# to start 

## to start with spring boot from jar

```
java -jar -Dspring.profiles.active=test build/libs/simple-log-0.1.0.jar

```
## to start with maven with embedded tomcat

```
mvn spring-boot:run  -Drun.jvmArguments="-Dspring.profiles.active=development"
```

## profiles to use

* development - used during development, expects local mongodb to be runninhg
* test - used during test with remote mongodb
* openshift - used after push to openshift using mongo on openshift

# hosting

The OpenShift `jbossews` cartridge documentation can be found at:

http://openshift.github.io/documentation/oo_cartridge_guide.html#tomcat

## configuring for openshift


