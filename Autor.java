package biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Autor {
	
	private String nome;
	private LocalDate dataNascimento;
	private Endereco enderecoAutor;
	
	public Autor(String nome, LocalDate dataNascimento, Endereco enderecoAutor) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.enderecoAutor = enderecoAutor;
	}

	public Autor() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Endereco getEnderecoAutor() {
		return enderecoAutor;
	}

	public void setEnderecoAutor(Endereco enderecoAutor) {
		this.enderecoAutor = enderecoAutor;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Nome: " + this.getNome() 
			+ "\nData de Nascimento: " + formatador.format(this.getDataNascimento()) 
			+ "\nEndereco \n" + this.getEnderecoAutor();
	}
	
	

}
