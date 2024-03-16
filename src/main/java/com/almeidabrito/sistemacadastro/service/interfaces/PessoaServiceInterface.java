package com.almeidabrito.sistemacadastro.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.almeidabrito.sistemacadastro.dto.PessoaDto;
import com.almeidabrito.sistemacadastro.exception.PessoaNotFoundException;
import com.almeidabrito.sistemacadastro.model.Contato;
import com.almeidabrito.sistemacadastro.model.Pessoa;

public interface PessoaServiceInterface {
    Pessoa criarPessoa(Pessoa pessoa);
    Optional<Pessoa> obterPessoaPorId(Long id) throws PessoaNotFoundException ;
    Pessoa addContato(Long id, Contato contato) throws PessoaNotFoundException ;
	List<Pessoa> listarPessoas();
	Pessoa atualizar(Pessoa pessoa) throws PessoaNotFoundException ;
	void delete(Long id);
	List<PessoaDto> buildMalaDireta(Long id) throws PessoaNotFoundException ;
}
