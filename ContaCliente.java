package projectfinalpoo;
import java.util.Date;

public class ContaCliente {
    public ArrayList<Compra> compras = new ArrayList();
    public Cliente cliente;
    public Date data;
    public Loja loja;

    public void adicionaCompra(Compra compra){
        compras.add(compra);
    }

    public void pagamento(Compra compra){
        loja.recebePagamento(compra.valor);
    }
}
