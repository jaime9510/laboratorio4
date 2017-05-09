package it.polito.ai;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories
public class MongoConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "transport-social-platform";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("172.17.0.2", 27017);
		
		// Alternative, mongodb service in the cloud (mlab)
//		return new MongoClient("mongodb://admin:admin@ds133321.mlab.com:33321/transport-social-platform");
	}

}
