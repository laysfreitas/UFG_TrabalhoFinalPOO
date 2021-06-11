package projectfinalpoo;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.*;
import java.lang.*;


public class Shopping{
	private String cnpj;
	public String nome;
	public Endereco endereco;
	public ArrayList<Funcionario>funcionarios = new ArrayList<Funcionario>();
	public ArrayList<Loja>lojas = new ArrayList<Loja>();
        
        File arqShopp = new File("shopping.txt");
        File arqFunc = new File("funcionariosShopping.txt");
        File arqLoja = new File("lojasShopping.txt");
	
	/* Método cosntrutor do Shopping*/
	public Shopping(String cnpj, String nome, Endereco endereco) throws IOException {
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.nome = nome;
                salvaShopping();
	}
        /* Método que salva shopping no arquivo*/
        public void salvaShopping() throws IOException{
            FileWriter fw = new FileWriter(arqShopp);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("CNPJ: " + this.cnpj);
            pw.flush();
            pw.println("NOME: " + this.nome);
            pw.flush();
            pw.println("ENDEREÇO: " + this.endereco);
            pw.flush();
            fw.close();
            pw.close();
        }
        /* Método que altera Shopping*/
        public void alteraShopping(String nome, Endereco endereco) throws IOException{
            this.nome = nome;
            this.endereco = endereco;
            salvaShopping();
        }
        /* Método que imprime Shopping*/
        public void imprimeShopping() throws FileNotFoundException, IOException{
            FileReader f = new FileReader("shopping.txt");
            BufferedReader in = new BufferedReader(f);
            String s;
            while((s = in.readLine())!= null){
                System.out.println(s);
            }
            f.close();
            in.close();
        }
        
	public String getCNPJ() {
		return this.cnpj;
	}
        
	/* Método para cadastrar loja */
	public void cadastrarLoja(Loja loja) throws IOException {
		lojas.add(loja);
                salvarLojas(lojas);
	}
	
	/* Método para cadastrar funcionário */
	public void cadastrarFuncionario(Funcionario funcionario) throws IOException {
            int dep;
            double salario;
        
            dep = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de dependentes", "Cadastro de Funcionário", JOptionPane.INFORMATION_MESSAGE));
            salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Salário", "Cadastro de Funcionário", JOptionPane.INFORMATION_MESSAGE));
            funcionario.setDependentes(dep);
            funcionario.setSalario(salario);
            funcionario.setShopping(this);
            funcionarios.add(funcionario);
            salvarFuncionarios(funcionarios);
	}
	
	/* Método que demite funcionário */
	public void demiteFuncionario(String CPF) throws IOException {
		
		for(int i = 0 ; i < funcionarios.size() ; i++) {
			if((CPF).equals(funcionarios.get(i).getCPF())) {
				funcionarios.remove(i);
			}
		}
                salvarFuncionarios(funcionarios);
		
	}
        /* Método que altera funcionário*/
        public void alteraFuncionario(String CPF) throws IOException{
            int i;
            String novoValor = "";
            Object[] valores = {"Nome", "Endereço", "Telefone"};
        
            for(i=0; i<funcionarios.size(); i++){
                if(funcionarios.get(i).getCPF().equals(CPF)){        
                    Object selectedValue = JOptionPane.showInputDialog(null, "Escolha o campo para ser alterado", "Alteração Funcionário", JOptionPane.INFORMATION_MESSAGE, null, valores, valores[0]);
                    if(selectedValue.equals(valores[0])){
                        novoValor = JOptionPane.showInputDialog(null, "Digite o novo nome", "Altera Funcionário", JOptionPane.INFORMATION_MESSAGE);
                        funcionarios.get(i).nome = novoValor;
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
                        funcionarios.get(i).setEndereco(novo);
                    }
                    if(selectedValue.equals(valores[2])){
                        novoValor = JOptionPane.showInputDialog(null, "Digite o novo telefone", "Altera Funcionario", JOptionPane.INFORMATION_MESSAGE);
                        funcionarios.get(i).setTelefone(novoValor);
                    }
                }
            salvarFuncionarios(funcionarios);
            }
        }
        
        /*Método que atribui salário a um funcionário*/
        public void atribuiSalarioFuncionario(){
            int i;
            String CPF;
            double valor;
            
            CPF = JOptionPane.showInputDialog(null, "Informe o CPF do funcionário", "Atribui Salário", JOptionPane.INFORMATION_MESSAGE);
            for(i=0; i<funcionarios.size();i++){
                if(funcionarios.get(i).getCPF().equals(CPF)){
                    try{
                        valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor do salário", "Atribui salário", JOptionPane.INFORMATION_MESSAGE));
                    }
                    catch(Exception fee){
                        System.out.println("Formato inválido");
                    }
                    
                }
            }
        }
        /* Método que salva funcionário em arquivo*/
        public void salvarFuncionarios(ArrayList<Funcionario> func) throws IOException{
            if(arqFunc.exists())
                arqFunc.delete();
            File arqFunc = new File("funcionariosShopping.txt"); 
            FileWriter fw = new FileWriter(arqFunc, true);
            PrintWriter pw = new PrintWriter(fw);

            int i;

            for(i=0; i<func.size(); i++){
                pw.println("Funcionário " + (i+1) + ":" + func.get(i));
                pw.flush();
            }
            pw.close();
            
        }
        /*Método que mostra os funcionários do arquvivo*/
        public void mostrarFuncionarios() throws FileNotFoundException, IOException{
            FileReader f = new FileReader("funcionariosShopping.txt");
            BufferedReader in = new BufferedReader(f);
            String s;
            while((s = in.readLine())!= null){
                System.out.println(s);
            }
            f.close();
            in.close();
        }
        /*Método que exclui loja*/
        public void desligaLoja(int numLoja) throws IOException{
            int i;
            for(i=0; i<lojas.size(); i++){
                if(lojas.get(i).numero==numLoja){
                    lojas.remove(i);
                }
            }
            salvarLojas(lojas);
        }
        /*Método que salva lojas em arquivo*/
        public void salvarLojas(ArrayList<Loja> lojas) throws IOException{
            if(arqLoja.exists())
                arqLoja.delete();
            else{
                File arqLoja = new File("lojasShopping.txt"); 
            }
            FileWriter fw = new FileWriter(arqLoja, true);
            PrintWriter pw = new PrintWriter(fw);

            int i;

            for(i=0; i<lojas.size(); i++){
                pw.println("Loja " + (i+1) + ":" + lojas.get(i));
                pw.flush();
            }
            pw.close();
        }
        /*Método que imprime lojas*/
        public void imprimeLojas() throws FileNotFoundException, IOException{
            FileReader f = new FileReader("lojasShopping.txt");
            BufferedReader in = new BufferedReader(f);
            String s;
            while((s = in.readLine())!= null){
                System.out.println(s);
            }
            f.close();
            in.close();
        }
        
	
}
