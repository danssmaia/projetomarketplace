package marketplace.menu;

/**
 * 	Classe que cria as interfaces de textos dos menus
 */
public class InterfaceDeTexto {
	
	 /* interface de texto do menu visitante */
	 public void textoMenuVisitante() {
    	System.out.println("1 Para ver anuncios ");
   		System.out.println("2 Para ver detalhes ");
   		System.out.println("3 Criar conta");
   		System.out.println("4 Para entrar na conta");
		System.out.println("5 para entrar na conta adiministrador");
		System.out.println("6 para sair");		
    }

	 /* interface de texto do menu do usuário autenticado */
    public void textoMenuUsuarioAuntenticado(){

		System.out.println("1 Cadastrar anuncio");
		System.out.println("2 Listar todos os seus anuncios");
		System.out.println("3 Editar anuncio ");
		System.out.println("4 Excluir anuncio");
		System.out.println("5 para voltar para o menu inicial");
		System.out.println("6 Sair da conta");	
    }
   
    /* interface de texto do menu do usuário administrador */
    public void textoMenuAdministrador() {
        System.out.println("1 Para ver lista de usu�rio ");
  		System.out.println("2 Para volatar para o meu inicial ");
		  System.out.println("3 para sair?");
    }
	
	 /* interface de texto do método cadastrarAnuncio() */
	public void textoCadastrarAnuncio(){

		System.out.println("Cadastrar an�ncio");
		System.out.println("Temos quatro categorias de produto, escolha uma cateogoria");
		System.out.println(" 1 para casa");
		System.out.println(" 2 para quarto");
		System.out.println(" 3 para hotel");
		System.out.println(" 4 para pousada");
	}
	
	 /* interface de texto de mensagem inválida dos menus */
	public void mensagemDeOpcaoInvalidaDeMenu(){

		System.out.println("Est� op��o � inv�lida, tente novamente");
	}

	/* interface de texto da mensagem de saída do app */
	public void textoDeSaidaDoApp(){

		System.out.println("/n At� mais :D /n");
	}

	public void textoDeBoasVindas(){

		System.out.println("Bem vindo(a)");
	}
}