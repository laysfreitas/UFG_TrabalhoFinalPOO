import java.util.ArrayList;

public class Loja {
	public String nome;
	public String local;
	public int numero;
	private String cnpj;
	public Endereço endereco;
	public ArrayList<Funcionario>funcionarios = new ArrayList<Funcionario>();
	public Gerente gerenteloja;
	public ArrayList<Proprietario>proprietarios = new ArrayList<Proprietario>();
	public ArrayList<Produto>produtos = new ArrayList<Produto>();

	
	public Loja(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}
	void cadastrarProdutos(Produto produto) {
		produtos.add(produto);
	}
	
	public void cadastrarFuncionarioLoja(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}
	
	public void cadastrarProprietarioLoja(Proprietario proprietario) {
		proprietarios.add(proprietario);
	}
	
}
