package com.github.blog.hi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HiController {

    @RequestMapping
    public String sayHi() {
        return "Hi";
    }
}
