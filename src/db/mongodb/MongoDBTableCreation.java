package db.mongodb;

import java.text.ParseException;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;

public class MongoDBTableCreation {

	public static void main(String [] args) throws ParseException {
		
		// step 1 connect to mongoDB
		MongoClient mongoClient = new MongoClient();
		MongoDatabase db = mongoClient.getDatabase(MongoDBUtil.DB_NAME);
		
		// step 2 remove old collections
		db.getCollection("users").drop();
		db.getCollection("items").drop();
		
		// step 3 create new collections
		IndexOptions options = new IndexOptions().unique(true);
		db.getCollection("users").createIndex(new Document("user_id",1),options);
		db.getCollection("items").createIndex(new Document("item_id",1),options);
		
		// step 4 insert fake data and create index
		db.getCollection("users").insertOne(
				new Document().append("user_id", "1111").append("password", "this_is_my_password")
				.append("first_name", "John").append("last_name", "smith"));
		
		mongoClient.close();
		System.out.println("Import is done successfully");
	}
}