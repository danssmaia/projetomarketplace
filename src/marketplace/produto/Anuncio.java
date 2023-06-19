package marketplace.produto;

import marketplace.cliente.Usuario;

/**
 * Classe abstrata que cria os atributos dos anúncios
 */
public abstract class Anuncio {

	/* variáveis de instâncias */
	private String nomeProduto;
	private double precoProduto;
	private int hospedes;
	private int codigo;
	private Usuario anunciante;

	/* construtor */
	public Anuncio(){
	}

	/* construtor */
	public Anuncio(String nomeProduto , double precoProduto, int hospedes, int codigo, Usuario anunciante){

		this.setNomeProduro(nomeProduto);
		this.setPrecoProduto(precoProduto);
		this.setHospedes(hospedes);
		this.codigo = codigo;
		this.anunciante = anunciante;
	}

	/* retorna nomeProduto */
	public String getNomeProduro () {
		return nomeProduto ;
	}

	/*configura nomeProduto*/
	public void setNomeProduro (String nomeProduto ) {
		this.nomeProduto  = nomeProduto ;
	}
	
	/* retorna precoProduto */
	public double getPrecoProduto() {
		return precoProduto;
	}

	/* configura precoproduto */
	public void setPrecoProduto(double precoProduto){

		if(precoProduto < 0){

			throw new IllegalArgumentException("O preço do produto deve ser maior que zero");
		}

		this.precoProduto = precoProduto;
	}

	/* retorna hospedes */
	public int getHospedes() {
		return hospedes;
	}

	/* configura hospedes */
	public void setHospedes(int hospedes){

		if(hospedes < 0){

			throw new IllegalArgumentException("Número de hópesdes inválido");
		}
		this.hospedes = hospedes;
	}
	/* retorna codigo */
	public int getCodigo(){

		return codigo;
	}

	/* configura codigo */
	public void setCodigo(int codigo){

		this.codigo = codigo;
	}

	/* metodo abstract */
	public abstract  int gerarCodigo();

	/* retorna anunciante */
	public Usuario getAnunciante() {
		return anunciante;
	}

	/*configura anunciante */
	public void setAnunciante(Usuario anunciante) {
		this.anunciante = anunciante;
	}

	/* retorna na reprsentação de String */
	@Override
	public String toString() {
		return "" + nomeProduto + "\n Preco diario: " + precoProduto + "R$\n Maximo de hospedes: " + hospedes
				+ "\n codigo: " + codigo + "\n anunciante: " + anunciante.getNome() + ".\n tipo do imovel: ";
	}	
}
