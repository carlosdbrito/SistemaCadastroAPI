package com.almeidabrito.sistemacadastro.exception;

public class ContatoNotFoundException extends Exception {
    public ContatoNotFoundException(Long id) {
        super(ContatoNotFoundException.defaultMessage(id));
        
    }
    private static String defaultMessage(Long id){
        return String.format("Contato com o Id %s não localizado na base de dados.", id.toString());
    }
}
