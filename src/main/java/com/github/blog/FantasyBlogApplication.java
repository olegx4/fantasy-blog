package com.github.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.ZoneOffset;
import java.util.TimeZone;

@SpringBootApplication
@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class FantasyBlogApplication {

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneOffset.UTC));
    }

    public static void main(String[] args) {
        SpringApplication.run(FantasyBlogApplication.class, args);
    }
}