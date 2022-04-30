package br.com.sergio.desafio.procer.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.sergio.desafio.procer.entity.Pessoa;
import br.com.sergio.desafio.procer.service.PessoaService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PessoaFacade {

	@Autowired
	PessoaService pessoaService;
	
    public Flux<Pessoa> findAll() {
        return pessoaService.findAll();
    }
    
    public Mono<Pessoa> save(@RequestBody Pessoa pessoa){
    	return pessoaService.save(pessoa);
    }
}
