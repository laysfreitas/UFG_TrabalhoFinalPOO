
public class Proprietario extends Pessoa {

	private int dependentes;
	
	public Proprietario(String nome, String cpf, Endereço endereço, String telefone) {
		super(nome, cpf, endereço, telefone);
		this.nome = nome;
		cpf = cpf;
		endereço = endereço;
		telefone = telefone;
	}

}
