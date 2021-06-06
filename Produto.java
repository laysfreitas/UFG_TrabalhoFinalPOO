import java.util.Date;

public class Produto {
	public String nome_produto;
	public String categoria;
	public int codigo;
	public String descrição;
	public double valor_produto;
	public Date garantia;
	public int quantidade;  
	
	public Produto(String nome, int codigo, String categoria, String descrição, double valor, Date garantia, int quantidade) {
		this.nome_produto = nome;
		this.codigo = codigo;
		this.categoria = categoria;
		this.descrição = descrição;
		this.valor_produto = valor;
		this.garantia = garantia;
		this.quantidade = quantidade;
	}
	
	/* Método que diminui a quantidade no estoque e retorna o valor gasto*/
	public double vender(int qtdvendida){
		if(this.quantidade < qtdvendida) {
			return 0;
		}else {
			this.quantidade = (this.quantidade - qtdvendida);
			return qtdvendida*(this.valor_produto);
		}
	}
	
	/* Método que aumenta a quantidade de produtos no estoque*/
	public void acrescentaEstoque(int maisProduto) {
		this.quantidade = this.quantidade + maisProduto;
	}
	
	/* Método que troca o valor do produto*/
	public void alteraValorProduto(double novoValor) {
		this.valor_produto = novoValor;
	}
}