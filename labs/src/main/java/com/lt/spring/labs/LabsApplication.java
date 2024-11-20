package com.lt.spring.labs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LabsApplication implements ApplicationRunner {

	@Autowired
	private ApplicationContext ctx;

	public static void main(String[] args) {
		SpringApplication.run(LabsApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		MessageGenerator mg = ctx.getBean(MessageGenerator.class);
//		System.out.printf("%s mesg from spring boot \n", mg.getMessage());
//		for(String name : ctx.getBeanDefinitionNames()) {
//			System.out.println(String.format("BEAN %s", name));
//		}
	}
}
