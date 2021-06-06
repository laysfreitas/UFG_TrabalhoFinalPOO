import java.util.Date;
import java.util.ArrayList;

public class Compra {
    public int codigo;
    public ArrayList<Produto> produtos = new ArrayList<Produto>();
    public double valor = 0 ;
    public Funcionario vendedor;
    public Date data;

    public double calculaTotal(ArrayList<Produto>produto){
        for(int i = 0; i < produto.size(); i++){
            this.valor += produto.get(i).valor_produto;
        }
        return valor;
    }

    public void vendaEstoque(Produto produto){
        for(int i = 0; i < produtos.size(); i++){
            produtos.get(i).quantidade--;
        }
    }
    
    public void emitirComprovante(Compra compra) {
    	
    }
}