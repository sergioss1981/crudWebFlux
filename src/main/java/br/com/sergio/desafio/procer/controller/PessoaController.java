package br.com.sergio.desafio.procer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sergio.desafio.procer.entity.Pessoa;
import br.com.sergio.desafio.procer.facade.PessoaFacade;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/procer")
public class PessoaController {

    @Autowired
    private PessoaFacade pessoaFacade;
    
    @RequestMapping(value = "/pessoas", method = RequestMethod.GET)
    public Flux<Pessoa> getPessoas() {
    	return pessoaFacade.findAll();
    }
	
    @RequestMapping(value = "/pessoa/{idPessoa}", method =  RequestMethod.GET)
    public Mono<ResponseEntity<Pessoa>> getPessoaById(@PathVariable Long idPessoa){
    	return pessoaFacade.findById(idPessoa).map(pessoa -> ResponseEntity.ok(pessoa)).defaultIfEmpty(ResponseEntity.notFound().build());
    }
    
    @RequestMapping(value = "/pessoa", method =  RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseEntity<Pessoa>> savePessoa(@RequestBody Pessoa pessoa){
        return pessoaFacade.save(pessoa).map(pessoaPersistida -> ResponseEntity.ok(pessoaPersistida)).defaultIfEmpty(ResponseEntity.internalServerError().build());
    }
    
    @RequestMapping(value = "/pessoa", method =  RequestMethod.PUT)
    public Mono<ResponseEntity<Pessoa>> updatePessoa(@RequestBody Pessoa pessoa){
    	return pessoaFacade.update(pessoa);
    }
    
    @RequestMapping(value = "/pessoa/{idPessoa}/{status}", method =  RequestMethod.PATCH)
    public Mono<ResponseEntity<Pessoa>> patchStatus(@PathVariable Long idPessoa, @PathVariable Boolean status){
    	return pessoaFacade.updateStatus(idPessoa, status);
    }
    
    @RequestMapping(value = "/pessoa/{idPessoa}", method =  RequestMethod.DELETE)
    public Mono<ResponseEntity<Void>> deletePessoa(@PathVariable Long idPessoa){
    	return pessoaFacade.deletePessoaById(idPessoa);
    }
    
}
