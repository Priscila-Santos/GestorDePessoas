package Model.ListaDeTarefas;

enum Prioridade{
    ALTA,
    MEDIA,
    BAIXA
}

public class Tarefa extends Item {

    private int duracaoEmMinutos;
    private Prioridade prioridade;
    private Projeto projeto;

    public Tarefa(String nome){
        super(nome);
        this.prioridade = prioridade;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

}

