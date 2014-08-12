package com.mongodb.lecture1;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import static spark.Spark.*;
public class HelloWorldFreeMakerSpark {
	public static void main(String[] args) {
		 final Configuration configuration = new Configuration();
		 configuration.setClassForTemplateLoading(
				 HelloWorldFreeMakerSpark.class, "/");
			get(new Route("/display/:id") {
				@Override
				public Object handle(Request arg0, Response arg1) {
					StringWriter writer = new StringWriter();
					try {
						Template helloTemplate = configuration.getTemplate("hello.ftl");
						Map<String,Object> map =  new HashMap<String, Object>();
						map.put("name", arg0.params("id"));
						try {
							helloTemplate.process(map, writer);
						} catch (TemplateException e) {
							e.printStackTrace();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					return writer;
				}
			});
	}

}
