package br.com.mvc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.mvc.model.Pessoa;

@Named("bean")
@SessionScoped
public class PessoaMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pessoa pessoa = new Pessoa();

	private List<Pessoa> pessoas = new ArrayList<>();

	public String adicionar() {
		System.out.println("Pessoa: " + pessoa.getNome());
		
		if (pessoa.getNome()== null || pessoa.getNome().equals("")) {
			return "null";
		}

		if (pessoa.getNome().length() > 0) {
			pessoas.add(pessoa);
		}

		limpar();

		return "null";
	}
	
	public String goToDetails(String nome){
	    return "paginas/sucesso?faces-redirect=true&user=" + nome;
	}
	
	private void limpar() {
		pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
}
