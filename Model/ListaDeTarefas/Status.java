package Model.ListaDeTarefas;

public enum Status {
    NOT_STARTED("Não iniciado"),
    IN_PROGRESS("Em progresso"),
    DONE("Concluído"),
    CLOSED("Fechado");

    private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
