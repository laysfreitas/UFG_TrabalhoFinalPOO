
public class Funcionario extends Pessoa {

	private double salario;
	private int dependentes;
	
	public Funcionario(String nome, String cpf, Endereco endereco, String telefone) {
		super(nome, cpf, endereco, telefone);
		this.nome = nome;
		cpf = cpf;
		endereco = endereco;
		telefone = telefone;
	}

}
