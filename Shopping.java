import java.util.ArrayList;

public class Shopping {
	private String cnpj;
	public String nome;
	public Endereço endereço;
	public ArrayList<Funcionario>funcionarios = new ArrayList<Funcionario>();
	public ArrayList<Proprietario>proprietarios = new ArrayList<Proprietario>();
	public Gerente gerente;
	public ArrayList<Loja>lojas = new ArrayList<Loja>();
	
	public void cadastrarLoja(Loja loja) {
		lojas.add(loja);
	}
	
	public void cadastrarFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}
	
	public void cadastrarProprietario(Proprietario proprietario) {
		proprietarios.add(proprietario);
	}
}
