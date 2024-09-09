package Model.ListaDeTarefas;

public class Tarefa extends Item {

    public Tarefa(String nome) {
        super(nome);
    }

    public Tarefa(String nome, Status status) {
        super(nome, status);
    }
    @Override
    public String toString() {
        return getNome() + " - Status: " + getStatus().getDescricao();
    }
}
