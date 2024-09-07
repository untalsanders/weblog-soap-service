package io.github.untalsanders.ws.weblog;

import io.github.untalsanders.ws.weblog.posts.infrastructure.persistence.OnMemoryPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WeblogSoapServiceApplication {
    @Autowired
    private final OnMemoryPostRepository repository;

    public WeblogSoapServiceApplication(OnMemoryPostRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(WeblogSoapServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(String ...args) {
        String outputTemplate = "{\n\t\"ID\": \"%s\",\n\t\"Title\": \"%s\",\n\t\"Content\": \"%s\",\n\t\"Published\": \"%s\"\n}\n";
        return args1 -> repository.findAll().forEach(post -> System.out.printf(outputTemplate, post.getId().value(), post.getTitle(), post.getContent(), post.getPublished()));
    }

}
