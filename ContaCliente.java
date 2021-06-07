import java.util.Date;
import java.util.ArrayList;

public class ContaCliente {
    public ArrayList<Compra>compras = new ArrayList<Compra>();
    public Cliente cliente;
    public Date data; // data de criação da conta
    public Loja loja;

    /* Construtor da classe ContaCliente*/
    public ContaCliente(Cliente cliente, Date data, Loja loja) {
    	this.cliente = cliente;
    	this.data = data;
    	this.loja = loja;
    }
    
    /* Método que adiciona compra na conta do cliente*/
    public void adicionaCompra(Compra compra){
        compras.add(compra);
    }

    /* Método que faz a troca de dois produtos de uma compra */
    public void solicitaTroca(Produto p1,int qtdTrocada, Produto p2,int qtdRecebida, int codigoCompra){
    	for(int i = 0; i < compras.size(); i++) {
    		if(compras.get(i).codigo == codigoCompra ) {
    			for(int j = 0; j < (compras.get(i)).produtos.size(); j++) {
    				if(compras.get(i).produtos.get(j).codigo == p1.codigo){
    					compras.get(i).produtos.remove(j);
    					compras.get(i).vendedor.loja.produtos.get(j).acrescentaEstoque(qtdTrocada);
    					compras.get(i).adicionaProdutos(p2,qtdRecebida);
    				}
    			}
    		}
    	}
    }
    
    public String toString() {
    	return this.cliente.nome;
    }

}

