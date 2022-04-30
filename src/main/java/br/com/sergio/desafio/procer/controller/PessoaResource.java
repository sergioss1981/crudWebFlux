package br.com.sergio.desafio.procer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

	/**
	 * Implementar endpoints para Cadastrar, Atualizar, Obter dados por Id, Listar Dados paginado e atualizar status de ativo/inativo (true/false);
	 * @return
	 */
	
	@GetMapping(value = "/hello")
	public String getHelloWorld() {
		return "H E L L O   W O R L D !!!  Ihuuuuuuu!!!  T� no ar!";
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
//		//"Informa��es da Pessoa atualizadas com sucesso.";
//	}
//	
//	//GET
//	@GetMapping()
//	public Pessoa obterPessoaPorId(Integer idPessoa) {
//		//"Informa��es da Pessoa de id XX foram recuperadas com sucesso.";
//	}
//	
//	//GET
//	@GetMapping("/listar-dados")
//	public Pessoa listar(Integer idPessoa) {
//		//"Informa��es da Pessoa de id XX foram recuperadas com sucesso.";
//	}
//	
//	//PATCH
//	@GetMapping()
//	public void atualizarStatus(Pessoa pessoa) {
//		//"Informa��es do status do cadastro da Pessoa atualizadas com sucesso.";
//	}

}
