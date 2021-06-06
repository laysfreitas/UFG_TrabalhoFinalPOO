import java.util.ArrayList;

public class Loja {
	public String nome;
	public String local;
	public int numero;
	private String cnpj;
	public Endereco endereco;
	public ArrayList<Funcionario>funcionarios = new ArrayList<Funcionario>();
	public ArrayList<Produto>produtos = new ArrayList<Produto>();
	public ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static double ganho = 0;

	/* Construtor da classe loja */
	public Loja(String nome, String cnpj, String local, int numero, Endereco endereco) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.local = local;
		this.numero = numero;
		this.endereco = endereco;
	}
	
	/* Método que cadastra um produto */
	public void cadastrarProdutos(Produto produto) {
		produtos.add(produto);
	}
	
	/* Método que cadastra um funcionário */
	public void cadastrarFuncionarioLoja(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}
	
	/* Método que demite um funcionário */
	public void demiteFuncionario(Funcionario funcionario) {
		
		for(int i = 0 ; i < funcionarios.size() ; i++) {
			if((funcionario.nome).equals(funcionarios.get(i).nome)) {
				funcionarios.remove(i);
			}
		}
		
	}
	
	/* Método que consulta a quantidade de quantidade */
	public int consultaProduto(Produto produto) {
		for(int i = 0 ; i < produtos.size() ; i++) {
			if(produto.getCodigo() == produtos.get(i).getCodigo()) {
				return produtos.get(i).qtdProduto();
			}
		}
		return 0;
	}
	
	/* Método que altera o valor de um produto */
	public void alteraValorProduto(Produto produto, double novoValor) {
		for(int i = 0 ; i < produtos.size() ; i++) {
			if(produto.getCodigo() == produtos.get(i).getCodigo()) {
				produtos.get(i).valor = novoValor;
			}
		}
	}

	/* Método que exclui um produto */
	public void vendaProduto(Produto produto, double valor) {
		
		for(int i = 0 ; i < produtos.size() ; i++) {
			if((produto.getCodigo()) == produtos.get(i).getCodigo()) {
				produtos.remove(i);
			}
		}
		this.ganho += valor;
		
	}
}
