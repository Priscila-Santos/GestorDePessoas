package Model.ListaDeTarefas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Projeto extends Item {

    private List<Tarefa> tarefas;
    private int qtdDeTarefas;
    private LocalDate dataFinal;


    public Projeto(String nome){
        super(nome);
        this.tarefas = new ArrayList<>();
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void addTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
        tarefa.setProjeto(this);
        this.setQtdDeTarefas(this.tarefas.size());
    }

    public int getQtdDeTarefas() {
        return qtdDeTarefas;
    }

    public void setQtdDeTarefas(int qtdDeTarefas) {
        this.qtdDeTarefas = qtdDeTarefas;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }
}
