package com.ogul.bootcamp;

import com.ogul.bootcamp.repository.AuthorityRepository;
import com.ogul.bootcamp.repository.BookRepository;
import com.ogul.bootcamp.repository.UserRepository;
import com.ogul.bootcamp.service.EnvironmentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class BootcampApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BootcampApplication.class, args);

		EnvironmentService environmentService = context.getBean(EnvironmentService.class);
		environmentService.printList();

		BookRepository bookRepository = context.getBean(BookRepository.class);
		System.out.println(bookRepository.findByAgeGreaterThanEqualOrderByAgeAscQuery(0L, PageRequest.of(1, 1)).getContent());

        UserRepository userRepository = context.getBean(UserRepository.class);
        System.out.println(userRepository.findByUsername("ogul2"));

        AuthorityRepository authorityRepository = context.getBean(AuthorityRepository.class);
		System.out.println(authorityRepository.findAll());

    }

}
