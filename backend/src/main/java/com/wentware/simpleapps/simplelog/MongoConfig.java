package com.wentware.simpleapps.simplelog;

import com.mongodb.Mongo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
@ConfigurationProperties
public class MongoConfig {

    @Value("${spring.datasource.user.name}")
    private String dbUserName;
    @Value("${spring.datasource.user.password}")
    private String dbPassword;
    @Value("${spring.datasource.connection.url}")
    private String connectionUrl;
    @Value("${spring.datasource.usecredentials}")
    private String useCredentials;
    @Value("${spring.datasource.database}")
    private String database;
    
    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
        UserCredentials userCredentials = new UserCredentials(dbUserName, dbPassword);

        if ("TRUE".equals(useCredentials.toUpperCase())) {
            System.out.println(">>> using credentials '"+useCredentials+"'");
            return new SimpleMongoDbFactory(new Mongo(connectionUrl), database, userCredentials);
        } else {
            System.out.println(">>> NOT using credentials '"+useCredentials+"'");
            return new SimpleMongoDbFactory(new Mongo(connectionUrl), database);
            
        }
        //return new SimpleMongoDbFactory(new Mongo(), "database");
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }
}
