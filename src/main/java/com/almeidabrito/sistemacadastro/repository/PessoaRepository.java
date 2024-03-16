package com.almeidabrito.sistemacadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.almeidabrito.sistemacadastro.model.Pessoa;
import com.almeidabrito.sistemacadastro.dto.PessoaDto;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(name = "build_pessoa_dto" , nativeQuery=true)
    List<PessoaDto> buildMalaDireta(Long id);
}
