package com.mongodb.lecture1;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class HelloWorldMongoDB {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
		 MongoClient client =new MongoClient(new ServerAddress("localhost", 27017));
		 DB db  = client.getDB("test");
		 DBCollection  collection = db.getCollection("lecture1");
		if(collection.getCount() > 0){
			DBObject document = collection.findOne();
			System.out.println("Name -"+document.get("name"));
			System.out.println("Object Id-"+document.get("_id"));
		}
		 

	}

}
