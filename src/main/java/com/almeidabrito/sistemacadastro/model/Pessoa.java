package com.almeidabrito.sistemacadastro.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="pessoa")
public class Pessoa {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    @NotNull(message = "Nome é obrigatório.")
    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @Column(name = "logradouro", nullable = true)
    @NotNull(message = "Obrigatório informar o endereço.")
    @NotBlank(message = "Obrigatório informar o endereço.")
    private String endereco;

    @Column(name = "cep", nullable = true, length = 10)
    @Size(min = 10, message = "O cep deve ser informado no formato '00.000-000'")
    @Size(max = 10, message = "O cep deve ser informado no formato '00.000-000'")
    private String cep;

    @Column(name = "municipio", nullable = true)
    private String cidade;

    @Column(name = "uf", nullable = true, length = 2)
    @Size(min = 2, message = "UF é obrigatorio e deve ter 2 caracteres")
    @Size(max = 2, message = "UF é obrigatorio e deve ter 2 caracteres")
    private String uf;

    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "contato", targetEntity = Contato.class)
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa", targetEntity = Contato.class)
    private List<Contato> contatos;
   
    public Pessoa() {
    }

    public Pessoa( String nome, String endereco, String cep, String cidade, String uf) {
        // this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }

    @Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}

    @Override
    public String toString(){
        return String.format("[id: %s, nome: %s, endereco: %s, cep: %s, cidade: %s, uf: %s]", this.id, this.nome, this.endereco, this.cep, this.cidade, this.uf);
    }

    //#region Setters and Getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }
    //#endregion
    
}
