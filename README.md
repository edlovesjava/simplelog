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
java -jar target/simplelog-1.0.jar --server.port=8080 --server.address=localhost --spring.profiles.active=development

```

## profiles to use

* development - used during development, expects local mongodb to be runninhg
* test - used during test with remote mongodb
* openshift - used after push to openshift using mongo on openshift

# test data

to add test data
```
curl h-i -X POST -H "Content-Type:application/json" -d '{"recordedOn" : "05-Dec-2014", "feeling":"one-up", "incident":"meeting listening to member talk about difficulty reading", "resolution":"identify and document"}' http://simplelog-wentware.rhcloud.com/api/logmessages
```
# hosting


```
simplelog @ http://simplelog-wentware.rhcloud.com/
  (uuid: 54821f744382ec3ef2000197)
--------------------------------------------------
  Domain:     wentware
  Created:    Dec 05  4:11 PM
  Gears:      1 (defaults to small)
  Git URL:    ssh://54821f744382ec3ef2000197@simplelog-wentware.rhcloud.com/~/git/simplelog.git/
  SSH:        54821f744382ec3ef2000197@simplelog-wentware.rhcloud.com
  Deployment: auto (on git push)

  diy-0.1 (Do-It-Yourself 0.1)
  ----------------------------
    Gears: Located with mongodb-2.4

  mongodb-2.4 (MongoDB 2.4)
  -------------------------
    Gears:          Located with diy-0.1
    Connection URL: mongodb://$OPENSHIFT_MONGODB_DB_HOST:$OPENSHIFT_MONGODB_DB_PORT/
    Database Name:  simplelog
    Password:       ****
    Username:       admin
    
```

## configuring for openshift


