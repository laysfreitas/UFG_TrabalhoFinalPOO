package projectfinalpoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ContaCliente {
    public ArrayList<Compra>compras = new ArrayList<Compra>();
    public Shopping shopping;
    public Cliente cliente;
    public Date data; // data de criação da conta
    public Loja loja;
    public int numLoja;
    public Compra compra;

    File arqCompras = new File("comprasCliente.txt");
    
    /* Construtor da classe ContaCliente*/
    public ContaCliente(Cliente cliente, Date data, int numLoja) {
    	this.cliente = cliente;
    	this.data = data;
    	this.numLoja = numLoja;
        setLoja();
    }
    
    public void setLoja(){
        for(int i=0; i<shopping.lojas.size();i++){
            if(shopping.lojas.get(i).numero==numLoja)
                this.loja = shopping.lojas.get(i);
        }
    }
    
    public void registraCompra(Cliente cliente) throws IOException{
        int numero, cod, qtd;
        String nomeVend;
        numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da loja", "Compra", JOptionPane.INFORMATION_MESSAGE));
        nomeVend = JOptionPane.showInputDialog(null, "Digite o nome do vendendor", "Compra", JOptionPane.INFORMATION_MESSAGE);
        compra = new Compra(loja, nomeVend);
        
        int i;
        for(i=0; i<shopping.lojas.size(); i++){
            if(shopping.lojas.get(i).numero==numero)
                this.loja = shopping.lojas.get(i);
        }
        loja.imprimirEstoque();
        
        cod = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do produto a ser comprado", "Compra", JOptionPane.INFORMATION_MESSAGE));
        qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade", "Compra", JOptionPane.INFORMATION_MESSAGE));
        for(i=0; i<loja.produtos.size(); i++){
            if(loja.produtos.get(i).codigo==cod){
                if(loja.produtos.get(i).quantidadeEstoque<qtd){
                    JOptionPane.showMessageDialog(null, "Quantidade indisponível", "Compra", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                else{
                    compra.adicionaProdutos(loja.produtos.get(i), qtd);
                    loja.produtos.get(i).vender(qtd);
                }
                
            }
        }
        adicionaCompra(compra);
        JOptionPane.showMessageDialog(null, "Valor da compra" + compra.valorCompra() + "\n", "Compra", JOptionPane.INFORMATION_MESSAGE);  
        JOptionPane.showMessageDialog(null, "Comprovante" + compra.emitirComprovante() + "\n", "Compra", JOptionPane.INFORMATION_MESSAGE);
    }
    /* Método que adiciona compra na conta do cliente*/
    public void adicionaCompra(Compra compra) throws IOException{
        compras.add(compra);
        salvaHistorico();
    }

    public void salvaHistorico() throws IOException{
        if(arqCompras.exists())
            arqCompras.delete();
        File arqCompras = new File("comprasCliente.txt"); 
            
        FileWriter fw = new FileWriter(arqCompras, true);
        PrintWriter pw = new PrintWriter(fw);

        int i;

        for(i=0; i<compras.size(); i++){
            pw.println("Compra " + (i+1) + ":" + compras.get(i));
            pw.flush();
        }
        pw.close();
    }
    
    public void lerCompras() throws FileNotFoundException, IOException{
        FileReader f = new FileReader("comprasCliente.txt");
        BufferedReader in = new BufferedReader(f);
        String s;
        String total = "";
        while((s = in.readLine())!= null){
            total+=s + "\n";
        }
        JOptionPane.showMessageDialog(null, "Lista de Compras", "Compras", JOptionPane.PLAIN_MESSAGE);
        f.close();
        in.close();
    }
    
    /* Método que faz a troca de dois produtos de uma compra */
    public void solicitaTroca(int codProduto1, int codProduto2, int codigoCompra, int codProduto) throws IOException{
    	for(int i = 0; i < compras.size(); i++) {
            if(compras.get(i).codigo == codigoCompra ) {
                for(int j=0; j<compras.get(i).produtos.size();j++){
                    if(compras.get(i).produtos.get(j).codigo==codProduto){
                        compras.get(i).produtos.get(j).quantidadeCompra--;
                        compras.get(i).produtos.get(j).acrescentaEstoque(codProduto);
                        compras.get(i).produtos.remove(j);
                        for(int y = 0; y<loja.produtos.size(); y++){
                            if(loja.produtos.get(i).codigo==codProduto2){
                                compras.get(i).adicionaProdutos(loja.produtos.get(i), 1);
                            }
                        }
                    }
                }
            }
    	}
        salvaHistorico();
    }
    
    public String toString() {
        String mensagem = "\nCliente: " + this.cliente + "\nLoja: " + this.loja + "\nData criação: " + this.data + "\n";
    	return mensagem;
    }

}
