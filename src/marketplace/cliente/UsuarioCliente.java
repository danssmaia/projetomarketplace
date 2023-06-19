package marketplace.cliente;

public class UsuarioCliente extends Usuario{


    /* construtor */
    public UsuarioCliente(){}

    /* construtor */
    public UsuarioCliente(String nome, String sobreNome, String cpf, 
                String cep, String email, String ddd,  String telefone, String senha,boolean administrador){

                    
            super(nome, sobreNome, cpf, cep, email, ddd, telefone, senha, administrador);
    }
    
	/* retorna na reprsentação de String */
    @Override
	public String toString(){

		return String.format(super.toString());
	}
    
}
