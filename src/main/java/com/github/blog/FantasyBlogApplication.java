package com.github.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class FantasyBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(FantasyBlogApplication.class, args);
    }
}