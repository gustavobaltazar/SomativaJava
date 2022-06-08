import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) throws IOException {
        Usuario usuario = new Usuario();
        Produto manipulaProduto = new Produto();

        while(true) {
            int op_user = Integer.parseInt(JOptionPane.showInputDialog(Opcoes.Sim.getValue() + " para Cadastrar e " + Opcoes.Nao.getValue() + " para Logar: \n"));
            if (op_user == Opcoes.Sim.getValue()) {
                usuario.cadastrarUsuario();
            } else if (op_user == Opcoes.Nao.getValue()) {
                usuario.verificaUsuario();
            }

            int user_choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite uma operação\n" +
                    "1- Adicionar Produto\n" +
                    "2- Alterar Quantidade\n " +
                    "3- Remover Produto\n" +
                    "4- Listar Produto\n"));

            switch (user_choice) {
                case 1 -> manipulaProduto.adicionarProduto();
                case 2 -> manipulaProduto.alterarProduto();
                case 3 -> manipulaProduto.removerProduto();
                case 4 -> {
                    manipulaProduto.preencheArray();
                    manipulaProduto.listarProduto();
                }
            }
        }
    }
}