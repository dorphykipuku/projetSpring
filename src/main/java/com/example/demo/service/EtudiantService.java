package com.example.demo.service;

import com.example.demo.model.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> getAll();
    Etudiant save(Etudiant etudiant);
}
