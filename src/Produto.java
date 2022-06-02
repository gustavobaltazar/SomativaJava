import javax.swing.*;
import java.util.ArrayList;
import java.util.Locale;

public class Produto {
    private String nome;
    private int quantidade;

    Produto(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    ArrayList<String> produtos = new ArrayList<>();
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

    public boolean alterarProduto() {
        int count = 0;
        String retorno = "";
        if (this.produtosListados.size() == 0){
            System.out.println("======================");
            System.out.println(" Nao existe produto");
            System.out.println("======================");
        }else {
            for (int i = 0; i < produtosListados.size(); i++) {
                retorno = retorno.concat(String.format("\n%d Produto: %s ................... %s", i+1, produtosListados.get(i).get(0), produtosListados.get(i).get(1)));

            }
            JOptionPane.showMessageDialog(null, "Os produtos sao: "+retorno);
            int valorAlterado = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual produto deseja alterar? \n" + produtosListados));
            String valorDesejado = JOptionPane.showInputDialog(null, "Digite o valor desejado: \n" + produtosListados);
            int quantidadeDesejada = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade desejada: \n" + produtosListados));
            produtosListados.get(valorAlterado).set(0, valorDesejado);
            produtosListados.get(valorAlterado).set(1, String.valueOf(quantidadeDesejada));
//            produtosListados.set(valorAlterado, valorDesejado);
//            produtosListados.set(valorAlterado + 1, String.valueOf(quantidadeDesejada));

            JOptionPane.showMessageDialog(null, "Os produtos agora sao: "+produtosListados);
            EscreverTxt.lerProduto("produtos");

        }
        return true;
    }

    public void listarProduto(ArrayList<String> produtos) {
        System.out.println(produtos);
    }

    private ArrayList<String> removerProduto(String nome, int quantidade) {
        return null;
    }
}
