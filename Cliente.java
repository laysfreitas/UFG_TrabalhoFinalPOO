import java.util.ArrayList;

public ArrayList<Compra> compras;

    public void realizaCompra(Produto produto){
        
    }
    public boolean efetuaPagamento(Compra compra){
    
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
