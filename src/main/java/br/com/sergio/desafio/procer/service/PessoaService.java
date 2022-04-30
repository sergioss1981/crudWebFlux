package br.com.sergio.desafio.procer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.sergio.desafio.procer.entity.Pessoa;
import br.com.sergio.desafio.procer.repository.PessoaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    
    public Flux<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }
    
    public Mono<Pessoa> save(@RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
    
    /**
     * TODO fazer as outras operacoes do CRUD.
     */
}
