package marketplace.cliente;

/**
 * A classe Usuario recebe atributos padrão de um usuario de plataforma. 
 * a classe vai ser a simulação de um usuario no marketplace
 */
public abstract class Usuario {

	/* variáveis de instâncias */
	private String nome;
	private String sobreNome;
	private String cpf;
	private String cep;
	private String email;
	private String ddd;
	private String telefone;
	private String senha;
	private boolean administrador;
	private boolean autenticado;

	
	/* construtor */
	public Usuario() {
	}

	/* construtor */
	public Usuario(String nome, String sobreNome, String cpf, String cep, String email, String ddd, String telefone,
			String senha, boolean administrador) {

		this.setNome(nome);
		this.setSobreNome(sobreNome);
		this.setCpf(cpf);
		this.setCep(cep);
		this.setEmail(email);
		this.setDdd(ddd);
		this.setTelefone(telefone);
		this.setSenha(senha);
		this.setAdministrador(administrador);

	} // fim da criação de construtores

	/* configura auntenticado para true */	
	public void logado() {
		this.autenticado = true;
	}

	/* retorna autenticado */
	public boolean isAutenticado() {
		return autenticado;
	}

	/* retorna nome */
	public String getNome() {
		return nome;
	}

	/* configura o nome */
	public void setNome(String nome) {
		this.nome = nome;
	}
  /* retorna sobreNome*/
	public String getSobreNome() {
		return sobreNome;
	}

	/* configura sobreNome */
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	/* configura cpf */
	public void setCpf(String cpf) {

		
		  if(cpf.length() != 11){
		  
		  throw new IllegalArgumentException("CPF inválido"); }
		 

		this.cpf = cpf;
	}

	/* retorna cpf */
	public String getCpf() {
		return cpf;
	}

	/* configura cep */
	public void setCep(String cep) {

		if(cep.length() != 8){
		  
			throw new IllegalArgumentException("CEP inválido");
		   
	  }
		this.cep = cep;
	}

	/* configura cep */
	public String getCep() {
		return cep;
	}

	/* retorna email*/
	public String getEmail() {
		return email;
	}

	/* configura email */
	public void setEmail(String email) {
		this.email = email;
	}

	/* retorna ddd */
	public String getDdd() {

		return ddd;
	}

	/* configura ddd */
	public void setDdd(String ddd) {

		if(ddd.length() != 2){
		  
			throw new IllegalArgumentException("DDD inválido");
		   
	  }
		this.ddd = ddd;
	}

	/* configura telefone */
	public void setTelefone(String telefone) {

		if (telefone.length() != 9){
			throw new IllegalArgumentException("Invalido");
		}
		this.telefone = telefone;
	}

	/* retorna telefone*/
	public String getTelefone() {
		return telefone;
	}

	/* retorna senha */
	public String getSenha() {
		return senha;
	}

	/* configura senha */
	public void setSenha(String senha) {

		if (senha.length() < 4) {
			throw new IllegalArgumentException("Invalido");
		}
		this.senha = senha;
	}
	/* retorna administrador */
	public boolean getAdministrador() {
		return administrador;
	}

	/* configura administrador */
	public void setAdministrador(boolean administrador) {
		
		this.administrador = administrador;
	}

	/* retorna na reprsentação de String */
	@Override
	public String toString() {
		return "Usuario: " + nome + " " + sobreNome + "\n cpf: " + cpf + "\n cep:" + cep + "\n email: "
				+ email + "\n telefone: " + ddd + " " + telefone + "\n";
	}
}
