
public class Endereco {
	public String rua;
	public String bairro;
	public int numero;
	public String cep;
	public String complemento;

	/* Construtor da classe Endereco */
	public Endereco(String rua, String bairro, int numero, String cep, String complemento){
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.cep = cep;
		this.complemento = complemento;
	}
	
	/* Método que retorna os atributos do endereço */
	public String toString() {
		return this.rua + ", " + this.numero + " - " + this.bairro + ", " + this.cep + "( " + this.complemento + " )" + "\n"; 
	}
}

