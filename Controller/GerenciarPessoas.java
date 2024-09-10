package Controller;

import Model.Contatos.ContatoPessoal;
import Model.Pessoa;
import Util.ScannerUtil;

import java.util.ArrayList;
import java.util.List;

public class GerenciarPessoas {
    private List<Pessoa> pessoas = new ArrayList<>();


    public void adicionarPessoa() {
        String nome = ScannerUtil.ler("Digite o nome da pessoa: ");
        String documento = ScannerUtil.ler("Digite o documento da pessoa: ");
        Pessoa pessoa = new Pessoa(nome, documento);
        pessoas.add(pessoa);
        System.out.println("Pessoa adicionada com sucesso!");
    }


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

        System.out.println(builder.toString());
    }


    public int getQuantidadePessoas() {
        return pessoas.size();
    }


    public void detalharPessoa() {
        listarPessoas();
        int index = Integer.parseInt(ScannerUtil.ler("Digite o ID que deseja detalhar: ")) - 1;

        if (index >= 0 && index < pessoas.size()) {
            Pessoa pessoa = pessoas.get(index);
            System.out.println("Detalhes da pessoa:");
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Documento: " + pessoa.getDocumento());
            System.out.println("Contatos: " );
            System.out.println(pessoa.getContatos());
            System.out.println("Projetos" + pessoa.getProjetos());
            System.out.println("Tarefas" + pessoa.getTarefasIndependentes());


        } else {
            System.out.println("Número inválido.");
        }
    }


    public Pessoa getPessoa(int index) {
        if (index >= 0 && index < pessoas.size()) {
            return pessoas.get(index);
        } else {
            System.out.println("Índice inválido.");
            return null;
        }
    }


    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void removerPessoa() {
        listarPessoas();
        int id = Integer.parseInt(ScannerUtil.ler("Digite o ID que deseja remover: ")) - 1;

        if (id >= 0 && id < pessoas.size()) {
            Pessoa pessoaRemovida = pessoas.remove(id);
            System.out.println("Pessoa " + pessoaRemovida.getNome() + " removida com sucesso.");
        } else {
            System.out.println("ID inválido. Nenhuma pessoa foi removida.");
        }
    }


    public void editarPessoa() {
        listarPessoas();
        int index = Integer.parseInt(ScannerUtil.ler("Digite o ID da pessoa que deseja editar: ")) - 1;

        if (index >= 0 && index < pessoas.size()) {
            Pessoa pessoa = pessoas.get(index);
            System.out.println("Editando a pessoa: " + pessoa.getNome());


            String novoNome = ScannerUtil.ler("Digite o novo nome (ou pressione Enter para manter o nome atual): ");
            if (!novoNome.isEmpty()) {
                pessoa.setNome(novoNome);
            }


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
