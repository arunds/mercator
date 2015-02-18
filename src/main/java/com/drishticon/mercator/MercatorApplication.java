package com.drishticon.mercator;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@EnableJpaRepositories
@Import(RepositoryRestMvcConfiguration.class)
@PropertySource("application.properties")
@SpringBootApplication
public class MercatorApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(MercatorApplication.class, args);

		System.out.println("Let's inspect the beans provided by Spring Boot same:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			// System.out.println(beanName);
		}
	}

}