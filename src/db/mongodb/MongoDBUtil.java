package db.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;

public class MongoDBUtil {

	// 数据库的名字，你可以随便更改
	// 我们能够发现MongoDBConnection不需要走网络端口，local直接能处理
	public static final String DB_NAME = "Jupiter";
}