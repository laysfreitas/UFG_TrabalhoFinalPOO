package projectfinalpoo;

import java.util.Date;

public class Funcionario extends Pessoa {
	
	private double salario;		//salário que recebe
	private int dependentes; // quantidade de dependentes
	public Shopping shop;
	public Loja loja;		// Qual loja o funcionário é contratado
	public Date data;
	public ContaCliente contaCliente;
	
	public Funcionario(String nome, String cpf, Endereco endereco, String telefone) {
		super(nome, cpf, endereco, telefone);
	}
	
	public double getSalario() {
		return salario;
	}
	
	public Loja getLoja() {
		return this.loja;
	}
	
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
	public void setShopping(Shopping shop) {
		this.shop = shop;
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
	
}
