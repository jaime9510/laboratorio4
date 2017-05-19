package it.polito.ai;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
@EnableMongoRepositories
public class MongoConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "transport-social-platform";
	}

	@Override
	public Mongo mongo() throws Exception {
//		return new MongoClient("172.17.0.2", 27017);
		return new MongoClient("192.168.99.100", 5400);
		// Alternative, mongodb service in the cloud (mlab)
//		return new MongoClient(new MongoClientURI("mongodb://admin:admin@ds133321.mlab.com:33321/transport-social-platform"));
	}
	
	
	
	
	
	
	/*public DB getDb()
	{
		List<DB> db = this.mongo().getUsedDatabases();
		for(DB d: db)
			if(d.getName().equals(this.getDatabaseName())
					return d.;	
		return null;
	}*/

}
