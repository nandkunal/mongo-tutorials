package com.mongodb.lecture1;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class HelloWorldFreeMarker {

	public static void main(String[] args) {
		 Configuration configuration = new Configuration();
		 configuration.setClassForTemplateLoading(
				 HelloWorldFreeMarker.class, "/");
		 try {
			Template helloTemplate = configuration.getTemplate("hello.ftl");
			StringWriter writer = new StringWriter();
			Map<String,Object> map =  new HashMap<String, Object>();
			map.put("name", "kunal");
			try {
				helloTemplate.process(map, writer);
				System.out.println(writer);
			} catch (TemplateException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}
}
