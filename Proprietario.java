
public class Proprietario extends Pessoa {

	private int dependentes;
	
	public Proprietario(String nome, String cpf, Endere�o endere�o, String telefone) {
		super(nome, cpf, endere�o, telefone);
		this.nome = nome;
		cpf = cpf;
		endere�o = endere�o;
		telefone = telefone;
	}

}
