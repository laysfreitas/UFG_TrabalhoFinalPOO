
public class Funcionario extends Pessoa {

	private double sal�rio;
	private int dependentes;
	
	public Funcionario(String nome, String cpf, Endere�o endere�o, String telefone) {
		super(nome, cpf, endere�o, telefone);
		this.nome = nome;
		cpf = cpf;
		endere�o = endere�o;
		telefone = telefone;
	}

}
