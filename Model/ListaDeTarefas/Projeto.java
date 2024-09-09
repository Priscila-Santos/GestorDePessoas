package Model.ListaDeTarefas;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
    private String nome;
    private List<Tarefa> tarefas = new ArrayList<>();

    public Projeto(String nome) {
        this.nome = nome;
    }

    // Getter para o nome do projeto
    public String getNome() {
        return nome;
    }

    // Setter para o nome do projeto
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para obter as tarefas associadas ao projeto
    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    // Método para adicionar uma tarefa ao projeto
    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);  // Adiciona a tarefa à lista de tarefas
    }

    @Override
    public String toString() {
        return "Projeto: " + nome;
    }
}
