import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

public class EscreverTxt {
    private String nome;
    private List<String> lista;
    private String login;
    private String senha;

    public static void gravarTxt(String nome, List<String> lista) {
        Path caminho = Paths.get(nome + ".txt");
        try {
            if (Files.exists(Paths.get("Log.txt")) && caminho.equals("Log.txt")) {
                Files.write(caminho, lista, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            } else {
                Files.write(caminho, lista, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> lerTxt(String nomeArquivo) throws IOException {
        Path caminho = Paths.get(nomeArquivo + ".txt");
        ArrayList<String> dados = new ArrayList<String>((Files.readAllLines(caminho)));
        System.out.println(dados);

        return dados;
    }

    public static void gravarUsuario( String nome, String login, String senha) {
        ArrayList<String> usuarios = new ArrayList<>();
        Path caminho = Paths.get(nome + ".txt");
        usuarios.add(login);
        usuarios.add(senha);

        try {
            if (Files.exists(caminho)){
                Files.write(caminho, usuarios, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            } else {
                Files.write(caminho, usuarios, StandardCharsets.UTF_8);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}