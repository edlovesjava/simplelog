package com.wentware.simpleapps.simplelog;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


import com.mongodb.Mongo;
import com.wentware.simpleapps.simplelog.documents.Person;
import com.wentware.simpleapps.simplelog.repositories.PersonRepository;
import java.net.UnknownHostException;
import org.junit.Before;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Spring Data MongoDB Repository Unit testcase.
 * 
 * @author ourownjava.com
 *
 */

/**
 *
 * @author edlovesjava
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PersonRepositoryTest {

	@Autowired
    private ApplicationContext applicationContext;

	@Autowired
	private PersonRepository personRepository;

        @Autowired
        private MongoTemplate template;

        private MongoOperations mongoOps;

        PersonRepositoryTest() {
            mongoOps = template;
        }
        
        //@Before
        public void createTestCollection() {
            mongoOps.createCollection("people");
        }
	//@Test
	public void shouldSavePerson(){
		personRepository.save(createPerson());
	}

        //@Test
        public void shouldFindAll() {
            List<Person> people = personRepository.findAll();
            for(Person p : people) {
                System.out.println(">>> found person "+p.getId()+" first name ='"+p.getFirstName()+"', last name='"+p.getLastName()+"'.");
            }
        }

	private Person createPerson(){
		final Person person = new Person();
		person.setId("t1");
		person.setFirstName("Ed");
		person.setLastName("Wentworth");
		person.setAge(48);
		return person;
	}

	@Configuration
	@EnableMongoRepositories
	@ComponentScan(basePackageClasses = { PersonRepository.class })
	static class MongoConfiguration extends AbstractMongoConfiguration {

		@Override
		protected String getDatabaseName() {
			return "test";
		}

		@Override
		public Mongo mongo() throws UnknownHostException {
			return new Mongo("localhost");
		}

		@Override
		protected String getMappingBasePackage() {
			return "com.wentware.simpleapps.simplelog";
		}
	}

}