 package biblioteca;

import java.time.LocalDate;

public class ProgramaBiblioteca {

	public static void main(String[] args) {
		
		Endereco endCarlos = new Endereco("Rua das Maças", 100, "Ingleses", "Florianópolis", "SC");
		Endereco endMachado = new Endereco("Rua das Laranjas", 200, "Aririu", "Palhoça", "SC");
		Endereco endCecilia = new Endereco("Rua das Uvas", 300, "Pedra Branca", "Palhoça", "SC");
		Endereco endOsvald = new Endereco("Rua das Melancias", 400, "Estreito", "Florianópolis", "SC");
		
		LocalDate nascimentoCarlos = LocalDate.of(1946,  10, 01);
		Autor carlos = new Autor("Carlos Drummond", nascimentoCarlos, endCarlos);
		LocalDate nascimentoMachado = LocalDate.of(1915,  03, 15);
		Autor machado = new Autor("Machado de Assis", nascimentoMachado, endMachado);
		
		Autor cecilia = new Autor("Cecilia Meireles", LocalDate.of(1927,  05, 21), endCecilia);
		Autor osvald = new Autor("Oscald Andrade", LocalDate.of(1934,  06, 04), endOsvald);
		
		
		LocalDate pubRevistaCarlos = LocalDate.of(2012, 12, 01);
		Revista revistaCarlos = new Revista("Veja", 60, pubRevistaCarlos, carlos);
		LocalDate pubRevistaMachado = LocalDate.of(2013, 06, 01);
		Revista revistaMachado = new Revista("Isto É", 80, pubRevistaMachado, machado);
		
		Revista revistaCecilia = new Revista("Auto Esporte", 20, LocalDate.of(2011, 9, 01), cecilia);
		Revista revistaOsvald = new Revista("Super Interessante", 100, LocalDate.of(2010, 4, 01), osvald);
		
		
		LocalDate pubLivroCarlos = LocalDate.of(1983, 01, 30);
		Livro livroCarlos = new Livro("Brejo das Almas", 8, pubLivroCarlos, carlos);
		LocalDate pubLivroMachado = LocalDate.of(1892, 05, 13);
		Livro livroMachado = new Livro("Quincas Borba", 1, pubLivroMachado, machado);
		
		Livro livroCecilia = new Livro("Colar de Carolina", 3, LocalDate.of(1934, 11, 20), cecilia);
		Livro livroOsvald = new Livro("Os Condenados", 7, LocalDate.of(1941, 07, 28), osvald);
		
		Obra[] obras = {revistaCarlos, revistaMachado, revistaCecilia, revistaOsvald, 
				livroCarlos, livroMachado, livroCecilia, livroOsvald};
		Endereco endBiblioteca = new Endereco("Rua das Mangas", 600, "Centro", "Florianópolis", "SC");
		Biblioteca biblio = new Biblioteca("Biblioteca Central", obras, endBiblioteca);
		
		
		//3-A
		int total = biblio.contabilizarObras();
		System.out.println("O total de obras da biblioteca é: " + total);
		System.out.println("------------------------\n");
		
		//3-B
		System.out.println("A obra mais antiga da biblioteca é: \n" + biblio.identificarObraMaisAntiga());
		System.out.println("------------------------\n");
		
		//3-C
		Autor autorMaisNovo = biblio.identificarAutorMaisNovo();
		System.out.println("O autor mais jovem é: \n" + autorMaisNovo);
		System.out.println("------------------------\n");
		
		//3-D
		biblio.identificarDiferencaIdadeAutorMaisNovoAutorMaisVelho();
		System.out.println("------------------------\n");
		
		//3-E
		biblio.localizarEnderecoAutor("Cecilia Meireles");
		System.out.println("------------------------\n");
		
		//3-F
		biblio.localizarAutoresPorCidade("Palhoça");
		System.out.println("------------------------\n");
		
		biblio.localizarAutoresPorCidade2("Palhoça");
		System.out.println("------------------------\n");
		
	}

}
