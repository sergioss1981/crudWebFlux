package br.com.sergio.desafio.procer.facade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.sergio.desafio.procer.entity.Pessoa;
import br.com.sergio.desafio.procer.service.PessoaService;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
public class PessoaFacadeTest {

	@Mock
	PessoaService pessoaService;
	
	@InjectMocks
	PessoaFacade pessoaFacade;

    @Test
    void deveRetornarListaPessoa() {
        final var pessoa = new Pessoa();
        final var pessoaEsperada = pessoa;
        Mockito.when(pessoaService.findAll()).thenReturn(Flux.just(pessoa));

        StepVerifier.create(pessoaFacade.findAll())
                .assertNext(response -> Assertions.assertEquals(pessoaEsperada, response))
                .verifyComplete();
    }
}
