package br.com.sergio.desafio.procer.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

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
    
    public Mono<Pessoa> findById(Long id) {
    	return pessoaService.findById(id);
    }
    
    public Mono<Pessoa> save(Pessoa pessoa){
    	return pessoaService.save(pessoa);
    }

	public Mono<ResponseEntity<Pessoa>> update(Pessoa pessoa) {
		return pessoaService.update(pessoa);
	}

	public Mono<ResponseEntity<Pessoa>> updateStatus(Long idPessoa, Boolean status) {
		return pessoaService.updateStatusById(idPessoa, status);
	}

	public Mono<ResponseEntity<Void>> deletePessoaById(Long idPessoa) {
		return pessoaService.deleteById(idPessoa);
	}
}
