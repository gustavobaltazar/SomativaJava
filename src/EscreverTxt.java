import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Scanner;

public class EscreverTxt {
    private String nome;
    private List<String> lista;
    private String login;
    private String senha;
    private static Scanner x;

    private static ArrayList<String> prod = new ArrayList<>();

    public static void gravarLogTxt(String nome, List<String> lista) {
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
        ArrayList<String> dados = new ArrayList<>((Files.readAllLines(caminho)));
        System.out.println(dados);

        return dados;
    }

    public static void gravarUsuario(String nome, String login, String senha) {
        ArrayList<String> usuarios = new ArrayList<>();
        Path caminho = Paths.get(nome + ".txt");
        usuarios.add(login);
        usuarios.add(senha);

        try {
            if (Files.exists(caminho)) {
                Files.write(caminho, usuarios, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            } else {
                Files.write(caminho, usuarios, StandardCharsets.UTF_8);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void gravarProduto(String n, String nome, String quantidade) {
        ArrayList<String> produtos = new ArrayList<>();
        Path caminho = Paths.get(n + ".txt");
        produtos.add(nome);
        produtos.add(quantidade);

        try {
            if (Files.exists(caminho)) {
                Files.write(caminho, produtos, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            } else {
                Files.write(caminho, produtos, StandardCharsets.UTF_8);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void gravarTxtAux(String n,String newName, ArrayList<String> products) {
        ArrayList<String> auxiliar = new ArrayList<>();
        Path camin = Paths.get(n + ".txt");
        Path paths = Paths.get(newName + ".txt");

        String result = String.join(" \n", products);
        auxiliar.add(result);

        try {
                System.out.println("Produtos: " + products);

            if (Files.exists(paths)) {
                System.out.println("PATHS:" +paths);
                System.out.println("PRODutos" +products);
                Files.write(paths, products, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
            } else {
                Files.write(paths, products, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
            }if (Files.exists(camin)) {
                Files.write(paths, products, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
            } else {
                Files.write(paths, products, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> lerProduto(String nome) {
        Path path = Paths.get(nome + ".txt");
        try {
            List<String> contents = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String content : contents) {
                prod.add(content);
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prod;
    }
}