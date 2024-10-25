package com.example.SpringBeanScope;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringBeanScopeApplication {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
		
		CustomerController controller=(CustomerController)context.getBean("customerController");
		controller.countCustomers();
		
		
	}

}
