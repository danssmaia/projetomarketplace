package marketplace.Metodos;

import java.util.Scanner;

import marketplace.bacoDeDados.BancoDeDados;
import marketplace.cliente.Usuario;
import marketplace.cliente.UsuarioCliente;
import marketplace.menu.InterfaceDeTexto;
import marketplace.produto.Anuncio;
import marketplace.produto.Produto;

/**
 *  Classe que cria os métodos 
 */

public class Metodos {

	public Metodos() {
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
	public void criarConta(BancoDeDados dados,UsuarioCliente cliente) {

		Scanner entrada = new Scanner(System.in);
		
		boolean continueLoop = true;

		System.out.println("Vamos criar uma conta");
		System.out.println("Digite o nome");
		cliente.setNome(entrada.nextLine());
		System.out.println("Digite o sobre nome");
		cliente.setSobreNome(entrada.nextLine());

	
		/* pede dados ao usuário e trata as exceções */

		do {

			try {
				System.out.println("Digite o cpf");
				cliente.setCpf(entrada.nextLine());
				continueLoop = false;

			} catch (IllegalArgumentException e) {
				
				System.out.println("CPF deve ter 11 d�gitos");
			}

		} while (continueLoop);

		continueLoop = true;
		do {

			try {

				System.out.println("Digite o cep");
				cliente.setCep(entrada.nextLine());
				continueLoop = false;

			} catch (IllegalArgumentException e) {

				System.out.println("CEP deve ter 8 d�gitos");

			}

		} while (continueLoop);

		System.out.println("Digite o email");
		
		String email = entrada.nextLine();

		int contador1;

		/* verifica se o email informado pelo usuário já é usado por um outro usuário */
		for(int contador2 = 0; contador2  < dados.getListUsuario().size(); contador2 ++){

			contador1 = 0;
			while(contador1 <= contador2 ){
				if(dados.getListUsuario().get(contador1).getEmail().equals(email)){

					System.out.println("Este email já exite");
					System.out.println("Digite o email");
					email = entrada.nextLine();
					contador1 = 0;
				}else{

					contador1++;
				}
			}
			cliente.setEmail(email);	
		}
			
		continueLoop = true;
		do {
			try {

				System.out.println("Digite o ddd");
				cliente.setDdd(entrada.nextLine());
				continueLoop = false;

			} catch (IllegalArgumentException e) {
				
				System.out.println("DDD deve ter 2 d�gitos");
			}
		} while (continueLoop);

		continueLoop = true;
		do {

			try {

				System.out.println("Digite o telfone");
				cliente.setTelefone(entrada.nextLine());
				continueLoop = false;

			} catch (IllegalArgumentException e) {
				
				System.out.println("N�mero de telegone deve ter 9 d�gitos");
			}

		} while (continueLoop);

		continueLoop = true;
		do {

			try {

				System.out.println("Digite o a senha");
				cliente.setSenha(entrada.nextLine());
				continueLoop = false;

			} catch (IllegalArgumentException e) {
				
				System.out.println("A senha deve ter no m�nimo 4 d�gitos");
			}

		} while (continueLoop); // fim dos tratamento de exceções

		/* adiciona o novo usuário na list de usuário */
		dados.adiconarUsuario(cliente);
		System.out.println("Voltar para o menu");
	}

	/* método para o usuário entrar na sua conta */
	public UsuarioCliente entrarNaConta(BancoDeDados dados,UsuarioCliente cliente) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Entre em tua conta");
		System.out.println("Digite teu email");
		String login = scan.nextLine();
		System.out.println("Digite a senha");
		String senha = scan.nextLine();
	
		int x = 0;

		/* verifica se  o email e a senha informados pelo usuário são 
		 * correspondende  a uma conta existente, se sim, usuário entra na conta
		 */
		for (Usuario usuarioDaLista : dados.getListUsuario()) {
			
			if (login.equals(usuarioDaLista.getEmail()) && senha.equals(usuarioDaLista.getSenha()) && cliente.getAdministrador()==false) {
				System.out.println("bem vindo " + usuarioDaLista.getNome());
				cliente = (UsuarioCliente) usuarioDaLista;
				cliente.logado(); 
			}else{
				
				if(x + 1 == dados.getListUsuario().size()){
					System.out.println("Email ou senha inválido");
				}
				x++;
			}
		}
		return cliente;
	}

	/* cadastra um anúncio */
	public Produto cadastrarAnuncio(BancoDeDados dados, UsuarioCliente usuarioCliente,Produto produto) {

		Scanner entrada = new Scanner(System.in);
		
		InterfaceDeTexto interfaceDeTexto = new InterfaceDeTexto();
		boolean loop = true;
		
		/* chama uma interface de texto */
		interfaceDeTexto.textoCadastrarAnuncio();
		int opcao = entrada.nextInt();
		entrada.nextLine();

		/* gera um código para o produto */
		int codigo = produto.gerarCodigo();
		int b;


		/* verifica se o código gerado já exite, se exitir gera
		 * um código que ainda não exite na list
		 */
		for(int a = 0; a< dados.getListAnuncio().size(); a++){

			b = 0;
			while(b <= a){
				if(dados.getListAnuncio().get(b).getCodigo() == codigo){

					codigo = produto.gerarCodigo();
					b = 0;
				}else{

					b++;
				}
				produto.setCodigo(codigo);
			}
		}

		/* Cadastra um produto da categoria casa */
		switch (opcao) {

			// criar um m�todo para cada case
			case 1:

				/* pede dados do produto e trata exceções */
				System.out.println("Cadastrar casa");
				System.out.println("Nome da casa");
				produto.setNomeProduro(entrada.nextLine());

				do {

					try {
						System.out.println("Pre�o da casa");
						produto.setPrecoProduto(entrada.nextDouble());
						entrada.nextLine();
						loop = false;
					} catch (IllegalArgumentException e) {
						
						System.out.println("o preço do produto deve ser maior ou igual zero");
					
					}
					
				} while (loop);

				loop = true;
				do {

					try {
						System.out.println("Quantidade de h�spedes que a casa suporta");
						produto.setHospedes(entrada.nextInt());
						entrada.nextLine();
						loop = false;
					} catch (IllegalArgumentException e) {
						
						System.out.println("A quantidade de hópedes deve ser maior ou igual a zero");
						loop = true;
					}
					
				} while (loop);

				produto.setCasa(true);
				produto.setAnunciante(usuarioCliente);
				produto.setCodigo(codigo);
				break;

			/* Cadastra um produto da categoria quarto */
			case 2:

				/* pede dados do produto e trata exceções */
				System.out.println("Cadastrar quarto");
				System.out.println("Nome do quarto");
				produto.setNomeProduro(entrada.nextLine());

				do {
					try {
						System.out.println("Preço do quarto");
						produto.setPrecoProduto(entrada.nextDouble());
						entrada.nextLine();
						loop = false;
					} catch (Exception e) {
						
						System.out.println("o preço do produto deve ser maior ou igual zero");
					}
						
				} while (loop);

				loop = true;
				do {
					try {
						System.out.println("Quantidade de de hóspedes que o quarto suporta");
						produto.setHospedes(entrada.nextInt());
						entrada.nextLine();
						loop = false;
					} catch (Exception e) {
						
						System.out.println("A quantidade de hópedes deve ser maior ou igual a zero");
					}
					
				} while (loop);

				produto.setQuarto(true);
				produto.setAnunciante(usuarioCliente);
				produto.setCodigo(codigo);
				break;

			/* Cadastra um produto da categoria chotel */
			case 3:

				/* pede dados do produto e trata exceções */
				System.out.println("Cadastrar hotel");
				System.out.println("Nome do hotel");
				produto.setNomeProduro(entrada.nextLine());
				do {
					try {
						System.out.println("Preço do hotel");
						produto.setPrecoProduto(entrada.nextDouble());
						entrada.nextLine();
						loop = false;
					} catch (Exception e) {
						
						System.out.println("o preço do produto deve ser maior ou igual zero");
					}
					
				} while (loop);

				loop = true;
				do {
					try {
						System.out.println("Quantidade de hóspedes que o hotel suporta");
						produto.setHospedes(entrada.nextInt());
						entrada.nextLine();
						loop = false;
					} catch (Exception e) {
						
						System.out.println("A quantidade de hópedes deve ser maior ou igual a zero");
					}
					
				} while (loop);

				produto.setHotel(true);
				produto.setAnunciante(usuarioCliente);
				produto.setCodigo(codigo);
				break;

			/* Cadastra um produto da categoria pousada */
			case 4:

				/* pede dados do produto e trata exceções */
				System.out.println("Cadastrar Pousada");
				System.out.println("Nome da pousada");
				produto.setNomeProduro(entrada.nextLine());

				do {
					try {
						System.out.println("Preço da pousada");
						produto.setPrecoProduto(entrada.nextDouble());
						entrada.nextLine();
						loop = false;
					} catch (Exception e) {
						
						System.out.println("o preço do produto deve ser maior ou igual zero");
					}
					
				} while (loop);

				loop = true;
				do {
					try {
						System.out.println("Quantidade de hóspedes que a posada suporta");
						produto.setHospedes(entrada.nextInt());
						entrada.nextLine();
						loop = false;
					} catch (Exception e) {
						
						System.out.println("A quantidade de hópedes deve ser maior ou igual a zero");
					}
					
				} while (loop);

				produto.setPousada(true);
				produto.setAnunciante(usuarioCliente);
				produto.setCodigo(codigo);
				
				break;
			default:
				cadastrarAnuncio(dados, usuarioCliente, produto);
			break;
		}
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

		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o c�digo do anuncioo");
		int codigo = entrada.nextInt();
		entrada.nextLine();
		
		int n = 0;

		/* verifica se o código informado correspode
		 * a um produto cadastrado, se sim, pede novas 
		 * informações do produto
		 */
		for (int x = 0; x < dados.getListAnuncio().size(); x++) {

			if (codigo == dados.getListAnuncio().get(x).getCodigo()) {
				
				
				dados.getListAnuncio().set(x, cadastrarAnuncio(dados, usuarioCliente, produto));
				break;
			}else{
				if( x + 1 == dados.getListAnuncio().size()){
					System.out.println("Anúncio não encontrado");
				}
				n++;
			}
		}
	}

	/*exclui um produto cadastrado por um usuário */
	public void excluirAnuncio(BancoDeDados dados,Produto produto) {

		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o c�digo do anuncioo");
		int codigo = entrada.nextInt();
		entrada.nextLine();

		int n = 0;

		/* verifica se o código informado correspode
		 * a um produto cadastrado, se sim, exclui o produto 
		 */
		for (int a = 0; a < dados.getListAnuncio().size(); a++) {

			if (codigo == dados.getListAnuncio().get(a).getCodigo()) {

				
				dados.removeAnuncio(dados.getListAnuncio().get(a));
				System.out.println("An�ncio exclu�do");
			}else{
				if( n + 1 ==  dados.getListAnuncio().size()){
					System.out.println("Anúncio não encontrado");
				}
				n++;
			}
		}
	}

	/*entra na conta do usuário administrador */
	public UsuarioCliente entrarNaContaAdministrador(BancoDeDados dados,UsuarioCliente adm ) {

		Scanner scan = new Scanner(System.in);
		System.out.println("logar");
		System.out.println("email");
		String login = scan.nextLine();
		System.out.println("senha");
		String senha = scan.nextLine();
		
		/* verifica se  o email e a senha informados pelo usuário são 
		 * correspondende  a uma conta existente e se o usuário é 
		 * administrador, se sim, usuário entra na conta
		 */
		for (Usuario usuarioDaLista : dados.getListUsuario()) {

			if (login.equals(usuarioDaLista.getEmail()) && senha.equals(usuarioDaLista.getSenha())
					&& usuarioDaLista.getAdministrador() == true) {

				System.out.println("bem vindo " + usuarioDaLista.getNome());
				adm = (UsuarioCliente) usuarioDaLista;
				adm.logado();
			}
		}
		return adm;
	}

	/* lista todos os usuários */
	public void VerListaDeUsuario(BancoDeDados dados) {
		
		for(Usuario a: dados.getListUsuario()) {
			System.out.println(a);
		}
	}
}