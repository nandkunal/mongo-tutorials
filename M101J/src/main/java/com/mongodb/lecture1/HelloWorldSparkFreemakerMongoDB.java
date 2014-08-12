package com.mongodb.lecture1;
import static spark.Spark.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import spark.Request;
import spark.Response;
import spark.Route;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
public class HelloWorldSparkFreemakerMongoDB {
	public static void main(String[] args) {
		 final Configuration configuration = new Configuration();
		 configuration.setClassForTemplateLoading(
				 HelloWorldSparkFreemakerMongoDB.class, "/");
			get(new Route("/query") {
				@Override
				public Object handle(Request arg0, Response arg1) {
					StringWriter writer = new StringWriter();
					try {
						Template helloTemplate = configuration.getTemplate("hello.ftl");
						 MongoClient client =new MongoClient(new ServerAddress("localhost", 27017));
						 DB db  = client.getDB("test");
						 DBCollection  collection = db.getCollection("lecture1");
						 DBObject document = collection.findOne();
						
						try {
							helloTemplate.process(document, writer);
						} catch (TemplateException e) {
							halt(500);
							e.printStackTrace();
						}
					} catch (IOException e) {
						halt(500);
						e.printStackTrace();
					}
					return writer;
				}
			});
		
	}

}
