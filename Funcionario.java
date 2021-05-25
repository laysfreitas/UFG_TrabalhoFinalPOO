
public class Funcionario extends Pessoa {

	private double salário;
	private int dependentes;
	
	public Funcionario(String nome, String cpf, Endereço endereço, String telefone) {
		super(nome, cpf, endereço, telefone);
		this.nome = nome;
		cpf = cpf;
		endereço = endereço;
		telefone = telefone;
	}

}
