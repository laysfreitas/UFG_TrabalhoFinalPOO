import java.util.Date;
import java.util.ArrayList;

public class ContaCliente {
    public ArrayList<Compra>compras = new ArrayList<Compra>();
    public Cliente cliente;
    public Date data;
    public Loja loja;

    
    public ContaCliente(Cliente cliente, Date data, Loja loja) {
    	this.cliente = cliente;
    	this.data = data;
    	this.loja = loja;
    }
    
    public void adicionaCompra(Compra compra){
        compras.add(compra);
    }

    
    public void adicionaCompra(Cliente cliente){
        this.cliente = cliente;
    }
    
    public void solicitaTroca(Produto p1, Produto p2, int codigoCompra){
    	for( int  i = 0; i < compras.size(); i++) {
    		
    	}
    }

}