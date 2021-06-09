
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

public class Loja {
    public String nome;
    public int numero;
    private String cnpj;
    public ArrayList<Funcionario>funcionarios = new ArrayList<Funcionario>();
    public ArrayList<Produto>produtos = new ArrayList<Produto>();
    public ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public double ganho = 0;
/*-------------------------ARQUIVOS-----------------------------------*/
    File arqEstoque = new File("estoqueLoja.txt");
    File arqFuncLoja = new File("funcionariosLoja.txt");
    File arqClienteLoja = new File("clientesLoja.txt");

/*--------------------------LOJA---------------------------------------*/
    /* Construtor da classe loja */
    public Loja(String nome, String cnpj, int numero) {
	this.nome = nome;
	this.cnpj = cnpj;
	this.numero = numero;
    }
	
    public String getCNPJ() {
	return this.cnpj;
    }
	
    public double getGanho(){
	return ganho;
    }
        /*Método que imprime os dados da loja*/
    public String toString(){
        String mensagem = "Nome: " + this.nome + "\nNúmero: " + this.numero + "\nCNPJ: " + this.cnpj + "\n";
        return mensagem;
    }

/*------------------------------------ESTOQUE-------------------------------------------------------------------*/
    
    /* Método que cadastra um produto */
    public void cadastrarProdutos(Produto produto) throws IOException {
	produtos.add(produto);
        salvarEstoque(produtos);
    }
    
    /*Método que salva o estoque em arquivo*/
    
    public void salvarEstoque(ArrayList<Produto> produtos) throws IOException{
        if(arqEstoque.exists())
                arqEstoque.delete();
        File arqEstoque = new File("estoqueLoja.txt"); 
        
        FileWriter fw = new FileWriter(arqEstoque, true);
        PrintWriter pw = new PrintWriter(fw);

        int i;

        for(i=0; i<produtos.size(); i++){
            pw.println("Produto " + (i+1) + ":" + produtos.get(i));
            pw.flush();
        }
        pw.close();
    }
    
     /* Método que consulta a quantidade de um produto */
    public int consultaProduto(Produto produto) {
	for(int i = 0 ; i < produtos.size() ; i++) {
            if(produto.codigo == produtos.get(i).codigo) {
		return produtos.get(i).quantidadeEstoque;
            }
	}
	return 0;
    }
	
    /* Método que altera o valor de um produto */
    public void alteraValorProduto(Produto produto, double novoValor) throws IOException {
	for(int i = 0 ; i < produtos.size() ; i++) {
            if(produto.codigo == produtos.get(i).codigo) {
                produtos.get(i).valor_produto = novoValor;
            }
	}
        salvarEstoque(produtos);
    }

    /* Método que vende um produto */
    public double reduzirEstoque(Produto produto, int quantidade) throws IOException {
	double gasto = 0;
	for(int i = 0 ; i < produtos.size() ; i++) {
            if((produto.codigo) == produtos.get(i).codigo) {
		gasto += produtos.get(i).vender(quantidade);
            }
	}
	ganho += gasto;
        salvarEstoque(produtos);
	return gasto;
    }
    
    /*Método que imprime o estoque de um produto*/
    public void imprimirEstoque() throws FileNotFoundException, IOException{
        FileReader f = new FileReader("estoqueLoja.txt");
        BufferedReader in = new BufferedReader(f);
        String s;
        String total = "";
        while((s = in.readLine())!= null){
            total+=s + "\n";
        }
        JOptionPane.showMessageDialog(null, "Produtos", "Estoque loja", JOptionPane.PLAIN_MESSAGE);
        f.close();
        in.close();
    }
    
//------------------------FUNCIONARIOS---------------------------------------//
    
    /* Método que cadastra um funcionário */
    public void cadastrarFuncionarioLoja(Funcionario funcionario) throws IOException {
        int dep;
        double salario;
        
        dep = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de dependentes", "Cadastro de Funcionário", JOptionPane.INFORMATION_MESSAGE));
        salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Salário", "Cadastro de Funcionário", JOptionPane.INFORMATION_MESSAGE));
        funcionario.setDependentes(dep);
        funcionario.setSalario(salario);
	funcionario.setLoja(this);
        funcionarios.add(funcionario);
        salvaFuncionarios();
    }
	
    /* Método que demite um funcionário */
    public void demiteFuncionario(Funcionario funcionario) throws IOException {
		
	for(int i = 0 ; i < funcionarios.size() ; i++) {
            if((funcionario.getCPF()).equals(funcionarios.get(i).getCPF())) {
                funcionarios.remove(i);
                salvaFuncionarios();
            }
        }
		
    }
    
    /* Método que salva funcionarios em arquivo */
    public void salvaFuncionarios() throws IOException{
        if(arqFuncLoja.exists())
                arqFuncLoja.delete();
        File arqFuncLoja = new File("funcionariosLoja.txt"); 
        FileWriter fw = new FileWriter(arqFuncLoja, true);
        PrintWriter pw = new PrintWriter(fw);

        int i;

        for(i=0; i<funcionarios.size(); i++){
            pw.println("Funcionário " + (i+1) + ":" + funcionarios.get(i));
            pw.flush();
        }
        pw.close();
    }
    
    /* Método que imprime funcionarios */
    public void imprimeFuncionarios() throws FileNotFoundException, IOException{
        FileReader f = new FileReader("funcionariosLoja.txt");
        BufferedReader in = new BufferedReader(f);
        String s;
        while((s = in.readLine())!= null){
            System.out.println(s);
        }
        f.close();
        in.close();
    }
/*---------------------------------CLIENTES------------------------------------------------------------*/
    public void cadastrarCliente(Cliente cliente) throws IOException{
        clientes.add(cliente);
        salvaClientes();
    }
    public void excluiCliente(Cliente cliente) throws IOException{
        int i, flag=0;
        for(i=0; i<clientes.size(); i++){
            if(clientes.get(i).getCPF().equals(cliente.getCPF())){
                clientes.remove(i);
                flag++;
            }
        }
        if(flag==0){
            JOptionPane.showMessageDialog(null, "Cliente não encontrado", "Excluindo cliente", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        else
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso", "Excluindo cliente", JOptionPane.INFORMATION_MESSAGE);
        
        salvaClientes();
    }
    
    public void alteraCliente(Cliente cliente) throws IOException{
        int i;
        String novoValor = "";
        Object[] valores = {"Nome", "Endereço", "Telefone"};
        
        for(i=0; i<clientes.size(); i++){
            if(clientes.get(i).getCPF().equals(cliente.getCPF())){        
                Object selectedValue = JOptionPane.showInputDialog(null, "Escolha o campo para ser alterado", "Alteração Cliente", JOptionPane.INFORMATION_MESSAGE, null, valores, valores[0]);
                if(selectedValue.equals(valores[0])){
                    novoValor = JOptionPane.showInputDialog(null, "Digite o novo nome", "Altera cliente", JOptionPane.INFORMATION_MESSAGE);
                    clientes.get(i).nome = novoValor;
                }
                if(selectedValue.equals(valores[1])){
                    int numero;
                    String rua, bairro, cep, complemento;
                    rua = JOptionPane.showInputDialog(null, "Digite a rua", "Altera Endereço", JOptionPane.INFORMATION_MESSAGE);
                    numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número", "Altera Endereço", JOptionPane.INFORMATION_MESSAGE));
                    bairro = JOptionPane.showInputDialog(null, "Digite o bairro", "Altera Endereço", JOptionPane.INFORMATION_MESSAGE);
                    cep = JOptionPane.showInputDialog(null, "Digite o CEP", "Altera Endereço", JOptionPane.INFORMATION_MESSAGE);
                    complemento = JOptionPane.showInputDialog(null, "Digite o complemento", "Altera Endereço", JOptionPane.INFORMATION_MESSAGE);
                    
                    Endereco novo = new Endereco(rua, bairro, numero, cep, complemento);
                    clientes.get(i).setEndereco(novo);
                }
                if(selectedValue.equals(valores[2])){
                    novoValor = JOptionPane.showInputDialog(null, "Digite o novo telefone", "Altera Cliente", JOptionPane.INFORMATION_MESSAGE);
                    clientes.get(i).setTelefone(novoValor);
                }
            }
        }
        
        salvaClientes();
    }
    
    public void imprimeClientes() throws IOException{
        FileReader f = new FileReader("clientesLoja.txt");
        BufferedReader in = new BufferedReader(f);
        String s;
        while((s = in.readLine())!= null){
            System.out.println(s);
        }
        f.close();
        in.close();
    }
    
    public void salvaClientes() throws IOException{
        if(arqClienteLoja.exists())
            arqClienteLoja.delete();
        File arqClienteLoja = new File("clientesLoja.txt"); 
        FileWriter fw = new FileWriter(arqClienteLoja, true);
        PrintWriter pw = new PrintWriter(fw);

        int i;

        for(i=0; i<clientes.size(); i++){
            pw.println("Cliente " + (i+1) + ":" + clientes.get(i));
            pw.flush();
        }
        pw.close();
    }

}
