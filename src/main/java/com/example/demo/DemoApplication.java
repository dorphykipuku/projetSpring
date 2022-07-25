package com.example.demo;

import com.example.demo.model.Etudiant;
import com.example.demo.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private EtudiantService etudiantService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        etudiantService.save(new Etudiant(null, "dorphy", "l1", "lettres"));
        etudiantService.save(new Etudiant(null, "maria", "l1", "economie"));
        etudiantService.save(new Etudiant(null, "booto", "l1", "sciences"));
        etudiantService.save(new Etudiant(null, "rams", "l1", "lettres"));
        etudiantService.save(new Etudiant(null, "kyria", "l1", "economie"));
        etudiantService.save(new Etudiant(null, "dani", "l1", "sciences"));

        etudiantService.getAll().forEach(etudiant -> {
            System.out.println(etudiant.getNom());
        });
    }
}
