package marketplace.produto;

import java.util.Random;

import marketplace.cliente.Usuario;

public class Produto extends Anuncio {

	/* variáveis de instâncias */
	private boolean casa;
	private boolean quarto;
	private boolean hotel;
	private boolean pousada;

	/* construtor */
	public Produto() {
	}

	/* construtor */
	public Produto(String nomeProduro, double precoProduto, int hospedes, int codigo, Usuario anunciante, boolean casa,
			boolean quarto, boolean hotel, boolean pousada) {

		super(nomeProduro, precoProduto, hospedes, codigo, anunciante);

		this.casa = casa;
		this.quarto = quarto;
		this.hotel = hotel;
		this.pousada = pousada;
	}

	/* configura casa */
	public void setCasa(boolean casa) {

		this.casa = casa;
	}

	/* configura quarto */
	public void setQuarto(boolean quarto) {

		this.quarto = quarto;
	}

	/* configura hotel */
	public void setHotel(boolean hotel) {

		this.hotel = hotel;
	}

	/* configura pousada */
	public void setPousada(boolean pousada) {

		this.pousada = pousada;
	}

	/* retorna casa */
	public boolean getCasa() {

		return casa;
	}

	/*retorna quarto*/
	public boolean getQuarto() {

		return quarto;
	}

	/* retorna hotel */
	public boolean getHotel() {

		return hotel;
	}

	/* retorna pousada*/ 
	public boolean getPousada() {

		return pousada;
	}

	/* retorna na reprsentação de String */
	@Override
    public String toString() {

    	if(this.casa == true) {
    	return String.format(super.toString()+"Casa \n"); }
        else if(this.hotel==true){
        	return String.format(super.toString()+ "Hotel \n");
        }else if(this.quarto == true) {
        	return String.format(super.toString()+ "Quarto \n");
        }else if(this.pousada == true) {
        	return String.format(super.toString()+ "Pousada \n");
        }else {
        	return super.toString();
        }	
    }

	@Override
	/* método que retorna números inteiros de 0 a 100 */
    public int gerarCodigo(){

		Random random = new Random();
		int codigo = random.nextInt(100);
        return codigo;
    }
}
