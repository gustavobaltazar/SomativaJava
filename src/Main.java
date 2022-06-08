import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) throws IOException {
        Usuario usuario = new Usuario();
        Produto manipulaProduto = new Produto();
        ArrayList<String> log = new ArrayList<>();

        log.add("Iniciou o programa as: " + LocalDateTime.now() + "\n");

        while(true) {
            int op_user = Integer.parseInt(JOptionPane.showInputDialog(Opcoes.Sim.getValue() + " para Cadastrar e " + Opcoes.Nao.getValue() + " para Logar: \n"));
            if (op_user == Opcoes.Sim.getValue()) {
                usuario.cadastrarUsuario();
                log.add("Criado um novo usuario as: " + LocalDateTime.now() + "\n");
            } else if (op_user == Opcoes.Nao.getValue()) {
                usuario.verificaUsuario();
                log.add("Usuario logou as: " + LocalDateTime.now() + "\n");
            }
            int user_choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite uma operação\n" +
                    "1- Adicionar Produto\n" +
                    "2- Alterar Quantidade\n " +
                    "3- Remover Produto\n" +
                    "4- Listar Produto\n" +
                    "5- Sair"));

            switch (user_choice) {
                case 1 -> {
                    manipulaProduto.adicionarProduto();
                    log.add("Adicionado um produto as: " + LocalDateTime.now() + "\n");
                }
                case 2 -> {
                    manipulaProduto.preencheArray();
                    manipulaProduto.alterarProduto();
                    log.add("Produto alterado as: " + LocalDateTime.now() + "\n");
                }
                case 3 -> {
                    manipulaProduto.preencheArray();
                    manipulaProduto.removerProduto();
                    log.add("Produto removido as: " + LocalDateTime.now() + "\n");
                }
                case 4 -> {
                    manipulaProduto.preencheArray();
                    manipulaProduto.listarProduto();
                    log.add("Produtos listados as: " + LocalDateTime.now() + "\n");
                }

            }
            log.add("Iniciou o programa as: " + LocalDateTime.now() + "\n");
        }
    }
}