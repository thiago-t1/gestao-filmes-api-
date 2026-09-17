package com.thiago.gestaofilmesapi;

import com.thiago.gestaofilmesapi.model.Diretor;
import com.thiago.gestaofilmesapi.model.Filme;
import com.thiago.gestaofilmesapi.repository.DiretorRepository;
import com.thiago.gestaofilmesapi.repository.FilmeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class GestaoFilmesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestaoFilmesApiApplication.class, args);
    }

    @Bean
    CommandLineRunner demonstrarConsultas(FilmeRepository filmeRepository, DiretorRepository diretorRepository) {
        return args -> {
            Diretor diretor1 = Diretor.builder().nome("Christopher Nolan").build();
            Diretor diretor2 = Diretor.builder().nome("Greta Gerwig").build();

            Filme filme1 = Filme.builder().titulo("A Origem").duracao(148).diretor(diretor1).build();
            Filme filme2 = Filme.builder().titulo("Interestelar").duracao(169).diretor(diretor1).build();
            Filme filme3 = Filme.builder().titulo("Barbie").duracao(114).diretor(diretor2).build();

            diretor1.setFilmes(List.of(filme1, filme2));
            diretor2.setFilmes(List.of(filme3));
            diretorRepository.saveAll(List.of(diretor1, diretor2));

            System.out.println("Filmes com duração maior que 120: " + filmeRepository.findByDuracaoGreaterThan(120));
            System.out.println("Filmes com duração menor ou igual a 120: " + filmeRepository.findByDuracaoLessThanEqual(120));
            System.out.println("Filmes cujo título começa com 'In': " + filmeRepository.findByTituloStartingWith("In"));
            System.out.println("Diretores cujo nome começa com 'Ch': " + diretorRepository.findByNomeStartingWith("Ch"));
        };
    }
}
