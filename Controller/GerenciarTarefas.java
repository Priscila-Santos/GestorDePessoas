package Controller;

import Model.ListaDeTarefas.Projeto;
import Model.ListaDeTarefas.Status;
import Model.ListaDeTarefas.Tarefa;
import Model.Pessoa;
import Util.ScannerUtil;
import exception.ProjetoNaoEncontrado;

public class GerenciarTarefas {

    // Método para adicionar projeto
    public void adicionarProjeto(Pessoa pessoa) {
        String nomeProjeto = ScannerUtil.ler("Digite o nome do projeto: ");
        Projeto novoProjeto = new Projeto(nomeProjeto);
        pessoa.adicionarProjeto(novoProjeto);  // Adiciona o projeto à lista da pessoa
        System.out.println("Projeto adicionado com sucesso!");
    }

    public void adicionarTarefa(Pessoa pessoa) throws ProjetoNaoEncontrado {
        boolean continuar = true;
        while (continuar) {
            try {
                // Exibir lista de projetos
                System.out.println("============================================================");
                System.out.println("|                SELECIONAR PROJETO OU INDEPENDENTE         |");
                System.out.println("============================================================");

                // Exibir os projetos da pessoa
                for (int i = 0; i < pessoa.getProjetos().size(); i++) {
                    Projeto projeto = pessoa.getProjetos().get(i);
                    System.out.println((i + 1) + " - " + projeto.getNome());  // Exibe os projetos com base no índice
                }

                // Exibir opção de adicionar tarefa independente
                System.out.println((pessoa.getProjetos().size() + 1) + " - Adicionar tarefa independente");
                System.out.println("============================================================");

                // Capturar escolha do usuário
                int idProjeto = Integer.parseInt(ScannerUtil.ler("Digite o número do projeto ou escolha a opção para adicionar uma tarefa independente (ou -1 para sair): ")) - 1;

                // Se o usuário escolher sair
                if (idProjeto == -2) {
                    continuar = false;
                    break;
                }

                // Adicionar tarefa independente
                if (idProjeto == pessoa.getProjetos().size()) {
                    String nomeTarefa = ScannerUtil.ler("Digite o nome da tarefa independente: ");
                    Tarefa novaTarefa = new Tarefa(nomeTarefa);
                    pessoa.adicionarTarefaIndependente(novaTarefa);  // Adiciona tarefa independente
                    System.out.println("Tarefa independente adicionada com sucesso!");
                    continuar = false;
                    break;
                }

                // Verificar se o ID do projeto é válido
                if (idProjeto < 0 || idProjeto >= pessoa.getProjetos().size()) {
                    System.out.println("ID do projeto não encontrado. Tente novamente.");
                    continue;
                }

                // Adicionar a tarefa ao projeto selecionado
                Projeto projetoSelecionado = pessoa.getProjetos().get(idProjeto);
                String nomeTarefa = ScannerUtil.ler("Digite o nome da tarefa: ");
                Tarefa novaTarefa = new Tarefa(nomeTarefa);
                projetoSelecionado.adicionarTarefa(novaTarefa);
                System.out.println("Tarefa adicionada ao projeto " + projetoSelecionado.getNome());

                // Perguntar se o usuário deseja continuar
                String opcaoContinuar = ScannerUtil.ler("Deseja adicionar outra tarefa? (S/N): ");
                if (opcaoContinuar.equalsIgnoreCase("N")) {
                    continuar = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número válido para ID do projeto.");
            }
        }
    }


    // Método para exibir duas tabelas: uma para projetos e suas tarefas, outra para tarefas independentes
    public void exibirDuasTabelas(Pessoa pessoa) {
        // Tabela 1: Projetos e suas Tarefas
        System.out.println("===============================================================");
        System.out.println("Projetos e Tarefas de " + pessoa.getNome() + ":");
        System.out.println("===============================================================");
        System.out.printf("%-15s %-25s %-15s\n", "Projeto", "Tarefa", "Status");
        System.out.println("===============================================================");

        // Exibir projetos e suas respectivas tarefas
        for (Projeto projeto : pessoa.getProjetos()) {
            if (projeto.getTarefas().isEmpty()) {
                System.out.printf("%-15s %-25s %-15s\n", projeto.getNome(), "Nenhuma tarefa", "N/A");
            } else {
                for (Tarefa tarefa : projeto.getTarefas()) {
                    System.out.printf("%-15s %-25s %-15s\n", projeto.getNome(), tarefa.getNome(), tarefa.getStatus().getDescricao());
                }
            }
        }

        // Separador entre as tabelas
        System.out.println("===============================================================");
        System.out.println();

        // Tabela 2: Tarefas Independentes
        System.out.println("===============================================================");
        System.out.println("Tarefas Independentes de " + pessoa.getNome() + ":");
        System.out.println("===============================================================");
        System.out.printf("%-25s %-15s\n", "Tarefa", "Status");
        System.out.println("===============================================================");

        // Exibir tarefas independentes
        if (!pessoa.getTarefasIndependentes().isEmpty()) {
            for (Tarefa tarefaIndependente : pessoa.getTarefasIndependentes()) {
                System.out.printf("%-25s %-15s\n", tarefaIndependente.getNome(), tarefaIndependente.getStatus().getDescricao());
            }
        } else {
            System.out.println("Nenhuma tarefa independente.");
        }

        // Final da tabela
        System.out.println("===============================================================");
    }

    // Método para alterar o status de uma tarefa
    public void alterarStatusTarefa(Pessoa pessoa) {
        exibirDuasTabelas(pessoa);
        int idProjeto = Integer.parseInt(ScannerUtil.ler("Digite o número do projeto ao qual pertence a tarefa (ou -1 para tarefas independentes): "));

        Tarefa tarefaSelecionada;
        if (idProjeto == -1) {
            // Tarefa independente
            int idTarefa = Integer.parseInt(ScannerUtil.ler("Digite o número da tarefa independente: "));
            if (idTarefa < 0 || idTarefa >= pessoa.getTarefasIndependentes().size()) {
                System.out.println("ID de tarefa inválido.");
                return;
            }
            tarefaSelecionada = pessoa.getTarefasIndependentes().get(idTarefa);
        } else {
            // Tarefa vinculada a um projeto
            if (idProjeto < 0 || idProjeto >= pessoa.getProjetos().size()) {
                System.out.println("ID de projeto inválido.");
                return;
            }

            Projeto projetoSelecionado = pessoa.getProjetos().get(idProjeto);
            int idTarefa = Integer.parseInt(ScannerUtil.ler("Digite o número da tarefa no projeto: "));

            if (idTarefa < 0 || idTarefa >= projetoSelecionado.getTarefas().size()) {
                System.out.println("ID de tarefa inválido.");
                return;
            }

            tarefaSelecionada = projetoSelecionado.getTarefas().get(idTarefa);
        }

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
