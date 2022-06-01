import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) throws IOException {
        Usuario usuario = new Usuario();
        Produto manipulaProduto = new Produto();
        String Login = "";
        String Senha = "";
        String produto;
        int qtd;

        while (true) {
            int op_user = Integer.parseInt(JOptionPane.showInputDialog(Opcoes.Sim.getValue() + " para Cadastrar e " + Opcoes.Nao.getValue() + " para Logar: \n"));
            if (op_user == Opcoes.Sim.getValue()) {
                Login = JOptionPane.showInputDialog("Digite o login desejado: \n");
                Senha = JOptionPane.showInputDialog("Digite a senha desejada: \n");
                usuario.cadastrarUsuario(Login, Senha);
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Cadastro realizado", JOptionPane.INFORMATION_MESSAGE);
                break;
            } else if (op_user == Opcoes.Nao.getValue()) {
                ArrayList<String> ler = EscreverTxt.lerTxt("users");
                int z = 0;
                boolean verifUser = true;
                boolean verifSenha = true;
                Login = JOptionPane.showInputDialog("Digite o login: \n");
                Senha = JOptionPane.showInputDialog("Digite a senha: \n");
                for (String value : ler) {
                    if (z % 2 == 0) {
                        System.out.println(value);
                        System.out.println(z);
                        if (value.equals(Login)) {
                            verifUser = true;
                        } else {
                            verifUser = false;

                        }
                    } else {
                        if (value.equals(Senha)) {
                            verifSenha = true;
                        } else {
                            verifSenha = false;
                        }
                    }
                    if (verifUser && verifSenha) {
                        break;
                    }
                    z++;

                }
                if (!verifUser || !verifSenha) {
                    JOptionPane.showMessageDialog(null, "Usuario e senha incorretos", "ERRO", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);

                } else {
                    JOptionPane.showMessageDialog(null, "Usuario autenticado com sucesso", "Correto", JOptionPane.INFORMATION_MESSAGE);

                }
            }

            int user_choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite uma operação\n" +
                    "1- Adicionar Produto\n" +
                    "2- Alterar Quantidade\n " +
                    "3- Remover Produto\n" +
                    "4- Listar Produto\n"));

            switch (user_choice) {
                case 1:
                    produto = JOptionPane.showInputDialog("Digite o nome do produto: \n");
                    qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade do produto: \n"));
                    manipulaProduto.adicionarProduto(produto, qtd);
            }
        }
    }
}