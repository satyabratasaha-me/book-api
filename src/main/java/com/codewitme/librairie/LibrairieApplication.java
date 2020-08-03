package com.codewitme.librairie;

import com.codewitme.librairie.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages ="com.codewitme.librairie" )
//@ComponentScan("com.codewitme.librairie.repository")
//@EnableMongoRepositories("com.codewitme.librairie.repository")
public class LibrairieApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrairieApplication.class, args);
	}

}
