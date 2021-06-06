import java.util.Date;
import java.util.ArrayList;

public class ContaCliente {
    public ArrayList<Compra>compras = new ArrayList<Compra>();
    public Cliente cliente;
    public Date data;
    public Loja loja;

    public void adicionaCompra(Compra compra){
        compras.add(compra);
    }

}
