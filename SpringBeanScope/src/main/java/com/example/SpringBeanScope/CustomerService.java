package com.example.SpringBeanScope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class CustomerService {
	public void countServices() {System.out.println(12);}
}
