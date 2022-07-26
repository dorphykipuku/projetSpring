package com.example.demo.repository;

import com.example.demo.model.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    Page<Etudiant> findByNomContains(String kw, Pageable pageable);
}
