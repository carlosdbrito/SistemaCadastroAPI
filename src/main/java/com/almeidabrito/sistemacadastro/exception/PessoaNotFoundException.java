package com.almeidabrito.sistemacadastro.exception;

public class PessoaNotFoundException extends Exception {
    public PessoaNotFoundException(Long id) {
        super(PessoaNotFoundException.defaultMessage(id));
    }
    private static String defaultMessage(Long id){
        return String.format("Pessoa com o id %s não localizada na base de dados.", id.toString());
    }
}

