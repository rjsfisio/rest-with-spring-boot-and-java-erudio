package br.com.rjsfisio.controllers;

import br.com.rjsfisio.model.Greenting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController

public class GreentingController {

    private static final String templade = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    //http:localhost:8080/greenting?name=Rogerio

    @RequestMapping ("/greenting")
    public Greenting getGreenting(
            @RequestParam(value = "name", defaultValue = "Word")
            String name) {

        return new Greenting(counter.incrementAndGet(), String.format(templade, name));


    }
}
