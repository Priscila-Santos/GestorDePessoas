package Model.ListaDeTarefas;

import java.util.ArrayList;
import java.util.List;

public class Projeto {
    private String nome;
    private List<Tarefa> tarefas = new ArrayList<>();

    public Projeto(String nome) {
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public List<Tarefa> getTarefas() {
        return tarefas;
    }


    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    @Override
    public String toString() {
        return "Projeto: " + nome;
    }
}
