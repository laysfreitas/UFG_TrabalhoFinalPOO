import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.Date;


public class Cliente extends Pessoa {
      
	public ContaCliente conta;
        public Date data;
        
	/* Construtor da classe Cliente*/
	public Cliente(String nome, String cpf, Endereco endereco, String telefone){
            super(nome, cpf, endereco, telefone);
	}
	
	/* Método que chama o método da classe ContaCliente 
	 * para vincular a compra na conta do cliente */
	public void realizaCompra() throws IOException{
           conta.registraCompra(this);
        }
        
        /*Realiza cadastro do cliente na loja*/
        public void realizarCadastro() throws IOException{
            int numLoja;
            numLoja = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da loja", "Cria conta", JOptionPane.INFORMATION_MESSAGE));
            conta = new ContaCliente(this, new Date(), numLoja);
            conta.loja.cadastrarCliente(this);
        }
	
        public String toString(){
            String mensagem = "\nNome: " + this.nome + "\nEndereço: " + this.getEndereco() + "\nTelefone: " + this.getTelefone() + "\n";
            return mensagem;
        }
}
