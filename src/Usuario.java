import javax.swing.JOptionPane;

public class Usuario {
    private String login;
    private String senha;

    Usuario(){}

    Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;

    }
    public void cadastrarUsuario(String login, String senha) {
        EscreverTxt.gravarUsuario("users", login, senha);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
