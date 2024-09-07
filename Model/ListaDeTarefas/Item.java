package Model.ListaDeTarefas;

enum Status {
    NOT_STARTED,
    IN_PROGRESS,
    DONE,
    CLOSED
}

public abstract class Item {
    private Status status;
    private String nome;
    private String descricao;

    public Item(String nome) {
        this.status = Status.NOT_STARTED;
        this.nome = nome;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
