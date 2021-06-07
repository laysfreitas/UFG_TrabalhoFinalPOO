package projectfinalpoo;

public class Produto {
	public String nome_produto;
	public int codigo;
	public String descrição;
	public double valor_produto;
	public int quantidadeEstoque;
	public int quantidadeCompra;
	
	public Produto(String nome, int codigo, String descrição, double valor, int quantidade) {
		this.nome_produto = nome;
		this.codigo = codigo;
		this.descrição = descrição;
		this.valor_produto = valor;
		this.quantidadeEstoque = quantidade;
	}
	
	/* Método que diminui a quantidade no estoque e retorna o valor gasto*/
	public double vender(int qtdvendida){
		if(this.quantidadeEstoque < qtdvendida) {
			return 0;
		}else {
                        this.quantidadeEstoque -= qtdvendida;
			return qtdvendida*(this.valor_produto);
		}
	}
	
	/* Método que aumenta a quantidade de produtos no estoque*/
	public void acrescentaEstoque(int maisProduto) {
		this.quantidadeEstoque = this.quantidadeEstoque + maisProduto;
	}
	
	/* Método que troca o valor do produto*/
	public void alteraValorProduto(double novoValor) {
		this.valor_produto = novoValor;
	}
}
