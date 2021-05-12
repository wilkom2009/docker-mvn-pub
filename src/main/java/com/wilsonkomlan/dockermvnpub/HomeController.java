package com.wilsonkomlan.dockermvnpub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    static String HOME_MESSAGE = "Welcome to Docker Maven Publish project !";

    @GetMapping("/")
    public String home() {
        return HOME_MESSAGE;
    }
}
