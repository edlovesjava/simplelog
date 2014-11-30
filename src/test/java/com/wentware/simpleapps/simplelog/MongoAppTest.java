/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wentware.simpleapps.simplelog;

import com.wentware.simpleapps.simplelog.documents.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author edlovesjava
 */
@Repository
public class MongoAppTest {

    private static final Log log = LogFactory.getLog(MongoAppTest.class);
    @Autowired
    MongoOperations mongoOps;

    public void run() {

        if (mongoOps.collectionExists(Person.class)) {
            mongoOps.dropCollection(Person.class);
        }

        mongoOps.createCollection(Person.class);

        mongoOps.insert(new Person("Joe", 34));

        log.info(mongoOps.findOne(new Query(where("name").is("Joe")), Person.class));

        mongoOps.dropCollection("person");
    }
}
