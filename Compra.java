package projectfinalpoo;

import java.util.Date;
import java.util.ArrayList;

public class Compra {
    public int codigo;
    public ArrayList<Produto> produtos = new ArrayList<Produto>();
    public double valor;
    public Funcionario vendedor;
    public Date data;

    /* Construtor da classe Compra*/
    
    
    public Compra(int codigo, Date data, Funcionario vendedor) {
    	this.codigo = codigo;
    	this.data = data;
    	this.vendedor = vendedor;
    }
    
    /* Método que adiciona produtos na compra*/
    
    
    public void adicionaProdutos(Produto produto, int qtd) {
    	produto.quantidadeCompra = qtd;
    	produtos.add(produto);
        this.vendedor.loja.reduzirEstoque(produto, qtd);
    	
    }

    
    /* Método que retorna o valor da compra e reduz os produtos 
     * comprados do estoque da loja de onde foram comprados*/
    
    
    public double valorCompra( ){
    	this.valor = 0;
    	for(int j = 0; j < produtos.size(); j++){
	        this.valor += (produtos.get(j).valor_produto)*(produtos.get(j).quantidadeCompra);
    	}
        return valor;
    }
    
    /* Método que retorna uma String com todos os produtos da compra*/
    
    
    public String emitirComprovante() {
    	String p = this.codigo + ": \n";
        for(int i = 0; i < produtos.size(); i++){
            p = p + " - " + produtos.get(i).nome_produto + "(" + produtos.get(i).quantidadeCompra + ")";
        }
        return p;
    }
}
