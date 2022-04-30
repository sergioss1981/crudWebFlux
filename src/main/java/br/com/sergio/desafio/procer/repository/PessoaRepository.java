package br.com.sergio.desafio.procer.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import br.com.sergio.desafio.procer.entity.Pessoa;

@Repository
public interface PessoaRepository extends ReactiveCrudRepository<Pessoa, Long>{

}
