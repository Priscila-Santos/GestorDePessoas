package Controller;

import Model.Pessoa;
import Util.ScannerUtil;

import java.util.ArrayList;
import java.util.List;

public class GerenciarPessoas {
    private List<Pessoa> pessoas = new ArrayList<>();

    // Adiciona uma nova pessoa
    public void adicionarPessoa() {
        String nome = ScannerUtil.ler("Digite o nome da pessoa: ");
        String documento = ScannerUtil.ler("Digite o documento da pessoa: ");
        Pessoa pessoa = new Pessoa(nome, documento);
        pessoas.add(pessoa);
        System.out.println("Pessoa adicionada com sucesso!");
    }

    // Lista todas as pessoas cadastradas e imprime a tabela
    public void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }

        StringBuilder builder = new StringBuilder();
        String cabecalho = String.format("| %-5s | %-20s | %-15s |\n", "ID", "Nome", "Documento");
        String linha = String.format("+%-7s+%-22s+%-17s+\n", "-----", "--------------------", "---------------");

        builder.append(linha);
        builder.append(cabecalho);
        builder.append(linha);

        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pessoa = pessoas.get(i);
            builder.append(String.format("| %-5d | %-20s | %-15s |\n", i + 1, pessoa.getNome(), pessoa.getDocumento()));
        }

        builder.append(linha);

        System.out.println(builder.toString());  // Imprime a tabela de pessoas
    }

    // Retorna o número de pessoas cadastradas
    public int getQuantidadePessoas() {
        return pessoas.size();
    }

    // Detalha uma pessoa específica
    public void detalharPessoa() {
        listarPessoas();  // Exibe as pessoas para o usuário escolher
        int index = Integer.parseInt(ScannerUtil.ler("Digite o ID que deseja detalhar: ")) - 1;

        if (index >= 0 && index < pessoas.size()) {
            Pessoa pessoa = pessoas.get(index);
            System.out.println("Detalhes da pessoa:");
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Documento: " + pessoa.getDocumento());
            System.out.println("Projetos" + pessoa.getProjetos());
            System.out.println("Tarefas" + pessoa.getTarefasIndependentes());
            // Adicione mais detalhes como projetos e tarefas

        } else {
            System.out.println("Número inválido.");
        }
    }

    // Retorna a pessoa pelo índice com validação
    public Pessoa getPessoa(int index) {
        if (index >= 0 && index < pessoas.size()) {
            return pessoas.get(index);
        } else {
            System.out.println("Índice inválido.");
            return null;
        }
    }

    // Retorna a lista de pessoas
    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void removerPessoa() {
        listarPessoas(); // Exibe a lista de pessoas para o usuário escolher
        int id = Integer.parseInt(ScannerUtil.ler("Digite o ID que deseja remover: ")) - 1;

        if (id >= 0 && id < pessoas.size()) {
            Pessoa pessoaRemovida = pessoas.remove(id);  // Remove a pessoa pelo índice
            System.out.println("Pessoa " + pessoaRemovida.getNome() + " removida com sucesso.");
        } else {
            System.out.println("ID inválido. Nenhuma pessoa foi removida.");
        }
    }


    public void editarPessoa() {
        listarPessoas();  // Exibe a lista de pessoas para o usuário selecionar
        int index = Integer.parseInt(ScannerUtil.ler("Digite o ID da pessoa que deseja editar: ")) - 1;

        if (index >= 0 && index < pessoas.size()) {
            Pessoa pessoa = pessoas.get(index);
            System.out.println("Editando a pessoa: " + pessoa.getNome());

            // Permite a edição do nome
            String novoNome = ScannerUtil.ler("Digite o novo nome (ou pressione Enter para manter o nome atual): ");
            if (!novoNome.isEmpty()) {
                pessoa.setNome(novoNome);
            }

            // Permite a edição do documento
            String novoDocumento = ScannerUtil.ler("Digite o novo documento (ou pressione Enter para manter o documento atual): ");
            if (!novoDocumento.isEmpty()) {
                pessoa.setDocumento(novoDocumento);
            }

            System.out.println("Pessoa editada com sucesso!");
        } else {
            System.out.println("Número inválido. Nenhuma pessoa foi editada.");
        }
    }
}
