package Controller;

import Model.ListaDeTarefas.Projeto;
import Model.ListaDeTarefas.Tarefa;
import Model.Pessoa;
import Util.ScannerUtil;

public class GerenciarTarefas {

    public void adicionarProjeto(Pessoa pessoa){
        String nomeProjeto = ScannerUtil.ler("Nome do projeto: ");
        Projeto novoProjeto = new Projeto(nomeProjeto);
        pessoa.adicionarProjeto(novoProjeto);
        System.out.println("Projeto adicionado!");
    }

    public void adicionarTarefa(Pessoa pessoa) {
        if (pessoa.getProjetos().isEmpty()) {
            System.out.println("A pessoa não possui projetos.");
            return;
        }
        exibirProjetos(pessoa);
        int idProjeto = ScannerUtil.lerInt("Insira o ID do projeto ao qual pretende adicionar a tarefa: ");

        if (idProjeto < 0 || idProjeto >= pessoa.getProjetos().size()) {
            System.out.println("ID inválido.");
            return;
        }

        Projeto projetoSelecionado= pessoa.getProjetos().get(idProjeto);
        String nomeTarefa = ScannerUtil.ler("Digite o nome da tarefa: ");
        Tarefa novaTarefa = new Tarefa(nomeTarefa);
        projetoSelecionado.addTarefa(novaTarefa);
        System.out.println("Tarefa adicionada ao projeto " + projetoSelecionado.getNome());

    }

    public void exibirProjetos(Pessoa pessoa) {
        if (pessoa.getProjetos().isEmpty()) {
            System.out.println("Essa pessoa não possui projetos!");
            return;
        }

        System.out.println("Projeto de " + pessoa.getNome() + ": ");
        for (int i = 0; i < pessoa.getProjetos().size(); i++) {
            Projeto projeto = pessoa.getProjetos().get(i);
            System.out.println(i + " -- " + projeto.getNome());
        }
    }

    public void exibirTarefas(Pessoa pessoa) {
        if(pessoa.getProjetos().isEmpty()) {
            System.out.println("Essa pessoa não possui projetos cadastrados");
            return;
        }

        exibirProjetos(pessoa);
        int idProjeto = ScannerUtil.lerInt("Digite o ID do projeto que deseja ver: ");

        if (idProjeto < 0 || idProjeto >= pessoa.getProjetos().size()) {
            System.out.println("ID de projeto inválido.");
            return;
        }

        Projeto projetoSelecionado = pessoa.getProjetos().get(idProjeto);
        if (projetoSelecionado.getTarefas().isEmpty()) {
            System.out.println("Esse projeto não possui tarefas associadas.");
        } else {
            System.out.println("Tarefas do projeto " + projetoSelecionado.getNome() + ":");
            for (Tarefa tarefa : projetoSelecionado.getTarefas()) {
                System.out.println("-> " + tarefa.getNome());
            }
        }

    }

    // Método para exibir tarefas que n estão associadas a projetos

    public void exibirTarefasIndependentes(Pessoa pessoa) {
        if (pessoa.getTarefas().isEmpty()) {
            System.out.println("Essa pessoa não possui tarefas independentes.");
        } else {
            System.out.println("Tarefas independentes de " + pessoa.getNome() + ": ");
            for (Tarefa tarefa : pessoa.getTarefas()) {
                System.out.println("- " + tarefa.getNome());
            }
        }
    }

    // Método para editarTarefa (Pessoa Pessoa)
}
