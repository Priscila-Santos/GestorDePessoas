package Model.Contatos;

import Util.ScannerUtil;

import java.util.ArrayList;
import java.util.List;

import static Controller.GerenciarContatos.contatos;

public class ContatoProfissional extends Contato {
    private static String empresa;
    private static String cargo;
    private String site;
    private static List<ContatoProfissional> contatosProfissionais;

    public ContatoProfissional(String telefone, String endereco, String email, String empresa, String cargo,List<ContatoProfissional> contatosProfissionais) {
        super(telefone, endereco, email);
        this.empresa = empresa;
        this.cargo = cargo;
        this.contatosProfissionais = new ArrayList<>();
    }

    @Override
    public String toString() {
        return """
                | Nome\s                 | Telefone\s         | Empresa\s         | Cargo\s
                --------------------------------------------------------------------------------------
                |   %s                   | %s                 | %s                 |  %s
                --------------------------------------------------------------------------------------
                """.formatted(
                ContatoProfissional.getTelefone(),
                ContatoProfissional.getEmpresa(),
                ContatoProfissional.getCargo());
    }

    public void imprimirContato(){
        System.out.println(this.toString());
    }


    public static String adicionarContatoProfissional() {
        try {
            String telefone = ScannerUtil.ler("Digite o telefone do contato: ");
            String endereco = ScannerUtil.ler("Digite o endereço do contato: ");
            String email = ScannerUtil.ler("Digite o email do contato: ");
            String empresa = ScannerUtil.ler("Digite a empresa do contato: ");
            String cargo = ScannerUtil.ler("Digite o cargo do contato: ");

            ContatoProfissional contatoProfissional = new ContatoProfissional(telefone, endereco, email, empresa, cargo, contatosProfissionais) {
                @Override
                public String toString() {
                    return String.format("Nome: %s\nTelefone: %s\nEndereço: %s\nEmail: %s\nEmpresa: %s\nCargo %s",
                            ContatoProfissional.getTelefone(),
                            ContatoProfissional.getEndereco(),
                            ContatoProfissional.getEmail(),
                            ContatoProfissional.getEmpresa(),
                            ContatoProfissional.getCargo());
                }
            };
            contatos.add(contatoProfissional);
            return "Contato adicionado com sucesso!";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public static String editarContatoProfissional() {
        try {

            int index = Integer.parseInt(ScannerUtil.ler ("Digite o número do contato para editar: ")) - 1;
            if(index >= 0 && index < contatos.size()){

                ContatoProfissional contatoProfissional = (ContatoProfissional) contatos.get(index);
                String telefone = ScannerUtil.ler("Telefone (" + contatoProfissional.getTelefone() + "): ");
                String endereco = ScannerUtil.ler("Endereço (" + contatoProfissional.getEndereco() + "): ");
                String email = ScannerUtil.ler("Email (" + contatoProfissional.getEmail() + "): ");
                String empresa = ScannerUtil.ler("Instagram (" + contatoProfissional.getEmpresa() + "): ");

                if (contatoProfissional != null) {
                    String opcoesEdicao = """
                               >>>> Editar <<<<
                               1 - Telefone
                               2 - Endereço
                               3 - Email
                               4 - Empresa
                               5 - Cargo
                               """;

                    System.out.println(opcoesEdicao);
                    int opcao = Integer.parseInt(ScannerUtil.ler("Digite a opção desejada para edição: "));

                    switch (opcao) {
                        case 1:
                            String novoTelefone = ScannerUtil.ler("Digite o novo telefone: ");
                            contatoProfissional.setTelefone(novoTelefone);
                            break;
                        case 2:
                            String novoEndereco = ScannerUtil.ler("Digite o novo endereço: ");
                            contatoProfissional.setEndereco(novoEndereco);
                            break;
                        case 3:
                            String novoEmail = ScannerUtil.ler("Digite o novo email: ");
                            contatoProfissional.setEmail(novoEmail);
                            break;
                        case 4:
                            String novaEmpresa = ScannerUtil.ler("Digite a nova Empresa: ");
                            contatoProfissional.setEmpresa(novaEmpresa);
                            break;
                        case 5:
                            String novaCargo = ScannerUtil.ler("Digite o novo cargo: ");
                            contatoProfissional.setEmpresa(novaCargo);
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


//    public static String removerContatoProfissional() {
//        String nome = ScannerUtil.ler("Digite o nome do contato que deseja remover: ");
//        Contato contato = encontrarContatoProfissional(nome);
//        if (contato != null) {
//            String confirmacao = ScannerUtil.ler("Tem certeza que deseja remover esse contato da sua agenda? S/N ");
//            if (confirmacao.equalsIgnoreCase("S")) {
//                contatos.remove(contato);
//                return "Contato removido com sucesso!";
//            } else {
//                return "Operação cancelada.";
//            }
//        } else {
//            return "Contato não encontrado.";
//        }
//
//    }



    /*public String listarContatosProfissionais() {
        if (contatosProfissionais.isEmpty()) {
            return "Nenhum contato cadastrado.";
        } else {
            StringBuilder lista = new StringBuilder("Lista de contatos:\n");
            for (Contato contato : contatosProfissionais) {
                lista.append(contato).append("\n");
            }
            return lista.toString();
        }
    }*/

    public static String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        if (empresa == null || empresa.isEmpty()) {
            throw new IllegalArgumentException("Empresa não pode ser nula ou vazia.");
        }
        this.empresa = empresa;
    }

        public String getTipoContato() {
        String tipoContato = "Profissional";
        return tipoContato;
    }

    public static String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (cargo == null || cargo.isEmpty()) {
            throw new IllegalArgumentException("Cargo não pode ser nulo ou vazio.");
        }
        this.cargo = cargo;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        if (site == null || site.isEmpty()) {
            throw new IllegalArgumentException("Site não pode ser nulo ou vazio.");
        }
        this.site = site;
    }
}
