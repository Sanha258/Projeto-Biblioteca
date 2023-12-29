package biblioteca;

import  java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;

public class Biblioteca {
	
	private String nome;
	private Obra[] listaObras;
	private Endereco enderecoBiblioteca;
	
	public Biblioteca(String nome, Obra[] listaObras, Endereco enderecoBiblioteca) {
		super();
		this.nome = nome;
		this.listaObras = listaObras;
		this.enderecoBiblioteca = enderecoBiblioteca;
	}

	public Biblioteca() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Obra[] getListaObras() {
		return listaObras;
	}

	public void setListaObras(Obra[] listaObras) {
		this.listaObras = listaObras;
	}

	public Endereco getEnderecoBiblioteca() {
		return enderecoBiblioteca;
	}

	public void setEnderecoBiblioteca(Endereco enderecoBiblioteca) {
		this.enderecoBiblioteca = enderecoBiblioteca;
	}

	public int contabilizarObras() {
		return this.getListaObras().length;
	}

	public Obra identificarObraMaisAntiga() {
		Obra maisAntiga = this.getListaObras()[0];
		for(Obra obra: this.getListaObras()) {
			if(obra.getDataPublicacao().isBefore(maisAntiga.getDataPublicacao())) {
				maisAntiga = obra;
			}
		}
		return maisAntiga;
	}

	public Autor identificarAutorMaisNovo() {
		Autor autorMaisNovo = this.getListaObras()[0].getAutor();
		for(int i = 0; i < this.getListaObras().length; i++) {
			if(this.getListaObras()[i].getAutor().getDataNascimento()
					.isAfter(autorMaisNovo.getDataNascimento())) {
				autorMaisNovo = this.getListaObras()[i].getAutor();
			}
		}
		return autorMaisNovo;
	}
	
	public Autor identificarAutorMaisIdoso() {
		Autor autorMaisIdoso = this.getListaObras()[0].getAutor();
		for(int i = 0; i < this.getListaObras().length; i++) {
			if(this.getListaObras()[i].getAutor().getDataNascimento().isBefore(autorMaisIdoso.getDataNascimento())) {
				autorMaisIdoso = this.getListaObras()[i].getAutor();
			}
		}
		return autorMaisIdoso;
	}

	public void identificarDiferencaIdadeAutorMaisNovoAutorMaisVelho() {
		Autor maisNovo = this.identificarAutorMaisNovo();
		Autor maisIdoso = this.identificarAutorMaisIdoso();
		Period diferenca = Period.between(maisIdoso.getDataNascimento(), maisNovo.getDataNascimento());
		System.out.println("A diferença é de " + diferenca.getYears() + " anos, " 
		+ diferenca.getMonths() + " meses e " + diferenca.getDays() + " dias.");
	}

	public void localizarEnderecoAutor(String nomeAutor) {
		Autor autor = null;
		for(int i = 0; i < this.getListaObras().length; i++) {
			if(this.getListaObras()[i].getAutor().getNome().equals(nomeAutor)) {
				autor = this.getListaObras()[i].getAutor();
			}
		}
		if(autor != null) {
			System.out.println("Endereço do(a) autor(a): " + nomeAutor);
			System.out.println(autor.getEnderecoAutor());
		} else {
			System.out.println("Autor não localizado!");
		}
		
	}

	public void localizarAutoresPorCidade(String cidade) {
		System.out.println("Lista de autores que moram em: " + cidade);
		for(Obra obra: this.getListaObras()) {
			if(obra.getAutor().getEnderecoAutor().getCidade().equals(cidade)) {
				System.out.println(obra.getAutor().getNome());
			}
		}
	}
	
	public void localizarAutoresPorCidade2(String cidade) {
		HashSet<String> listaNomes = new HashSet<String>();
		for(Obra obra: this.getListaObras()) {
			if(obra.getAutor().getEnderecoAutor().getCidade().equals(cidade)) {
				listaNomes.add(obra.getAutor().getNome());
			}
		}
		if(listaNomes.isEmpty()) {
			System.out.println("Não foram encontrados autores que moram na cidade: " 
					+ cidade);
		} else {
			System.out.println("Autores que moram na cidade: " + cidade);
			for(String nome: listaNomes) {
				System.out.println(nome);
			}
		}
	}

}
