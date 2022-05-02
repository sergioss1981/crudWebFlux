package br.com.sergio.desafio.procer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.sergio.desafio.procer.entity.Pessoa;
import br.com.sergio.desafio.procer.repository.PessoaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    
//    private PessoaMapper mapper = Mappers.getMapper(PessoaMapper.class);
    
    public Flux<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }
    
    public Mono<Pessoa> findById(Long id) {
    	return pessoaRepository.findById(id);
    }
    
    public Mono<Pessoa> save(Pessoa pessoa){
    	return pessoaRepository.save(pessoa);
    }
    
    public Mono<ResponseEntity<Pessoa>> update(Pessoa pessoa){
    	return pessoaRepository.findById(pessoa.getId())
    			.flatMap(pessoaAtual -> {
    				pessoaAtual.setNome(pessoa.getNome());
    				pessoaAtual.setSobrenome(pessoa.getSobrenome());
    				pessoaAtual.setCpf(pessoa.getCpf());
    				pessoaAtual.setEmail(pessoa.getEmail());
    				pessoaAtual.setAtivo(pessoa.getAtivo());
    				return pessoaRepository.save(pessoaAtual);
    			}).map(update -> ResponseEntity.ok(update)).defaultIfEmpty(ResponseEntity.notFound().build());
    }
    
    public Mono<ResponseEntity<Pessoa>> updateStatusById(Long idPessoa, Boolean status){
    	return pessoaRepository.findById(idPessoa)
    			.flatMap(pessoaAtual -> {
    				pessoaAtual.setAtivo(status);
    				return pessoaRepository.save(pessoaAtual);
    			}).map(update -> ResponseEntity.ok(update)).defaultIfEmpty(ResponseEntity.notFound().build());
    }

	public Mono<ResponseEntity<Void>> deleteById(Long idPessoa) {
		return pessoaRepository.findById(idPessoa)
    			.flatMap(pessoaAtual -> 
    					pessoaRepository.delete(pessoaAtual)
    					.then(Mono.just(ResponseEntity.ok().<Void>build()))
    					)
				.defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
