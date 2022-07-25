package com.example.demo.controller;

import com.example.demo.model.Etudiant;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping("/index")
    public String etudiants(Model model,
                            @RequestParam(name = "page", defaultValue = "0")int page,
                            @RequestParam(name = "size", defaultValue = "5") int size,
                            @RequestParam(name = "keyword", defaultValue = "") String keyword){
        Page<Etudiant> etudiants = etudiantRepository.findByNomContains(keyword, PageRequest.of(page,size));
        model.addAttribute("listeEtudiants", etudiants.getContent());
        model.addAttribute("keyword", keyword);

       return "etudiants";
    }

    @GetMapping("/save")
    public String formEtudiant(){
        return "formEtudiant";
    }

    @GetMapping("/delete")
    public String delete(Long id){
        etudiantRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/")
    public String index(){
        return "redirect:/index";
    }



}
