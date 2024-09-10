package Model.ListaDeTarefas;

public abstract class Item {
    private Status status;
    private String nome;
    private String descricao;

    public Item(String nome) {
        this(nome, Status.NOT_STARTED);
    }

    public Item(String nome, Status status) {
        this.nome = nome;
        this.status = status;
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
