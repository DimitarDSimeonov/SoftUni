package com.gameStore.GameStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("TEST!");
    }
}
