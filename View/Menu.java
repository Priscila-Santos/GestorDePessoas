package View;

import Controller.GerenciarContatos;
import Controller.GerenciarPessoas;
import Model.Contatos.ContatoPessoal;
import Model.Contatos.Contato;
import Model.Contatos.ContatoProfissional;
import Util.ScannerUtil;

import java.util.List;
import java.util.Scanner;

import static Controller.GerenciarContatos.*;

public class Menu {
    private GerenciarPessoas gerenciadorPessoas = new GerenciarPessoas();

    public void menuIniciar() {
        int opcao = 0;
        while (opcao != 9) {
            String listaPessoas = String.valueOf(gerenciadorPessoas.listarPessoas());
            String opcoes = """
                    
                    
                                        **************************************************
                                        ********************* AGENDA *********************
                                        **************************************************                                   
                    
                                        >>>>>>>>>>>>>>>> Pessoas Cadastradas <<<<<<<<<<<<<<<
                                        %s                                    
                                     
                                        >>>>>>>>>>>>>>>>>>>> Menu <<<<<<<<<<<<<<<<<<<
                                        1 - Adicionar Pessoa
                                        2 - Detalhar Pessoa 
                                        3 - Editar Pessoa
                                        4 - Remover Pessoa
                                        5 - Sair
                    
                                        """.formatted(listaPessoas);

            System.out.print(opcoes);
            opcao = Integer.parseInt(ScannerUtil.ler("Digite a opção:"));


            switch (opcao) {
                case 1 -> gerenciadorPessoas.adicionarPessoa();
                case 2 -> gerenciadorPessoas.detalharPessoa();
//                case 3 -> gerenciador.editarContatosPessoais();
//                case 4 -> gerenciador.editarContatosProfissionais();
//                case 5 -> gerenciador.removerContatosPessoais();
//                case 6 -> gerenciador.removerContatosProfissionais();
//                case 7 -> verContato();
//                case 8 -> verAgendaCompleta();
//                case 9 -> System.out.println("Saindo...");
//                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
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

