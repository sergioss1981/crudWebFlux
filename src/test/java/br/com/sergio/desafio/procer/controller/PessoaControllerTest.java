package br.com.sergio.desafio.procer.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.sergio.desafio.procer.entity.Pessoa;
import br.com.sergio.desafio.procer.facade.PessoaFacade;
import reactor.core.publisher.Flux;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = PessoaController.class)
@Import(PessoaFacade.class)
public class PessoaControllerTest {

	@MockBean
	PessoaFacade pessoaFacade;
	
	@Autowired
	WebTestClient clientWebTest;
	
	@Autowired
	ApplicationContext applicationContext;
	
	@BeforeEach
	public void setup() {
		this.clientWebTest = WebTestClient.bindToApplicationContext(applicationContext).configureClient().build();
	}
	
//	@Test
//	void deveRetornar2xxAoSalvar(){
//		final var pessoa = new Pessoa();
//		when(pessoaFacade.save(pessoa)).thenReturn(null);
//		
//		clientWebTest.get().uri("/procer/pessoa").header("User-Agent", "PostmanRuntime/7.26.10").header("X-Forwarded-For", "1")
//		.accept(MediaType.APPLICATION_JSON).exchange().expectStatus().is2xxSuccessful();
//	}
	
	@Test
	void deveRetornar2xxAoBuscarTodos(){
		final var pessoa = new Pessoa();
		when(pessoaFacade.findAll()).thenReturn(Flux.just(pessoa));
		
		clientWebTest.get().uri("/procer/pessoa").header("User-Agent", "PostmanRuntime/7.26.10").header("X-Forwarded-For", "1")
        	.accept(MediaType.APPLICATION_JSON).exchange().expectStatus().is2xxSuccessful();
	}
	
}
