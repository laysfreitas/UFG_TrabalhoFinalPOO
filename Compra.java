
package projectfinalpoo;


public class Compra {
    public int codigo;
    public ArrayList<Produto> produtos;
    public double valor = 0 ;
    public Funcionario vendedor;

    public double calculaTotal(ArrayList<Produto> produtos){
        int i;
        for(i=0; i<produtos.size(); i++){
            this.valor += produtos.get(i).valor;
        }
    }

    public void vendaEstoque(Produto produto){
        int i;
        for(i=0; i<produtos.size();i++){
            produtos.get(i).quantidade--;
        }
    }
}
