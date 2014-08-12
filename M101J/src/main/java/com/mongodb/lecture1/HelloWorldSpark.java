package com.mongodb.lecture1;

import static spark.Spark.*;
import spark.*;

public class HelloWorldSpark {
	
	public static void main(String[] args) {
		get(new Route("/hello") {
			
			@Override
			public Object handle(Request arg0, Response arg1) {
				return "Hello World Spark";
			}
		});
		
	get(new Route("/test") {
			
			@Override
			public Object handle(Request arg0, Response arg1) {
				return "Hello Test";
			}
		});
	get(new Route("/print/:id") {
		
		@Override
		public Object handle(Request arg0, Response arg1) {
			return arg0.params("id");
		}
	});
	}

}
