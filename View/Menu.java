package View;

import Controller.GerenciarContatos;
import Controller.GerenciarPessoas;
import Controller.GerenciarTarefas;
import Model.Pessoa;
import Util.ScannerUtil;
import exception.ContatoNaoEncontradoException;
import exception.ProjetoNaoEncontrado;
import exception.TelefoneInvalidoException;

public class Menu {
    private GerenciarPessoas gerenciadorPessoas = new GerenciarPessoas();
    private GerenciarContatos gerenciadorContatos = new GerenciarContatos();
    private GerenciarTarefas gerenciadorTarefas = new GerenciarTarefas();

    public void menuIniciar() throws ProjetoNaoEncontrado {
        boolean continuar = true;

        while (continuar) {
            System.out.println("""
                    ============================================================
                    |                      MENU PRINCIPAL                      |
                    ============================================================
                    | 1 - Gerenciar Pessoas                                      |
                    | 2 - Gerenciar Projetos e Tarefas                           |
                    | 3 - Gerenciar Contatos                                     |
                    | 4 - Sair                                                  |
                    ============================================================
                    """);

            int opcao = -1;
            try {
                opcao = Integer.parseInt(ScannerUtil.ler("Escolha uma opção: "));
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                continue; // Volta ao início do loop para exibir o menu novamente
            }

            switch (opcao) {
                case 1 -> {
                    gerenciarPessoas();
                    if (!voltarAoMenu()) continuar = false;
                }
                case 2 -> {
                    gerenciarProjetosETarefas();
                    if (!voltarAoMenu()) continuar = false;
                }
                case 3 -> {
                    try {
                        gerenciarContatos();
                    } catch (TelefoneInvalidoException e) {
                        System.out.println(e.getMessage());
                    } catch (ContatoNaoEncontradoException e) {
                        throw new RuntimeException(e);
                    }
                    if (!voltarAoMenu()) continuar = false;
                }
                case 4 -> {
                    System.out.println("Saindo...");
                    continuar = false;
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private boolean voltarAoMenu() {
        while (true) {
            String opcao = ScannerUtil.ler("Deseja voltar ao menu principal? (S/N): ");
            if (opcao.equalsIgnoreCase("S")) {
                return true;
            } else if (opcao.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Opção inválida. Digite 'S' para Sim ou 'N' para Não.");
            }
        }
    }

    private void gerenciarProjetosETarefas() throws ProjetoNaoEncontrado {
        boolean continuar = true;
        while (continuar) {
            int indexPessoa = selecionarPessoa();
            if (indexPessoa == -1) return;

            Pessoa pessoa = gerenciadorPessoas.getPessoa(indexPessoa);

            System.out.println("""
                ============================================================
                |                GERENCIAR PROJETOS E TAREFAS               |
                ============================================================
                | 1 - Adicionar Projeto                                      |
                | 2 - Adicionar Tarefa                                       |
                | 3 - Exibir Projetos e Tarefas                              |
                | 4 - Alterar Status de Tarefa                               |
                | 5 - Voltar                                                 |
                ============================================================
                """);
            int opcao = Integer.parseInt(ScannerUtil.ler("Escolha uma opção: "));

            switch (opcao) {
                case 1 -> gerenciadorTarefas.adicionarProjeto(pessoa);
                case 2 -> gerenciadorTarefas.adicionarTarefa(pessoa);
                case 3 -> gerenciadorTarefas.exibirDuasTabelas(pessoa);  // Exibe projetos e tarefas juntos
                case 4 -> gerenciadorTarefas.alterarStatusTarefa(pessoa);
                case 5 -> continuar = false;
                default -> System.out.println("Opção inválida.");
            }

            if (continuar) {
                String opcaoContinuar = ScannerUtil.ler("Deseja continuar gerenciando projetos e tarefas? (S/N): ");
                if (opcaoContinuar.equalsIgnoreCase("N")) {
                    continuar = false;
                }
            }
        }
    }


    private void gerenciarContatos() throws TelefoneInvalidoException, ContatoNaoEncontradoException {
        boolean continuar = true;
        while (continuar) {
            int indexPessoa = selecionarPessoa();
            if (indexPessoa == -1) return;

            Pessoa pessoa = gerenciadorPessoas.getPessoa(indexPessoa);

            System.out.println("""
                    ============================================================
                    |                  GERENCIAR CONTATOS                      |
                    ============================================================
                    | 1 - Adicionar Contato Pessoal                              |
                    | 2 - Adicionar Contato Profissional                         |
                    | 3 - Exibir Contatos                                        |
                    | 4 - Editar Contatos                                        |
                    | 5 - Remover Contato                                        |
                    | 6 - Voltar                                                 |
                    ============================================================
                    """);
            int opcao = -1;
            try {
                opcao = Integer.parseInt(ScannerUtil.ler("Escolha uma opção: "));
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                continue;
            }

            switch (opcao) {
                case 1 -> gerenciadorContatos.adicionarContatosPessoais(pessoa);
                case 2 -> gerenciadorContatos.adicionarContatosProfissionais(pessoa);
                case 3 -> gerenciadorContatos.exibirContatos(pessoa);
                case 4 -> gerenciadorContatos.editarContato(pessoa);
                case 5 -> gerenciadorContatos.removerContato(pessoa);
                case 6 -> continuar = false;
                default -> System.out.println("Opção inválida.");
            }

            if (continuar) {
                String opcaoContinuar = ScannerUtil.ler("Deseja continuar gerenciando contatos? (S/N): ");
                if (opcaoContinuar.equalsIgnoreCase("N")) {
                    continuar = false;
                }
            }
        }
    }

    private void gerenciarPessoas() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("""
                    ============================================================
                    |                   GERENCIAR PESSOAS                      |
                    ============================================================
                    | 1 - Adicionar Pessoa                                       |
                    | 2 - Detalhar Pessoa                                        |
                    | 3 - Editar Pessoa                                          |
                    | 4 - Remover Pessoa                                         |
                    | 5 - Voltar                                                 |
                    ============================================================
                    """);
            int opcao = -1;
            try {
                opcao = Integer.parseInt(ScannerUtil.ler("Escolha uma opção: "));
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                continue;
            }

            switch (opcao) {
                case 1 -> gerenciadorPessoas.adicionarPessoa();
                case 2 -> gerenciadorPessoas.detalharPessoa();
                case 3 -> gerenciadorPessoas.editarPessoa();
                case 4 -> gerenciadorPessoas.removerPessoa();
                case 5 -> continuar = false;
                default -> System.out.println("Opção inválida.");
            }

            if (continuar) {
                String opcaoContinuar = ScannerUtil.ler("Deseja continuar gerenciando pessoas? (S/N): ");
                if (opcaoContinuar.equalsIgnoreCase("N")) {
                    continuar = false;
                }
            }
        }
    }

    private int selecionarPessoa() {
        gerenciadorPessoas.listarPessoas();
        int index = -1;
        try {
            index = Integer.parseInt(ScannerUtil.ler("Digite o número da pessoa: ")) - 1;
            if (index < 0 || index >= gerenciadorPessoas.getPessoas().size()) {
                System.out.println("Número inválido.");
                return -1;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, insira um número.");
        }
        return index;
    }
}
