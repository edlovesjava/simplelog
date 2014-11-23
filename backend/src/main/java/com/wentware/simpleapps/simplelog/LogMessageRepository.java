package com.wentware.simpleapps.simplelog;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "logmessages", path = "logmessages")
public interface LogMessageRepository extends MongoRepository<LogMessage, String> {

	List<LogMessage> findByMood(@Param("mood") String mood);

}