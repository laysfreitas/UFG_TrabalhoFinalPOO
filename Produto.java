package projectfinalpoo;

public class Produto {
	public String nome_produto;
	public int codigo;
	public String descricao;
	public double valor_produto;
	public int quantidadeEstoque;
	public int quantidadeCompra;
	
	public Produto(String nome, int codigo, String descricao, double valor, int quantidade) {
		this.nome_produto = nome;
		this.codigo = codigo;
		this.descricao = descricao;
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
	
        
        public String toString(){
            String mensagem = "\nNome do produto: " + this.nome_produto + "\nDescrição: " + this.descricao + "\nQuantidade: " + this.quantidadeEstoque + "\nValor: " + this.valor_produto + "\n";
            return mensagem;
        }
}
