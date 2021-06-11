package projectfinalpoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Date;


public class Cliente extends Pessoa {
	public ArrayList<ContaCliente> contas = new ArrayList();
        public Date data;
        public static int geraNumConta =0 ; // gerador de número das contas
       
        File arqContasCliente = new File("contasCliente.txt"); //arquivo de contas do cliente
        
	/* Construtor da classe Cliente*/
	public Cliente(String nome, String cpf, Endereco endereco, String telefone){
            super(nome, cpf, endereco, telefone);
	}
	
	/* Método que chama o método da classe ContaCliente 
	 * para vincular a compra na conta do cliente */
	public void realizaCompra() throws IOException{
           int num, flag=0;
           num = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da loja", "Comprar", JOptionPane.INFORMATION_MESSAGE));
           for(int i=0; i<contas.size(); i++){
               if(contas.get(i).numLoja==num){
                   contas.get(i).registraCompra(this, num);
                   flag++;
               }
           }
           if(flag==0){
               throw new NoExistsException("Você não possui conta nessa loja");
           }
        }
        
        /*Método que cria conta do cliente em uma loja e cadastra o cliente no método da loja*/
        public void realizarCadastroLoja(Shopping shopping) throws IOException{
            int numLoja, numConta;
            numLoja = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da loja", "Cria conta", JOptionPane.INFORMATION_MESSAGE));
            numConta = geraNumConta++;
            contas.add(new ContaCliente(this, new Date(), numLoja, shopping, numConta));
            int i, flag=0;
            for(i=0; i<shopping.lojas.size();i++){
                if(shopping.lojas.get(i).numero==numLoja){
                    shopping.lojas.get(i).cadastrarCliente(this);
                    flag++;
                }
            }
            if(flag==0){
                throw new NoExistsException("Essa loja não existe");
            }
            JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso! N°:" + numConta, "Cria conta", JOptionPane.PLAIN_MESSAGE);
            salvaContas();
        }
	
        /*Método que salva as contas do cliente no arquivo*/
        
        public void salvaContas() throws IOException{
            if(arqContasCliente.exists())
                arqContasCliente.delete();
            File arqContasCliente = new File("contasCliente.txt"); 
            FileWriter fw = new FileWriter(arqContasCliente, true);
            PrintWriter pw = new PrintWriter(fw);

            int i;

            for(i=0; i<contas.size(); i++){
                pw.println("Conta " + (i+1) + ":" + contas.get(i));
                pw.flush();
            }
            pw.close();
        }
        
        /*Método que imprime as contas através do arquivo*/
        public void imprimeContas() throws FileNotFoundException, IOException{
            FileReader f = new FileReader("contasCliente.txt");
            BufferedReader in = new BufferedReader(f);
            String s;
            String total = "";
            while((s = in.readLine())!= null){
                total+=s + "\n";
            }
            JOptionPane.showMessageDialog(null, total, "Suas contas", JOptionPane.INFORMATION_MESSAGE);
            f.close();
            in.close();
        }
        /*Método para imprimir cliente*/
        public String toString(){
            String mensagem = "\nNome: " + this.nome + "\nEndereço: " + this.getEndereco() + "\nTelefone: " + this.getTelefone() + "\n";
            return mensagem;
        }
}
