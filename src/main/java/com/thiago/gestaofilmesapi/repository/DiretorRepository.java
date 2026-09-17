package com.thiago.gestaofilmesapi.repository;

import com.thiago.gestaofilmesapi.model.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiretorRepository extends JpaRepository<Diretor, Long> {

    List<Diretor> findByNomeStartingWith(String nome);
}
