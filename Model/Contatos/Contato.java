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

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract String getTipoContato();
}
