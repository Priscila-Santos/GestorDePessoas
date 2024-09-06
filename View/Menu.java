package View;

import Controller.GerenciarContatos;
import Model.Contatos.ContatoPessoal;
import Model.Contatos.Contato;
import Model.Contatos.ContatoProfissional;
import Util.ScannerUtil;

import java.util.List;
import java.util.Scanner;

import static Controller.GerenciarContatos.*;

public class Menu {
    private String entrada;
    private List<Contato> contatos;
    private int totalContatos;
    private GerenciarContatos gerenciador = new GerenciarContatos();

    public Menu(ScannerUtil entrada, List<Contato> contatos, int totalContatos) {
        this.entrada = ScannerUtil.ler("Digite a opção desejada");
        this.contatos = contatos;
        this.totalContatos = totalContatos;
    }

    public void menuIniciar() {
        int opcao = 0;
        while (opcao != 9) {
            String lista = listarContatos();
            String listaPessoais = gerenciador.listarContatosPessoais();
            String listaProfissionais = gerenciador.listarContatosProfissionais();
            String opcoes = """
                    
                    
                                        **************************************************
                                        ********************* AGENDA *********************
                                        **************************************************                                   
                    
                                        >>>>>>>>>>>>>>>> Contatos Pessoais <<<<<<<<<<<<<<<
                                        %s
                                        
                                         >>>>>>>>>>>> Contatos Profissionais <<<<<<<<<<<<<
                                        %s
                                       \s
                                        >>>>>>>>>>>>>>>>>>>> Menu <<<<<<<<<<<<<<<<<<<
                                        1 - Adicionar Contato
                                        2 - Ver Contato
                                        3 - Editar Contato
                                        4 - Remover Contato
                                        5 - Ver Agenda Completa
                                        6 - Sair
                    
                                        """.formatted(listaPessoais, listaProfissionais);


            ScannerUtil.ler(opcoes);
            opcao = Integer.parseInt(ScannerUtil.ler("Digite a opção:"));

            switch (opcao) {
                case 1 -> gerenciador.adicionarContatosPessoais();
                case 2 -> gerenciador.adicionarContatosProfissionais();
                case 3 -> gerenciador.editarContatosPessoais();
                case 4 -> gerenciador.editarContatosProfissionais();
                case 5 -> gerenciador.removerContatosPessoais();
                case 6 -> gerenciador.removerContatosProfissionais();
                case 7 -> verContato();
                case 8 -> verAgendaCompleta();
                case 9 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }



    private String listarContatos() {
        StringBuilder lista = new StringBuilder();
        for (int i = 0; i < contatos.size(); i++) {
            lista.append(i + 1).append("- ").append(contatos.get(i).getNome()).append("\n");
        }
        return lista.toString();
    }

    private void verContato() {
        int index = Integer.parseInt(ScannerUtil.ler( "Digite o número do contato para ver: ")) - 1;
        if (index >= 0 && index < contatos.size()) {
            contatos.get(index).imprimirContato();
        } else {
            System.out.println("Contato não encontrado!");
        }
    }

    private void verAgendaCompleta() {
        System.out.println("Agenda Completa:");
        for (Contato contato : contatos) {
            contato.imprimirContato();
        }
    }

}

