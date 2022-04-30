package br.com.sergio.desafio.procer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sergio.desafio.procer.entity.Pessoa;
import br.com.sergio.desafio.procer.repository.PessoaRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/procer")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;
	
    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public Flux<Pessoa> Get() {
        return pessoaRepository.findAll();
    }
    
    @RequestMapping(value = "/pessoa", method =  RequestMethod.POST)
    public Mono<Pessoa> Post(@RequestBody Pessoa pessoa){
        return pessoaRepository.save(pessoa);
    }
    
	
	/**
	 * Implementar endpoints para Cadastrar, Atualizar, Obter dados por Id, Listar Dados paginado e atualizar status de ativo/inativo (true/false);
	 * @return
	 */
	
	@GetMapping(value = "/hello")
	public String getHelloWorld() {
		return "H E L L O   W O R L D !!!  Ihuuuuuuu!!!  Tô no ar!";
	}
	
//	//FAZER O POST
//	@GetMapping()
//	public void cadastrar(Pessoa pessoa) {
//		//"Pessoa cadastrada com sucesso.";
//	}
//	
//	//PUT
//	@GetMapping()
//	public void atualizar(Pessoa pessoa) {
//		//"Informações da Pessoa atualizadas com sucesso.";
//	}
//	
//	//GET
//	@GetMapping()
//	public Pessoa obterPessoaPorId(Integer idPessoa) {
//		//"Informações da Pessoa de id XX foram recuperadas com sucesso.";
//	}
//	
//	//GET
//	@GetMapping("/listar-dados")
//	public Pessoa listar(Integer idPessoa) {
//		//"Informações da Pessoa de id XX foram recuperadas com sucesso.";
//	}
//	
//	//PATCH
//	@GetMapping()
//	public void atualizarStatus(Pessoa pessoa) {
//		//"Informações do status do cadastro da Pessoa atualizadas com sucesso.";
//	}

}
