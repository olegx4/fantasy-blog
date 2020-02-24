package com.github.olegx4.hi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @RequestMapping
    public String sayHi() {
        return "Hi";
    }
}
