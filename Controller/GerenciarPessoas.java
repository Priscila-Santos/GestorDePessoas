package Controller;

import Model.Pessoa;
import Util.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class GerenciarPessoas {
    private List<Pessoa> pessoas;

    public GerenciarPessoas() {
        pessoas = new ArrayList<>();
    }

    private Pessoa encontrarPessoa(String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nome)) {
                return pessoa;
            }
        }
        return null;
    }

    public void adicionarPessoa(){
        String nome = ScannerUtil.ler("Digite o nome da pessoa: ");
        String documento = ScannerUtil.ler("Digite um documento da pessoa: ");
        Pessoa pessoa = new Pessoa(nome, documento);
        System.out.println("Digite as informações do contato pessoal: \n");
        pessoa.adicionarContatoPessoal();
        System.out.println(pessoa);
        pessoas.add(pessoa);
    }

    public void detalharPessoa() {
        String nome = ScannerUtil.ler("Digite o nome da pessoa: ");
        Pessoa pessoa = encontrarPessoa(nome);
        if (pessoa != null) {
            System.out.println("Detalhes da pessoa:");
            System.out.println("Documento: " + pessoa.getDocumento());
            System.out.println("Projetos: " + pessoa.getProjetos());
            System.out.println("Tarefas: " + pessoa.getTarefas());
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }

    public void editarPessoa() {
        String nome = ScannerUtil.ler("Digite o nome da pessoa que deseja editar: ");
        Pessoa pessoa = encontrarPessoa(nome);
        if (pessoa != null) {
            String novoNome = ScannerUtil.ler("Digite o novo nome: ");
            pessoa.setNome(novoNome);
            System.out.println("Pessoa editada com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }

    public void removerPessoa() {
        String nome = ScannerUtil.ler("Digite o nome da pessoa que deseja remover: ");
        Pessoa pessoa = encontrarPessoa(nome);
        if (pessoa != null) {
            String confirmacao = ScannerUtil.ler("Tem certeza que deseja remover essa pessoa da sua agenda? S/N ");
            if (confirmacao.equalsIgnoreCase("S")) {
                pessoas.remove(pessoa);
                System.out.println("Pessoa removida com sucesso!");
            } else {
                System.out.println("Operação cancelada.");
            }
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }


    public String listarPessoas() {
        if (pessoas.isEmpty()) {
            return "Nenhuma pessoa cadastrada.";
        } else {
            StringBuilder listaPessoas = new StringBuilder();
            for (int i = 0; i < pessoas.size(); i++) {
                listaPessoas.append(i + 1).append(". ").append(pessoas.get(i)).append("\n");
            }
            return listaPessoas.toString();
        }
    }

    }
