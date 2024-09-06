package Model.Contatos;

import Util.ScannerUtil;

import java.util.List;

public abstract class Contato{
    private static String nome;
    private static String telefone;
    private static String endereco;
    private static String email;

    public Contato(String nome, String telefone, String endereco, String email) {
        setNome(nome);
        setTelefone(telefone);
        setEndereco(endereco);
        setEmail(email);
    }

    @Override
    public abstract String toString();

    public abstract void imprimirContato();

    public static String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("Nome inválido. Por favor, adicione um nome.");
        }
        this.nome = nome;
    }

    public static String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        if (telefone == null || !telefone.matches("\\d{4,5}-\\d{4}")) {
            throw new IllegalArgumentException("Telefone inválido. Por favor adicione um número valid exemplo: 1234-5678");
        }
        this.telefone = telefone;
    }

    public static String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || !endereco.matches(".*\\d+.*") || !endereco.matches(".*\\b(Rua|numero|Bairro)\\b.*")) {
            throw new IllegalArgumentException("Endereço inválido. Deve conter rua, número e bairro.");
        }
        this.endereco = endereco;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches(".+@.+\\..+")) {
            throw new IllegalArgumentException("Email inválido. Formato esperado: exemplo@email.com.");
        }
        this.email = email;
    }

    /*public static String editarContato(List<Contato> contatos, ScannerUtil entrada) {
        return null;
    }

    public abstract String adicionarContato(List<Contato> contatos, ScannerUtil entrada);

    public abstract String editarContato(List<Contato> contatos, ScannerUtil entrada);

    public abstract String removerContato(List<Contato> contatos, ScannerUtil entrada); */

}
