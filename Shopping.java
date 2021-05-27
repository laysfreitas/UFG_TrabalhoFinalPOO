import java.util.ArrayList;

public class Shopping {
	private String cnpj;
	public String nome;
	public Endereço endereço;
	public ArrayList<Funcionario>funcionarios = new ArrayList<Funcionario>();
	public ArrayList<Loja>lojas = new ArrayList<Loja>();
	
	/* Método cosntrutor do Shopping*/
	public Shopping(String cnpj, String nome, Endereço endereço) {
		this.cnpj = cnpj;
		this.endereço = endereço;
		this.nome = nome;
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
			if((funcionario.cpf).equals(funcionarios.get(i).cpf)) {
				funcionarios.get(i).remove(i);
			}
		}
		
	}
	
}
