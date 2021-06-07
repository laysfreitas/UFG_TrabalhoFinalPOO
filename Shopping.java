package projectfinalpoo;

import java.util.ArrayList;


public class Shopping {
	private String cnpj;
	public String nome;
	public Endereco endereco;
	public ArrayList<Funcionario>funcionarios = new ArrayList<Funcionario>();
	public ArrayList<Loja>lojas = new ArrayList<Loja>();
	
	/* Método cosntrutor do Shopping*/
	public Shopping(String cnpj, String nome, Endereco endereco) {
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.nome = nome;
	}
	
	public String getCNPJ() {
		return this.cnpj;
	}
	
	/* Método para cadastrar loja */
	public void cadastrarLoja(Loja loja) {
		lojas.add(loja);
	}
	
	/* Método para cadastrar funcionário */
	public void cadastrarFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}
	
	/* Método que demite funcionário */
	public void demiteFuncionario(Funcionario funcionario) {
		
		for(int i = 0 ; i < funcionarios.size() ; i++) {
			if((funcionario.getCPF()).equals(funcionarios.get(i).getCPF())) {
				funcionarios.remove(i);
			}
		}
		
	}
	
}
