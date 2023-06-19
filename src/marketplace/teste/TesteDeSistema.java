package marketplace.teste;

import marketplace.Metodos.MetodosTeste;
import marketplace.bacoDeDados.BancoDeDados;
import marketplace.cliente.UsuarioCliente;
import marketplace.produto.Produto;


public class TesteDeSistema{


    public static void main(String[] args) {

		BancoDeDados dados = new BancoDeDados();
		MetodosTeste test = new MetodosTeste();

		/*Cria 2 usuário e 1 usuário administrador */


		/*														 nome, sobreNome, cpf, cep, email, ddd, telefone, senha, administrador */
    	UsuarioCliente usuarioTeste1 = new UsuarioCliente("Usuario1", "Teste1", "83230943891", "21367756", "emailteste1", "73", "457115498", "56766", false);

		UsuarioCliente usuarioTeste2 = new UsuarioCliente("Usuario2", "Teste2", "27794543434", "81345789", "emailteste2", "75", "908655498", "46765", false);

		UsuarioCliente usuarioTeste3 = new UsuarioCliente("Usuario3", "Teste3", "27234543454", "21345758", "emailteste3", "71", "986555463", "1563456", true);


		/*cria 3 produtos */

		/*						NomeProduto, precoProduto, hospedes, codigo, anunciante, casa, quarto, hotel, pousada*/
    	Produto produtoteste1 = new Produto("CASATESTE", 213, 4, 111, usuarioTeste1, true, false, false, false);

		Produto produtoteste2 = new Produto("HOTELTESTE2", 213, 4, 456, usuarioTeste1, false, true, false, false);

		Produto produtoteste3 = new Produto("POUSADATESTE", 213, 4, 233, usuarioTeste1, false, false, true, false);


		
		System.out.println("Lista de Produtos: ");
		test.exibirAnuncio(dados);
		System.out.println("--------------------------------------------------------------------------------------------------------");
		
		System.out.println("Detalhes dos Produtos: ");
		test.exibirDetalhesDeAnuncio(dados);
		System.out.println("--------------------------------------------------------------------------------------------------------");

		System.out.println("CRIANDO CONTA");
		test.criarConta(dados, usuarioTeste1);
		test.criarConta(dados, usuarioTeste2);
		System.out.println("--------------------------------------------------------------------------------------------------------");

		
		System.out.println("ENTRANDO NA CONTA");
		test.entrarNaConta(dados ,usuarioTeste1);
		test.entrarNaConta(dados ,usuarioTeste2);
		System.out.println("--------------------------------------------------------------------------------------------------------");

		System.out.println("CADASTRANDO PRODUTOS");
		test.cadastrarAnuncio(dados, usuarioTeste1, produtoteste1);
		test.cadastrarAnuncio(dados, usuarioTeste1, produtoteste2);
		
		System.out.println("--------------------------------------------------------------------------------------------------------");
		
		System.out.println("LISTANDO PRODUTOS DO USUARIO");
		test.ListarMeusAnuncios(dados, usuarioTeste1);
		
		
		System.out.println("EDITANDO PRODUTO");
		test.editarAnuncio(dados, usuarioTeste1, produtoteste3);
		
		System.out.println("PRODUTO EDITADO");
		test.ListarMeusAnuncios(dados, usuarioTeste1);
		
		System.out.println("EXCLUINDO PRODUTO");
		test.excluirAnuncio(dados, produtoteste3);
		
		System.out.println("PRODUTO EXCLUIDO");
		test.ListarMeusAnuncios(dados, usuarioTeste1);
		
		System.out.println("ENTRANDO NA CONTA DO ADMINISTRADOR");
		test.entrarNaContaAdministrador(dados, usuarioTeste3);
		System.out.println("VER LISTA DE USUARIO");
		test.VerListaDeUsuario(dados);

    	
    }
}