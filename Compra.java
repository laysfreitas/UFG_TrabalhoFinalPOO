import java.util.Date;
import java.util.ArrayList;

public class Compra {
    public int codigo;
    public ArrayList<Produto> produtos = new ArrayList<Produto>();
    public double valor = 0 ;
    public Funcionario vendedor;
    public Date data;

    public double vendaProduto(Produto produto, int quantidade){
        for(int i = 0; i < produtos.size(); i++){
            valor += this.vendedor.loja.reduzirEstoque(produto, quantidade);
        }
        return valor;
    }
    
    public String emitirComprovante() {
    	String p = this.codigo + ": \n";
        for(int i = 0; i < produtos.size(); i++){
            p = p + " - " + produtos.get(i).nome_produto + "(" + produtos.get(i).quantidade + ")";
        }
        return p;
    }
}