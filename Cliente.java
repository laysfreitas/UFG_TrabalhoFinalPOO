import java.util.ArrayList;
	
public class Cliente extends Pessoa {

	    public Compra compra;
	    public ContaCliente conta;

	    public Cliente(String nome, String cpf, Endereco endereco, String telefone, ContaCliente conta){
	        super(nome, cpf, endereco, telefone);
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
	        for(int i=0; i<compra.size();i++){
	            for(int j=0; j<compra.get(i).produtos.size();i++){
	                if(p1.getCodigo() == (compra.get(i).produtos.get(j)).getCodigo()){
	                    compra.get(i).produtos.get(j).remove();
	                    p1++;
	                    realizaCompra(p2);
	                }
	            }
	        }
	    }
}
