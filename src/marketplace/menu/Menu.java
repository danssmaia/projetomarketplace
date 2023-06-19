package marketplace.menu;

import java.util.Scanner;

import marketplace.Metodos.Metodos;
import marketplace.bacoDeDados.BancoDeDados;
import marketplace.cliente.UsuarioCliente;
import marketplace.produto.Produto;

/**
 * Classe que cria os menus 
 */

public class Menu {

	private Metodos metodo = new Metodos();
	private BancoDeDados bancoDeDados = new BancoDeDados();
	private UsuarioCliente usuarioCliente = new UsuarioCliente();
	private Produto produto = new Produto();

	
	public Menu() {
	}

	/* Cria menu visitante */
	public void menuVisitante() {
		
		Scanner opcao = new Scanner(System.in);

		InterfaceDeTexto interfaceDeTexto = new InterfaceDeTexto();
		int status = 1;

		while (status != 0) {

			/* chama duas interfaces de texto */
			interfaceDeTexto.textoDeBoasVindas();
			interfaceDeTexto.textoMenuVisitante();

			int op = opcao.nextInt();
			opcao.nextLine();

			switch (op) {

				/* se o usuário escolheu a opção 1 chama o método exibir anúncio */
				case 1:
					metodo.exibirAnuncio(this.bancoDeDados);
					break;
				/* se o usuário escolheu a opção 2 chama o método exibir detalhes anúncio */
				case 2:
					metodo.exibirDetalhesDeAnuncio(this.bancoDeDados);
					break;
				/* se o usuário escolheu a opção 3 chama o método criar conta */
				case 3:
					metodo.criarConta(this.bancoDeDados, this.usuarioCliente);
					break;
				/* se o usuário escolheu a opção 4 verifica se ele está autenticado e
				 * chama os método para entra na conta e menu do usuário autenticado 
				 */
				case 4:
					this.usuarioCliente = metodo.entrarNaConta(this.bancoDeDados, this.usuarioCliente);
					if (this.usuarioCliente.isAutenticado() == true) {
						menuUsuarioAutenticado();
					}
					break;
				/* se o usuário escolheu a opção 5 verifica se ele é o administrador 
				 * e chama os método para entra na conta e menu do usuário administrador 
				 */
				case 5:
					this.usuarioCliente = metodo.entrarNaContaAdministrador(this.bancoDeDados, this.usuarioCliente);
					if (this.usuarioCliente.isAutenticado() == true) {
						menuAdministrador();
					}
					break;
				/* se o usuário escolheu a opção 6 verifica se chama o método de mensagem de 
				 * saída do app e encerra o programa
		         */
				case 6:
					interfaceDeTexto.textoDeSaidaDoApp();
					System.exit(0);
					break;
				/* se o usuário escolheu uma opção inválida chma o método de mensagem de
				 * opção inválida e chama o menu do visitante
				 */
				default:
					interfaceDeTexto.mensagemDeOpcaoInvalidaDeMenu();
					menuVisitante();
			}
			
		}
	}

	/* método do meu do usuário autenticado */
	public void menuUsuarioAutenticado() {

		Scanner opcao = new Scanner(System.in);

		InterfaceDeTexto interfaceDeTexto = new InterfaceDeTexto();
		int status = 1;

		while (status != 0) {

			/* chama uma interface de texto */
			interfaceDeTexto.textoMenuUsuarioAuntenticado();

			int op = opcao.nextInt();
			opcao.nextLine();

			switch (op) {

				/* se o usuário escolheu a opção 1 chama o método de cadastrar anúncio */
				case 1:
					this.bancoDeDados.adicionarAnuncio(metodo.cadastrarAnuncio(this.bancoDeDados, this.usuarioCliente, this.produto));
					break;
				/* se o usuário escolheu a opção 2 chama o método de listar os anúncios cadastrado pelo usuário */
				case 2:
					metodo.ListarMeusAnuncios(this.bancoDeDados, this.usuarioCliente);
					break;
				/* se o usuário escolheu a opção 3 chama o método de editar anúncio */
				case 3:
					metodo.editarAnuncio(this.bancoDeDados, this.usuarioCliente, this.produto);
					break;
				/* se o usuário escolheu a opção 4 chama o método de excluir anúncio*/
				case 4:
					metodo.excluirAnuncio(this.bancoDeDados, this.produto);
					break;
				/* se o usuário escolheu a opção 5 chama o método ede voltar para o menu visitante */
				case 5:
					menuVisitante();
					break;
				/* se o usuário escolheu a opção 6 encerra o programa */
				case 6:
					interfaceDeTexto.textoDeSaidaDoApp();
					System.exit(0);
					break;
				/* se o usuário escolheu uma opção inválida chma o método de mensagem de
				 * opção inválida e chama o menu do usuário autenticado
				 */
				default:
					interfaceDeTexto.mensagemDeOpcaoInvalidaDeMenu();
					menuUsuarioAutenticado();
					break;
			}
			
		}

	}

	/* método do menu do usuário administrador */
	public void menuAdministrador() {

		
		Scanner opcao = new Scanner(System.in);

		InterfaceDeTexto interfaceDeTexto = new InterfaceDeTexto();
		int status = 1;

		while (status != 0) {

			interfaceDeTexto.textoMenuAdministrador();

			int op = opcao.nextInt();
			opcao.nextLine();

			switch (op) {

				/* se o usuário escolheu a opção 1 chama o método de listar todos os usuário */
				case 1:
					metodo.VerListaDeUsuario(this.bancoDeDados);
					break;
				/* se o usuário escolheu a opção 2 voltar para o menu do visitante */
				case 2:
					menuVisitante();
					break;
				/* se o usuário escolheu a opção 3 encerra o programa*/
				case 3:
					interfaceDeTexto.textoDeSaidaDoApp();
					System.exit(0);
					break;
				/* se o usuário escolheu uma opção inválida volta para o menu do administrador*/
				default:
					interfaceDeTexto.mensagemDeOpcaoInvalidaDeMenu();
					menuAdministrador();
			}
		}
	}
}
