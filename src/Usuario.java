import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.ArrayList;

public class Usuario {
    private String login;
    private String senha;

    Usuario(){}

    Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;

    }
    public void cadastrarUsuario() {
        login = JOptionPane.showInputDialog("Digite o login desejado: \n");
        senha = JOptionPane.showInputDialog("Digite a senha desejada: \n");
        EscreverTxt.gravarUsuario("users", login, senha);
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Cadastro realizado", JOptionPane.INFORMATION_MESSAGE);
    }

    public void verificaUsuario() throws IOException {
        ArrayList<String> ler = EscreverTxt.lerTxt("users");
        int z = 0;
        boolean verifUser = true;
        boolean verifSenha = true;
        login = JOptionPane.showInputDialog("Digite o login: \n");
        senha = JOptionPane.showInputDialog("Digite a senha: \n");
        for (String value : ler) {
            if (z % 2 == 0) {
                System.out.println(value);
                System.out.println(z);
                if (value.equals(login)) {
                    verifUser = true;
                } else {
                    verifUser = false;

                }
            } else {
                if (value.equals(senha)) {
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
}
