import java.util.Date;

public class Funcionario extends Pessoa {
	
	private double salario;		//salário que recebe
	private int dependentes; // quantidade de dependentes
	public Loja loja;		// Qual loja o funcionário é contratado
	public Cliente cliente; //Funcionario atende um cliente
	public Date data;
	public ContaCliente contaCliente;
	
	public Funcionario(String nome, String cpf, Endereco endereco, String telefone, Loja loja) {
		super(nome, cpf, endereco, telefone);
		this.loja = loja;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public Loja getLoja() {
		return this.loja;
	}
	
	public void setSalario(double valor) {
		this.salario = valor;
	}
	
	public void setDependentes(int qtdDependentes) {
		this.dependentes = qtdDependentes;
	}
	
	public void acrescentaDependentes(int maisDependentes){
		this.dependentes = this.dependentes + maisDependentes;
	}

	
	/* Funcionario cria a ContaCliente e já atribui ela ao cliente*/
	public void criaContaCliente(Cliente cliente, Date data){
		contaCliente = new ContaCliente(cliente,data,this.loja);
		cliente.clienteEConta(contaCliente);
	}
	
	
}

