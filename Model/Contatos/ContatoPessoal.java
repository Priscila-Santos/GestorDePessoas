package Model.Contatos;

import Util.ScannerUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static Controller.GerenciarContatos.contatos;

public class ContatoPessoal extends Contato {
    private static LocalDate aniversario;
    private static String instagram;
    private static List<ContatoPessoal> contatosPessoais;

    public ContatoPessoal(String nome, String telefone, String endereco, String email, LocalDate aniversario, String instagram, List<ContatoPessoal> contatosPessoais) {
        super(nome, telefone, endereco, email);
        this.aniversario = aniversario;
        this.instagram = instagram;
        this.contatosPessoais = new ArrayList<>();
    }



    @Override
    public String toString() {
        return """
                | Nome\s                 | Telefone\s          | Endereço\s         | Instagram\s | Aniversario\s |
                ---------------------------------------------------------------------------------------------------
                |   %s                   | %s                  | %s                 | %s
                ---------------------------------------------------------------------------------------------------
                """.formatted(ContatoPessoal.getNome(),
                ContatoPessoal.getTelefone(),
                ContatoPessoal.getEndereco(),
                ContatoPessoal.getInstagram());
    }

    public LocalDate getAnviersario() {
        return aniversario;
    }

    public void setAnviersario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }

    public static String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }


    @Override
    public void imprimirContato() {
        System.out.println(this.toString());
    }

    public static String adicionarContatoPessoal() {
        try {
            String nome = ScannerUtil.ler("Digite o nome do contato que deseja adicionar: ");
            String telefone = ScannerUtil.ler("Digite o telefone do contato: ");
            String endereco = ScannerUtil.ler("Digite o endereço do contato: ");
            String email = ScannerUtil.ler("Digite o email do contato: ");
            String instagram = ScannerUtil.ler("Digite o instagram do contato: ");
            ContatoPessoal contatoPessoal = new ContatoPessoal(nome, telefone, endereco, email, aniversario, instagram, contatosPessoais) {
                @Override
                public String toString() {
                    return String.format("Nome: %s\nTelefone: %s\nEndereço: %s\nEmail: %s",
                            ContatoPessoal.getNome(),
                            ContatoPessoal.getTelefone(),
                            ContatoPessoal.getEndereco(),
                            ContatoPessoal.getEmail());
                }
            };
            contatos.add(contatoPessoal);
            return "Contato adicionado com sucesso!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    
    public static String editarContatoPessoal() {
        try {

            int index = Integer.parseInt(ScannerUtil.ler ("Digite o número do contato para editar: ")) - 1;
            if(index >= 0 && index < contatos.size()){

                   ContatoPessoal contatoPessoal = (ContatoPessoal) contatos.get(index);
                   String nome = ScannerUtil.ler("Nome (" + contatoPessoal.getNome() + "): ");
                   String telefone = ScannerUtil.ler("Telefone (" + contatoPessoal.getTelefone() + "): ");
                   String endereco = ScannerUtil.ler("Endereço (" + contatoPessoal.getEndereco() + "): ");
                   String email = ScannerUtil.ler("Email (" + contatoPessoal.getEmail() + "): ");
                   String instagram = ScannerUtil.ler("Instagram (" + contatoPessoal.getInstagram() + "): ");

                   if (contatoPessoal != null) {
                       String opcoesEdicao = """
                               >>>> Editar <<<<
                               1 - Nome
                               2 - Telefone
                               3 - Endereço
                               4 - Email
                               5 - Instagram
                               """;

                       System.out.println(opcoesEdicao);
                       int opcao = Integer.parseInt(ScannerUtil.ler("Digite a opção desejada para edição: "));

                       switch (opcao) {
                           case 1:
                               String novoNome = ScannerUtil.ler("Digite o novo nome: ");
                               contatoPessoal.setNome(novoNome);
                               break;
                           case 2:
                               String novoTelefone = ScannerUtil.ler("Digite o novo telefone: ");
                               contatoPessoal.setTelefone(novoTelefone);
                               break;
                           case 3:
                               String novoEndereco = ScannerUtil.ler("Digite o novo endereço: ");
                               contatoPessoal.setEndereco(novoEndereco);
                               break;
                           case 4:
                               String novoEmail = ScannerUtil.ler("Digite o novo email: ");
                               contatoPessoal.setEmail(novoEmail);
                               break;
                           case 5:
                               String novoInstagram = ScannerUtil.ler("Digite o novo Instagram: ");
                               contatoPessoal.setInstagram(novoInstagram);
                               break;
                           default:
                               return "Opção inválida.";
                       }
                       return "Contato editado com sucesso!";
                   } else {
                       return "Contato não encontrado.";
                   }
               }
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
        return null;
    }


    
    public static String removerContatoPessoal() {
        String nome = ScannerUtil.ler("Digite o nome do contato que deseja remover: ");
        Contato contato = encontrarContatoPessoal(nome);
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

    /*public String listarContatosPessoais() {
        if (contatosPessoais.isEmpty()) {
            return "Nenhum contato cadastrado.";
        } else {
            StringBuilder lista = new StringBuilder("Lista de contatos:\n");
            for (Contato contato : contatosPessoais) {
                lista.append(contato).append("\n");
            }
            return lista.toString();
        }
    }*/

    private static ContatoPessoal encontrarContatoPessoal(String nome) {
        for (ContatoPessoal contato : contatosPessoais) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return (ContatoPessoal) contatosPessoais;
            }
        }
        return null;
    }
}
