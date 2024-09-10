package Controller;

import Model.ListaDeTarefas.Projeto;
import Model.ListaDeTarefas.Status;
import Model.ListaDeTarefas.Tarefa;
import Model.Pessoa;
import Util.ScannerUtil;

public class GerenciarTarefas {

    public void adicionarProjeto(Pessoa pessoa) {
        String nomeProjeto = ScannerUtil.ler("Digite o nome do projeto: ");
        Projeto novoProjeto = new Projeto(nomeProjeto);
        pessoa.adicionarProjeto(novoProjeto);
        System.out.println("Projeto adicionado com sucesso!");
    }

    public void adicionarTarefa(Pessoa pessoa) {
        boolean continuar = true;
        while (continuar) {
            try {
                System.out.println("============================================================");
                System.out.println("|                SELECIONAR PROJETO OU INDEPENDENTE         |");
                System.out.println("============================================================");

                for (int i = 0; i < pessoa.getProjetos().size(); i++) {
                    Projeto projeto = pessoa.getProjetos().get(i);
                    System.out.println((i + 1) + " - " + projeto.getNome());
                }

                System.out.println((pessoa.getProjetos().size() + 1) + " - Adicionar tarefa independente");
                System.out.println("============================================================");

                int idProjeto = Integer.parseInt(ScannerUtil.ler("Digite o número do projeto ou escolha a opção para adicionar uma tarefa independente (ou -1 para sair): ")) - 1;

                if (idProjeto == -2) {
                    continuar = false;
                    break;
                }

                if (idProjeto == pessoa.getProjetos().size()) {
                    String nomeTarefa = ScannerUtil.ler("Digite o nome da tarefa independente: ");
                    Tarefa novaTarefa = new Tarefa(nomeTarefa);
                    pessoa.adicionarTarefaIndependente(novaTarefa);
                    System.out.println("Tarefa independente adicionada com sucesso!");
                } else if (idProjeto >= 0 && idProjeto < pessoa.getProjetos().size()) {
                    Projeto projetoSelecionado = pessoa.getProjetos().get(idProjeto);
                    String nomeTarefa = ScannerUtil.ler("Digite o nome da tarefa: ");
                    Tarefa novaTarefa = new Tarefa(nomeTarefa);
                    projetoSelecionado.adicionarTarefa(novaTarefa);
                    System.out.println("Tarefa adicionada ao projeto " + projetoSelecionado.getNome());
                } else {
                    System.out.println("ID do projeto não encontrado. Tente novamente.");
                }

                String opcaoContinuar = ScannerUtil.ler("Deseja adicionar outra tarefa? (S/N): ");
                if (opcaoContinuar.equalsIgnoreCase("N")) {
                    continuar = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número válido para ID do projeto.");
            }
        }
    }

    private void exibirTabelaProjetos(Pessoa pessoa) {
        System.out.println("=> Projetos e Tarefas de " + pessoa.getNome() + ":");
        System.out.println("===============================================================");
        System.out.printf("%-5s %-15s %-25s %-15s\n", "ID", "Projeto", "Tarefa", "Status");
        System.out.println("===============================================================");

        int linha = 1;
        for (int i = 0; i < pessoa.getProjetos().size(); i++) {
            Projeto projeto = pessoa.getProjetos().get(i);
            for (int j = 0; j < projeto.getTarefas().size(); j++) {
                Tarefa tarefa = projeto.getTarefas().get(j);
                System.out.printf("%-5d %-15s %-25s %-15s\n", linha++, projeto.getNome(), tarefa.getNome(), tarefa.getStatus().getDescricao());
            }
        }

        if (linha == 1) {
            System.out.println("Nenhuma tarefa disponível.");
        }
        System.out.println("===============================================================");
    }

    private void exibirTabelaTarefasIndependentes(Pessoa pessoa) {
        System.out.println("=> Tarefas Independentes de " + pessoa.getNome() + ":");
        System.out.println("===============================================================");
        System.out.printf("%-5s %-25s %-15s\n", "ID", "Tarefa", "Status");
        System.out.println("===============================================================");

        int linha = 1;
        for (int i = 0; i < pessoa.getTarefasIndependentes().size(); i++) {
            Tarefa tarefaIndependente = pessoa.getTarefasIndependentes().get(i);
            System.out.printf("%-5d %-25s %-15s\n", linha++, tarefaIndependente.getNome(), tarefaIndependente.getStatus().getDescricao());
        }

        if (linha == 1) {
            System.out.println("Nenhuma tarefa independente.");
        }
        System.out.println("===============================================================");
    }

    public void exibirDuasTabelas(Pessoa pessoa) {
        exibirTabelaProjetos(pessoa);
        System.out.println();
        exibirTabelaTarefasIndependentes(pessoa);
    }

    public void alterarStatusTarefa(Pessoa pessoa) {
        System.out.println("Escolha o tipo de tarefa a ser alterada:");
        System.out.println("1 - Tarefa de um projeto");
        System.out.println("2 - Tarefa independente");
        System.out.println("Digite sua escolha (1 ou 2):");

        int tipoTarefa = Integer.parseInt(ScannerUtil.ler("Escolha: "));

        if (tipoTarefa == 1) {

            exibirTabelaProjetos(pessoa);
            int idTarefa = Integer.parseInt(ScannerUtil.ler("Digite o ID da tarefa que deseja alterar: ")) - 1;

            int linha = 0;
            Tarefa tarefaSelecionada = null;
            outerLoop:
            for (Projeto projeto : pessoa.getProjetos()) {
                for (Tarefa tarefa : projeto.getTarefas()) {
                    if (linha == idTarefa) {
                        tarefaSelecionada = tarefa;
                        break outerLoop;
                    }
                    linha++;
                }
            }

            if (tarefaSelecionada == null) {
                System.out.println("ID de tarefa inválido.");
                return;
            }

            atualizarStatusTarefa(tarefaSelecionada);
        } else if (tipoTarefa == 2) {

            exibirTabelaTarefasIndependentes(pessoa);
            int idTarefaIndependente = Integer.parseInt(ScannerUtil.ler("Digite o ID da tarefa independente que deseja alterar: ")) - 1;

            if (idTarefaIndependente < 0 || idTarefaIndependente >= pessoa.getTarefasIndependentes().size()) {
                System.out.println("ID de tarefa independente inválido.");
                return;
            }

            Tarefa tarefaSelecionada = pessoa.getTarefasIndependentes().get(idTarefaIndependente);

            atualizarStatusTarefa(tarefaSelecionada);
        } else {
            System.out.println("Opção inválida. Tente novamente.");
        }
    }


    private void atualizarStatusTarefa(Tarefa tarefaSelecionada) {
        System.out.println("Status atual: " + tarefaSelecionada.getStatus().getDescricao());
        System.out.println("""
                Escolha o novo status:
                1 - Não Iniciado
                2 - Em Progresso
                3 - Concluído
                4 - Fechado
                """);

        int opcaoStatus = Integer.parseInt(ScannerUtil.ler("Escolha uma opção: "));

        switch (opcaoStatus) {
            case 1 -> tarefaSelecionada.setStatus(Status.NOT_STARTED);
            case 2 -> tarefaSelecionada.setStatus(Status.IN_PROGRESS);
            case 3 -> tarefaSelecionada.setStatus(Status.DONE);
            case 4 -> tarefaSelecionada.setStatus(Status.CLOSED);
            default -> System.out.println("Opção inválida.");
        }

        System.out.println("Status da tarefa atualizado com sucesso!");
    }
}
