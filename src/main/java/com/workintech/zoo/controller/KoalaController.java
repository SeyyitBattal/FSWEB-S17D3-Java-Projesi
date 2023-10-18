package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.entity.Koala;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
@Slf4j
public class KoalaController {

    private Map<Integer, Koala> koalas;

    @PostConstruct
    public void init() {
        koalas = new HashMap<>();
        koalas.put(1, new Koala(1, "Alice", 70, 17, "Female"));
        log.info("Koalas map created");
    }

    @GetMapping("/")
    public List<Koala> findAll() {
        return koalas.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Koala find(@PathVariable int id) {
        return koalas.get(id);
    }

    @PostMapping("/")
    public Koala save(@RequestBody Koala koala) {
        koalas.put(koala.getId(), koala);
        return koalas.get(koala.getId());
    }

    @PutMapping("/{id}")
    public Koala update(@PathVariable int id, @RequestBody Koala koala) {
        koalas.put(id, new Koala(id, koala.getName(), koala.getWeight(), koala.getSleepHour(), koala.getGender()));
        return koalas.get(id);
    }

    @DeleteMapping("/{id}")
    public Koala delete(@PathVariable int id) {
        Koala koala = koalas.get(id);
        koalas.remove(id);
        return koala;
    }


}
