package br.com.sergio.desafio.procer.model;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import br.com.sergio.desafio.procer.entity.Pessoa;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
	
	void pessoaFromDto(PessoaDTO dto, @MappingTarget Pessoa entity);

	void dtoFromPessoa(Pessoa entity, @MappingTarget PessoaDTO dto);
}
