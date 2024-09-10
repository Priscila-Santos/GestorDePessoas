package Model.Contatos;

import Exception.TelefoneInvalidoException;

public abstract class Contato {
    private String telefone;
    private String endereco;
    private String email;

    public Contato(){
    }


    public Contato(String telefone, String endereco, String email) throws TelefoneInvalidoException {
        setTelefone(telefone);
        this.endereco = endereco;
        this.email = email;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws TelefoneInvalidoException {
        if (telefone == null || !telefone.matches("^\\d{7}-\\d{4}$")) {
            throw new TelefoneInvalidoException();
        }
        this.telefone = telefone;
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


    public abstract void imprimirContato();


    @Override
    public abstract String toString();
}
