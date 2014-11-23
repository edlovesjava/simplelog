package com.wentware.simpleapps.simplelog;

import com.mongodb.Mongo;
import java.net.UnknownHostException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 *
 * @author edlovesjava
 */
@Configuration
public class MongoConfig {

  public @Bean MongoDbFactory mongoDbFactory() throws Exception {
    UserCredentials userCredentials = new UserCredentials("simplesimon", "simonsays");
    return new SimpleMongoDbFactory(new Mongo("ds051970.mongolab.com:51970"), "simplelog", userCredentials);
    //return new SimpleMongoDbFactory(new Mongo(), "database");
  }

  public @Bean MongoTemplate mongoTemplate() throws Exception {
    return new MongoTemplate(mongoDbFactory());
  }
}