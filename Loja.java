import java.util.ArrayList;

public class Loja {
	public String nome;
	public int numero;
	private String cnpj;
	public ArrayList<Funcionario>funcionarios = new ArrayList<Funcionario>();
	public ArrayList<Produto>produtos = new ArrayList<Produto>();
	public ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static double ganho = 0;

	/* Construtor da classe loja */
	public Loja(String nome, String cnpj, int numero) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.numero = numero;
	}
	
	
	public String getCNPJ() {
		return this.cnpj;
	}
	
	public double getGanho(){
		return ganho;
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
			if((funcionario.getCPF()).equals(funcionarios.get(i).getCPF())) {
				funcionarios.remove(i);
			}
		}
		
	}
	
	/* Método que consulta a quantidade de produto */
	public int consultaProduto(Produto produto) {
		for(int i = 0 ; i < produtos.size() ; i++) {
			if(produto.codigo == produtos.get(i).codigo) {
				return produtos.get(i).quantidade;
			}
		}
		return 0;
	}
	
	/* Método que altera o valor de um produto */
	public void alteraValorProduto(Produto produto, double novoValor) {
		for(int i = 0 ; i < produtos.size() ; i++) {
			if(produto.codigo == produtos.get(i).codigo) {
				produtos.get(i).alteraValorProduto(novoValor);
			}
		}
	}

	/* Método que vende um produto */
	public double reduzirEstoque(Produto produto, int quantidade) {
		double gasto = 0;
		for(int i = 0 ; i < produtos.size() ; i++) {
			if((produto.codigo) == produtos.get(i).codigo) {
				gasto += produtos.get(i).vender(quantidade);
				produtos.get(i).quantidade -= quantidade;
			}
		}
		ganho += gasto;
		return gasto;
	}
	
}