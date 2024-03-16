package com.almeidabrito.sistemacadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almeidabrito.sistemacadastro.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
