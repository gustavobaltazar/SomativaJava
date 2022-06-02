import javax.swing.*;
import java.util.ArrayList;
import java.util.Locale;

public class Produto {
    private String nome;
    private int quantidade;

    ArrayList<String> produtos = new ArrayList<>();
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
            String nome = JOptionPane.showInputDialog(null,"Digite o nome do produto");
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite quantidade"));
            produtos.add(nome);
            produtos.add(String.valueOf(quantidade));
            String opUser = JOptionPane.showInputDialog(null, "Deseja adicionar mais um lanche? [S / N]");
            opUser = opUser.toUpperCase(Locale.ROOT);
            if (opUser.equals("N")){
                return;
            } else if(!opUser.equals("S")) {
                JOptionPane.showMessageDialog(null, "Opcao inválida.");
            }
        }
    }




    public void listarProduto(ArrayList<String> produtos) {
        System.out.println(produtos);
    }

    private ArrayList<String> removerProduto(String nome, int quantidade) {
        return null;
    }
}
