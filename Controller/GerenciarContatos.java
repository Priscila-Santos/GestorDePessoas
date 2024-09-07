package Controller;

import Model.Contatos.Contato;
import Model.Contatos.ContatoProfissional;
import Model.Contatos.ContatoPessoal;
import Util.ScannerUtil;

import java.util.ArrayList;
import java.util.List;

import static Model.Contatos.ContatoPessoal.*;
import static Model.Contatos.ContatoProfissional.*;

public class GerenciarContatos {
    public static List<Contato> contatos;
    private List<ContatoPessoal> contatosPessoais = new ArrayList<>();
    private List<ContatoProfissional> contatosProfissionais = new ArrayList<>();

    public GerenciarContatos() {
        this.contatos = new ArrayList<>();
    }

   /* private static Contato encontrarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }*/

    public String listarContatosPessoais() {
        if (contatosPessoais.isEmpty()) {
            return "Nenhum contato cadastrado.";
        } else {
            StringBuilder lista = new StringBuilder("Lista de contatos:\n");
            for (Contato contato : contatosPessoais) {
                lista.append(contato).append("\n");
            }
            return lista.toString();
        }
    }

    public String listarContatosProfissionais() {
        if (contatosProfissionais.isEmpty()) {
            return "Nenhum contato cadastrado.";
        } else {
            StringBuilder lista = new StringBuilder("Lista de contatos:\n");
            for (Contato contato : contatosProfissionais) {
                lista.append(contato).append("\n");
            }
            return lista.toString();
        }
    }


    public String editarContatosPessoais(){
        return editarContatoPessoal();
    }

//    public String removerContatosPessoais(){
//        return removerContatoPessoal();
//    }

    public String adicionarContatosProfissionais() {
        return adicionarContatoProfissional();
    }

    public String editarContatosProfissionais(){
        return editarContatoProfissional();
    }



   /* public static String adicionarContato() {
        try {
            String nome = ScannerUtil.ler("Digite o nome do contato que deseja adicionar: ");
            String telefone = ScannerUtil.ler("Digite o telefone do contato: ");
            String endereco = ScannerUtil.ler("Digite o endereço do contato: ");
            String email = ScannerUtil.ler("Digite o email do contato: ");
            Contato contato = new Contato(nome, telefone, endereco, email) {
                @Override
                public String toString() {
                    return String.format("Nome: %s\nTelefone: %s\nEndereço: %s\nEmail: %s", getNome(), getTelefone(), getEndereco(), getEmail());
                }

                @Override
                public void imprimirContato() {

                }


                @Override
                public void imprimirContato() {
                    System.out.println(toString());
                }

                @Override
                public String adicionarContato(List<Contato> contatos, ScannerUtil entrada) {
                    return "";
                }

                @Override
                public String editarContato(List<Contato> contatos, ScannerUtil entrada) {
                    return "";
                }

                @Override
                public String removerContato(List<Contato> contatos, ScannerUtil entrada) {
                    return "";
                }
            };
            contatos.add(contato);
            return "Contato adicionado com sucesso!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }



    public static String editarContato(List<Contato> contatos, ScannerUtil entrada) {
        try {
            String nome = ScannerUtil.ler("Digite o nome do contato que deseja editar: ");
            Contato contato = encontrarContato(nome);
            if (contato != null) {
                String opcoesEdicao = """
                       >>>> Editar <<<<
                       1 - Nome
                       2 - Telefone
                       3 - Endereco
                       4 - Email
                       """;

                ScannerUtil.ler(opcoesEdicao);
                int opcao = Integer.parseInt(ScannerUtil.ler("Digite a opção que desejada para edição"));

                switch (opcao) {
                    case 1: String novoNome = ScannerUtil.ler("Digite o novo nome: ");
                    contato.setNome(novoNome);
                    break;
                    case 2: String novoTelefone = ScannerUtil.ler("Digite o novo telefone: ");
                    contato.setTelefone(novoTelefone);
                    break;
                    case 3: String novoEndereco = ScannerUtil.ler("Digite o novo endereco: ");
                    contato.setEndereco(novoEndereco);
                    break;
                    case 4: String novoEmail = ScannerUtil.ler("Digite o email: ");
                    contato.setEmail(novoEmail);
                    break;
                    default: return null;
                }
                return "Contato editado com sucesso!";
            } else {
                return "Contato não encontrado.";
            }
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }


    public static String removerContato() {
        String nome = ScannerUtil.ler("Digite o nome do contato que deseja remover: ");
        Contato contato = encontrarContato(nome);
        if (contato != null) {
            String confirmacao = ScannerUtil.ler("Tem certeza que deseja remover esse contato da sua agenda? S/N ");
            if (confirmacao.equalsIgnoreCase("S")) {
                contatos.remove(contato);
                return "Contato removido com sucesso!";
            } else {
                return "Operação cancelada.";
            }
        } else {
            return "Contato não encontrado.";
        }
    }

    public static String detalharContato() {
        String nome = ScannerUtil.ler("Digite o nome do contato: ");
        Contato contato = encontrarContato(nome);
        if (contato != null) {
            return "Detalhes do contato:\n" + contato;
        } else {
            return "Contato não encontrado.";
        }
    }

    public String listarContatos() {
        if (contatos.isEmpty()) {
            return "Nenhum contato cadastrado.";
        } else {
            StringBuilder lista = new StringBuilder("Lista de contatos:\n");
            for (Contato contato : contatos) {
                lista.append(contato).append("\n");
            }
            return lista.toString();
        }
    } */



}
