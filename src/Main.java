import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) throws IOException {
        Usuario usuario = new Usuario();
        String Login = "";
        String Senha = "";
        int op_user = Integer.parseInt(JOptionPane.showInputDialog(Opcoes.Sim.getValue() + " para Cadastrar e " + Opcoes.Nao.getValue() + " para Logar: \n"));

        if (op_user == Opcoes.Sim.getValue()) {
            Login = JOptionPane.showInputDialog("Digite o login desejado: \n");
            Senha = JOptionPane.showInputDialog("Digite a senha desejada: \n");
            usuario.cadastrarUsuario(Login, Senha);
            System.out.println(EscreverTxt.lerTxt("users"));
        } else if (op_user == Opcoes.Nao.getValue()){
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
                    }else{
                        verifUser = false;

                    }
                } else {
                    if (value.equals(Senha)) {
                        verifSenha = true;
                    } else {
                        verifSenha = false;
                    }
                }
                z++;
                if(verifUser && verifSenha){
                    JOptionPane.showMessageDialog(null,"Usuario autenticado com sucesso","COrreto", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
            if (!verifUser && !verifSenha){
                JOptionPane.showMessageDialog(null,"Usuario e senha incorretos","ERRO", JOptionPane.ERROR_MESSAGE);
            }



            // erro do login, tem que vir dps do for each
        }
        //programa sai do login aqui.

    }
}