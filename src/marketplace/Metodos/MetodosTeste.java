package marketplace.Metodos;

import java.util.List;

import marketplace.bacoDeDados.BancoDeDados;
import marketplace.cliente.Usuario;
import marketplace.cliente.UsuarioCliente;
import marketplace.produto.Anuncio;
import marketplace.produto.Produto;

public class MetodosTeste {

	public MetodosTeste() {
	}

	/* método para exibir todos anúncio para um cliente */
	public void exibirAnuncio(BancoDeDados dados) {

		for(Anuncio a: dados.getListAnuncio()) {
			System.out.println(a.getNomeProduro());
		}

	}

	/* exibe detalhes do aúncio para um cliente
	 *detalhes como a categoria do anúcio e seu anunciante */
	public void exibirDetalhesDeAnuncio(BancoDeDados dados) {

		for(Anuncio a: dados.getListAnuncio()) {
			System.out.println(a);
		}

	}

	/* cria uma conta para um usuário */
	public void criarConta(BancoDeDados dados, UsuarioCliente cliente) {
		
		/* adiciona o cliente na list */
		dados.adiconarUsuario(cliente );
	}

	/* método para o usuário entrar na sua conta */
	public UsuarioCliente entrarNaConta(BancoDeDados dados,UsuarioCliente client) {
		
		int x = 0;

		/* verifica se  o email e a senha informados pelo usuário são 
		 * correspondende  a uma conta existente, se sim, usuário entra na conta
		 */
		for (Usuario usuarioDaLista : dados.getListUsuario()) {
			
			if (client.getEmail().equals(usuarioDaLista.getEmail()) && client.getSenha().equals(usuarioDaLista.getSenha()) && client.getAdministrador()==false) {
				System.out.println("bem vindo " + usuarioDaLista.getNome());
				client = (UsuarioCliente) usuarioDaLista;
				client.logado();
			}
		}
		return client;
	}

	/* cadastra um anúncio */
	public Produto cadastrarAnuncio(BancoDeDados dados, UsuarioCliente usuarioCliente, Produto produto) {

		/* adiciona produto na list */
		dados.adicionarAnuncio(produto);
		
		/* retorna produto */
		return produto;
		
	}

	/* lista produtos cadastrados pelo próprio usuário */
	public void ListarMeusAnuncios(BancoDeDados dados, UsuarioCliente cliente) {

		for (Anuncio anuncio : dados.getListAnuncio()) {
			if (anuncio.getAnunciante() == cliente) {
				System.out.println(anuncio);
			}
		}
	}

	/* edita um produto cadastrado por um usuário */
	public void editarAnuncio(BancoDeDados dados, UsuarioCliente usuarioCliente,Produto produto) {
	
		/* verifica se o código informado correspode
		 * a um produto cadastrado, se sim, pede novas 
		 * informações do produto
		 */
		for (int x = 0; x < dados.getListAnuncio().size(); x++) {

			if (111 == dados.getListAnuncio().get(x).getCodigo()) {
				
				dados.getListAnuncio().set(x, produto);
			
			}
		}
	}

	/*exclui um produto cadastrado por um usuário */
	public void excluirAnuncio(BancoDeDados dados,Produto produto) {
	
		/* verifica se o código informado correspode
		 * a um produto cadastrado, se sim, exclui o produto 
		 */
		for (int a = 0; a < dados.getListAnuncio().size(); a++) {

			if (produto.getCodigo() == dados.getListAnuncio().get(a).getCodigo()) {
				
				dados.removeAnuncio(dados.getListAnuncio().get(a));
				System.out.println("Anuncio excluido");
			}
		}
	}

	/*entra na conta do usuário administrador */
	public UsuarioCliente entrarNaContaAdministrador(BancoDeDados dados,UsuarioCliente adm) {

		/* verifica se  o email e a senha informados pelo usuário são 
		 * correspondende  a uma conta existente e se o usuário é 
		 * administrador, se sim, usuário entra na conta
		 */
		for (Usuario usuarioDaLista : dados.getListUsuario()) {

			if (adm.getEmail().equals(usuarioDaLista.getEmail()) && adm.getSenha().equals(usuarioDaLista.getSenha())
					&& usuarioDaLista.getAdministrador() == true) {

				System.out.println("bem vindo " + usuarioDaLista.getNome());
				adm = (UsuarioCliente) usuarioDaLista;
				adm.logado();
			}
		}
		return (UsuarioCliente) adm;
	}

	/* lista todos os usuários */
	public void VerListaDeUsuario(BancoDeDados dados) {

		for(Usuario a: dados.getListUsuario()) {
			System.out.println(a);
		
		}
	}
}