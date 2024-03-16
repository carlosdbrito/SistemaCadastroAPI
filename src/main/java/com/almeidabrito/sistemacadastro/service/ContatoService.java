package com.almeidabrito.sistemacadastro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.almeidabrito.sistemacadastro.exception.ContatoNotFoundException;
import com.almeidabrito.sistemacadastro.model.Contato;
import com.almeidabrito.sistemacadastro.model.Pessoa;
import com.almeidabrito.sistemacadastro.repository.ContatoRepository;
import com.almeidabrito.sistemacadastro.service.interfaces.ContatoServiceInterface;



@Service
public class ContatoService implements ContatoServiceInterface {

    private ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @SuppressWarnings("null")
    @Override
    public Contato adicionarContato(Contato contato) {
        System.out.println("======= ContatoService.adicionarContato() =======");
        Contato contatoOut = contatoRepository.save(contato);
        System.out.println("=================================================");
        return contatoOut;
    }

    @SuppressWarnings("null")
    @Override
    public Optional<Contato> obterContatoPorId(Long contatoId) throws ContatoNotFoundException  {
        System.out.println("======= ContatoService.obterContatoPorId() =======");
        contatoId= Contato.checkNull(contatoId);
        Optional<Contato> findContato = contatoRepository.findById(contatoId);
        if(findContato.isPresent()){
            return findContato;
        }
        else{
            System.out.println("=====================");
            throw new ContatoNotFoundException(contatoId);
        }
    }

    @Override
    public List<Contato> listarContatos(Pessoa pessoa) {
        System.out.println("<<<<<<<<<<  ContatoService.listarContatos()   <<<<<<<<<<<<<<<<<<<");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        return contatoRepository.findAll()
                                .stream()
                                .filter(contact-> contact.getPessoa().getId() == pessoa.getId())
                                .toList();


    }

    @Override
    public Contato atualizarContato(Contato contato) throws ContatoNotFoundException {
        System.out.println("<<<<<<<<<<  ContatoService.atualizarContato()   <<<<<<<<<<<<<<<<<<<");
        Long contatoId = contato.getId();
        @SuppressWarnings("null")
        Optional<Contato> findContato = contatoRepository.findById(contatoId);
		
		//se ele existir, vou atualizar:
		if(findContato.isPresent()) {
            Contato updateContato = findContato.get(); //setId
			updateContato.setTipoContato(contato.getTipoContato());
			updateContato.setContato(contato.getContato());
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			return contatoRepository.save(updateContato);
		}
        else{
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            throw new ContatoNotFoundException(contatoId);
        }
    }

    @SuppressWarnings("null")
    @Override
    public void delete(Long id) {
        System.out.println("<<<<<<<<<<  ContatoService.delete()   <<<<<<<<<<<<<<<<<<<");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        contatoRepository.deleteById(id);
    }

}
