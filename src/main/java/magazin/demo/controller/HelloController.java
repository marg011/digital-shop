package magazin.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController { // для проверки гипотезы

    @GetMapping
    public String sayHello() {
        return "Привет, это магазин'!";
    }
}
