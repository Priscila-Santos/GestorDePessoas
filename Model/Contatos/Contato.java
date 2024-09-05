package Model.Contatos;

public abstract class Contato{
    private String telefone;
    private String endereco;
    private String email;

    public Contato(String telefone, String endereco, String email) {
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

}
