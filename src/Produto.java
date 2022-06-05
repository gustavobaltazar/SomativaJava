import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Produto {
    private String nome;
    private int quantidade;

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
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite quantidade"));
            prodsCru.add(nome);
            prodsCru.add(String.valueOf(quantidade));
            produtosListados.add(prodsCru);
            EscreverTxt.gravarProduto("produtos", nome, String.valueOf(quantidade));

            String opUser = JOptionPane.showInputDialog(null, "Deseja adicionar mais um lanche? [S / N]");
            opUser = opUser.toUpperCase(Locale.ROOT);
            if (opUser.equals("N")){
                JOptionPane.showMessageDialog(null, produtosListados);
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
        ArrayList<String> ses = EscreverTxt.lerProduto("produtos");

        int count = 0;

        System.out.println(ses);
        for (String val: ses) {
            if(count % 2 == 0){
                item.add(val);

            }else{
                qtd.add(val);

            }
            count++;
        }
        produtosListados.add(ses);

            for (int i = 0; i < item.size(); i++) {
                retorno = retorno.concat(String.format("\n%d Produto: %s ................... %s", i+1, item.get(i), qtd.get(i)));

            }

            JOptionPane.showMessageDialog(null, "Os produtos sao: "+retorno);
            int valorAlterado = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual produto deseja alterar? \n" + produtosListados));
            String valorDesejado = JOptionPane.showInputDialog(null, "Digite o valor desejado: \n" + produtosListados);
            int quantidadeDesejada = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade desejada: \n" + produtosListados));

            produtosListados.get(valorAlterado).set(0, valorDesejado);
            produtosListados.get(valorAlterado).set(1, String.valueOf(quantidadeDesejada));

            JOptionPane.showMessageDialog(null, "Os produtos agora sao: "+produtosListados);

        return retorno;
    }

    public void listarProduto() {
        ArrayList<String> it = new ArrayList<>();
        ArrayList<String> qt = new ArrayList<>();
        ArrayList<String> sas = EscreverTxt.lerProduto("produtos");
        String ret = "";

        int count = 0;

        System.out.println(sas);
        for (String val: sas) {
            if(count % 2 == 0){
                it.add(val);

            }else{
                qt.add(val);

            }
            count++;
        }
        for (int i = 0; i < it.size(); i++) {
            ret = ret.concat(String.format("\n%d Produto: %s ................... %s", i+1, it.get(i), qt.get(i)));

        }
        JOptionPane.showMessageDialog(null, ret);
    }

    public void removerProduto() {
        ArrayList<String> sim = EscreverTxt.lerProduto("produtos");
        produtosListados.add(sim);
        String retorno = "";
        ArrayList<String> item = new ArrayList<>();
        ArrayList<String> qtd = new ArrayList<>();


        int count = 0;

        System.out.println(sim);
        for (String val: sim) {
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
        int valorAlterado = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual produto deseja excluir? \n" + produtosListados));
//        String valorDesejado = JOptionPane.showInputDialog(null, "Digite o valor desejado: \n" + produtosListados);
        System.out.println(produtosListados);
        produtosListados.get(valorAlterado).remove(valorAlterado + 1);
        produtosListados.get(valorAlterado).remove(valorAlterado);



        JOptionPane.showMessageDialog(null, "Os produtos agora sao: "+produtosListados);
    }
}
