package marketplace.bacoDeDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import marketplace.cliente.Usuario;
import marketplace.cliente.UsuarioCliente;
import marketplace.produto.Anuncio;


import marketplace.produto.Produto;

/**
 * A classe BancoDeDados é uma simulacao de um banco de dados real. quando a classe BancoDeDados é 		 
 *  instanciada em outra cria uma lista de usuarios e lista de anuncios para usar.
 */

public class BancoDeDados {
	//instancia usuarios e anuncios.
	
	
									/*nome, sobreNome, cpf, cep, email, ddd, telefone, senha, administrador */
	UsuarioCliente usuario1 = new UsuarioCliente("Guilherme", "Nascimento", "12345678999", "12345678", "email1", "75",
			"992395099", "4444", false);
	UsuarioCliente usuario2 = new UsuarioCliente("Daniel", "Maia", "12345678999", "12345678", "email2", "75", "992395099",
			"4444", false);
	UsuarioCliente usuario3 = new UsuarioCliente("Thiago", "Macuca", "12345678999", "12345678", "email3", "73",
			"992395099", "4444", false);
	UsuarioCliente usuario4 = new UsuarioCliente("Joao Pedro", "Daltro", "12345678999", "12345678", "email4", "75",
			"992395099", "4444", true);

				// NomeProduto, precoProduto, hospedes, codigo, anunciante, casa, quarto, hotel, pousada		
	Produto produto1 = new Produto("Casa cruz", 150, 2, 0, usuario1, true, false, false, false);
	Produto produto2 = new Produto("Quarto cruz", 100, 1, 1, usuario1, false, true, false, false);
	Produto produto3 = new Produto("Hotel cruz", 200, 4, 2, usuario1, false, false, true, false);
	Produto produto4 = new Produto("Pousada cruz", 200, 4, 3, usuario1, false, false, false, true);
	Produto produto9 = new Produto("Casa azul", 350, 2, 4, usuario1, true, false, false, false);
	Produto produto10 = new Produto("Quarto verde", 300, 1, 5, usuario1, false, true, false, false);
	Produto produto11 = new Produto("Hotel branco", 200, 4, 6, usuario1, false, false, true, false);

	
				// NomeProduto, precoProduto, hospedes, codigo, anunciante, casa, quarto, hotel, pousada	
	Produto produto5 = new Produto("Casa Alagoinhas", 250, 2, 7, usuario2, true, false, false, false);
	Produto produto6 = new Produto("Quarto Alagoinhas", 200, 1, 8, usuario2, false, true, false, false);
	Produto produto7 = new Produto("Hotel Alagoinhas", 400, 4, 9, usuario2, false, false, true, false);
	Produto produto8 = new Produto("Pousada Alagoinhas", 100, 4, 10, usuario2, false, false, false, true);
	Produto produto12 = new Produto("Pousada dos estudantes", 200, 4, 11, usuario2, false, false, false, true);
	Produto produto13 = new Produto("Casa dos universitários", 350, 2, 12, usuario2, true, false, false, false);
	Produto produto14 = new Produto("Quarto Salvador", 300, 1, 13, usuario2, false, true, false, false);



	// 			NomeProduto, precoProduto, hospedes, codigo, anunciante, casa, quarto, hotel, pousada	
	Produto produto15 = new Produto("Hotel SAJ", 200, 4, 14, usuario3, false, false, true, false);
	Produto produto16 = new Produto("Pousada SAJ", 200, 4, 15, usuario3, false, false, false, true);
	Produto produto17 = new Produto("Casa SAJ", 350, 2, 16, usuario3, true, false, false, false);
	Produto produto18 = new Produto("Quarto SAJ", 300, 1, 17, usuario3, false, true, false, false);
	Produto produto19 = new Produto("Hotel SAJ", 200, 4, 18, usuario3, false, false, true, false);
	Produto produto20 = new Produto("Pousada SAJ", 200, 4, 19, usuario3, false, false, false, true);
	Produto produto21 = new Produto("Pousada SAJ", 200, 4, 20, usuario3, false, false, false, true);




	//adicionar os produtos ea usuarios nas listas listUsuario e listAnuncio.
	private List<Usuario> listUsuario = new ArrayList<>(Arrays.asList(usuario1,usuario2,usuario3,usuario4));
	private List<Anuncio> listAnuncio = new ArrayList<>(Arrays.asList(produto1,produto2,produto3,produto4,produto5,produto6,produto7,produto8,produto9,produto10,produto11,produto12,produto13,produto14,produto15,produto16,produto17,produto18,produto19,produto20,produto21));

	public BancoDeDados() {
	}

	public BancoDeDados(List<Usuario> listUsuario, List<Anuncio> listAnuncio) {

		this.listUsuario = listUsuario;
		this.listAnuncio = listAnuncio;

	}

	public List<Usuario> getListUsuario() {
		return listUsuario;
	}

	public List<Anuncio> getListAnuncio() {
		return listAnuncio;
	}

	// adiconar usuario ao banco de dados
	public void adiconarUsuario(Usuario usuario) {
		this.listUsuario.add(usuario);

	}

	// adiconar anuncio ao banco de dados
	public void adicionarAnuncio(Anuncio anuncio) {
		this.listAnuncio.add(anuncio);
	}

	// remove o anuncio do banco de dados
	public void removeAnuncio(Anuncio anuncio){

		this.listAnuncio.remove(anuncio);
	}
}