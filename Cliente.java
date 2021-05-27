import java.util.ArrayList;

public class Cliente {
    public Compra compra;
    public ContaCliente conta;

    public Cliente(String nome, String CPF, Endereco endereco, String telefone, ContaCliente conta){
        super(nome, CPF, endereco, telefone);
        this.conta = conta;
    }
    public void realizaCompra(Compra compra){
        conta.adicionaCompra(compra);
    }
    public boolean efetuaPagamento(Compra compra){
        conta.pagamento(compra.valor);
        return true;
    }
    public void solicitaTroca(Produto p1, Produto p2){
        p1.quantidade++;
        p2.quantidade--;
        int i,j;
        for(i=0; i<compras.size();i++){
            for(j=0; j<compras.get(i).produtos.size();i++){
                if(p1.codigo == (compras.get(i).produtos.get(j)).codigo){
                    compras.get(i).produtos.get(j).remove();
                    p1++;
                    realizaCompra(p2);
                }
            }
        }
    }
}
