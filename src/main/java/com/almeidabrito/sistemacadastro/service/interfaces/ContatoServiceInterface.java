package com.almeidabrito.sistemacadastro.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.almeidabrito.sistemacadastro.exception.ContatoNotFoundException;
import com.almeidabrito.sistemacadastro.model.Contato;
import com.almeidabrito.sistemacadastro.model.Pessoa;

public interface ContatoServiceInterface {
    Contato adicionarContato(Contato contato);
    Optional<Contato> obterContatoPorId(Long contatoId) throws ContatoNotFoundException ;
	List<Contato> listarContatos(Pessoa pessoa);
	Contato atualizarContato(Contato contato) throws ContatoNotFoundException;
	void delete(Long id);
}
