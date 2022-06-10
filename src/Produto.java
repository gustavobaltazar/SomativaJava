import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Produto {
    private String nome;
    private int quantidade;
    private ArrayList<String> sas = new ArrayList<>();

    Produto(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    ArrayList<ArrayList<String>> produtosListados = new ArrayList<>();

    boolean hasNext = true;

    Produto() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void adicionarProduto() {
        while(hasNext) {
            ArrayList<String> prodsCru = new ArrayList<>();
            String nome = JOptionPane.showInputDialog(null,"Digite o nome do produto");
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Digite quantidade"));
            prodsCru.add(nome);
            prodsCru.add(String.valueOf(quantidade));
            produtosListados.add(prodsCru);
            EscreverTxt.gravarProduto("produtos", nome, String.valueOf(quantidade));

            String opUser = JOptionPane.showInputDialog(null,
                    "Deseja adicionar mais um lanche? [S / N]");
            opUser = opUser.toUpperCase(Locale.ROOT);
            if (opUser.equals("N")){
                JOptionPane.showMessageDialog(null, this.sas);
                break;
            } else if(!opUser.equals("S")) {
                JOptionPane.showMessageDialog(null, "Opcao inválida.");
            }
        }
    }

    public String alterarProduto() {
        String retorno = "";
        ArrayList<String> item = new ArrayList<>();
        ArrayList<String> qtd = new ArrayList<>();
        int count = 0;

        System.out.println(this.sas);
        for (String val: this.sas) {
            if(count % 2 == 0){
                item.add(val);

            }else{
                qtd.add(val);

            }
            count++;
        }
            for (int i = 0; i < item.size(); i++) {
                retorno = retorno.concat(String.format("\n%d Produto: %s ................... %s", i+1, item.get(i), qtd.get(i)));

            }

            JOptionPane.showMessageDialog(null, "Os produtos sao: "+retorno);
            int valorAlterado = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Qual produto deseja alterar? \n" + this.sas));
            String valorDesejado = JOptionPane.showInputDialog(null,
                    "Digite o valor desejado: \n" + this.sas);
            int quantidadeDesejada = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Digite a quantidade desejada: \n" + this.sas));

            this.sas.set(0,valorDesejado);
            this.sas.set(1, String.valueOf(quantidadeDesejada));
            EscreverTxt.gravarTxtAux("auxiliar", "produtos", this.sas);

//            EscreverTxt.gravarTxtAux("auxiliar","produtos", this.sas);
            JOptionPane.showMessageDialog(null, "Os produtos agora sao: "+this.sas);
            this.sas.clear();

        return retorno;
    }
    public void preencheArray(){
      this.sas =  EscreverTxt.lerProduto("produtos");
    }
    public void listarProduto() {
        preencheArray();
        ArrayList<String> it = new ArrayList<>();
        ArrayList<String> qt = new ArrayList<>();

        String ret = "";

        int count = 0;

        for (String value: this.sas) {
            if(count % 2 == 0){
                it.add(value);

            }else{
                qt.add(value);

            }
            count++;
        }
        ret = "";
        for (int i = 0; i < it.size(); i++) {
            ret = ret.concat(String.format("\n%d Produto: %s ................... %s", i+1, it.get(i), qt.get(i)));
        }
        this.sas.clear();
        preencheArray();
        JOptionPane.showMessageDialog(null, ret);
    }

    public void removerProduto() {
        this.sas.clear();
        preencheArray();
        produtosListados.add(this.sas);
        String retorno = "";
        ArrayList<String> item = new ArrayList<>();
        ArrayList<String> qtd = new ArrayList<>();

        int count = 0;

        System.out.println(this.sas);
        for (String val: this.sas) {
            if(count % 2 == 0){
                item.add(val);

            }else{
                qtd.add(val);

            }
            count++;
        }

        for (int i = 0; i < item.size(); i++) {
            retorno = retorno.concat(String.format("\n%d Produto: %s ................... %s", i+1, item.get(i), qtd.get(i)));

        }

        JOptionPane.showMessageDialog(null, "Os produtos sao: "+retorno);
        int valorAlterado = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Qual produto deseja excluir? \n" + this.sas));
        int soma = valorAlterado + 1;
        this.sas.remove(soma);
        this.sas.remove(valorAlterado);
        System.out.println("array deletado:" + this.sas);
        EscreverTxt.gravarTxtAux("auxiliar", "produtos", this.sas);
        this.sas.clear();
        JOptionPane.showMessageDialog(null, "Valor removido");

    }
}
