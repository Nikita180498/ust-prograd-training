package com.example.HelloUST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class BeanCountDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(BeanCountDemoApplication.class, args);
		System.out.println(context.getBeanDefinitionCount());
		System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
	}

}






