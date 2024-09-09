package Model.Contatos;

import exception.TelefoneInvalidoException;

public abstract class Contato {
    private String telefone;
    private String endereco;
    private String email;

    public Contato(){
    }

    // Construtor
    public Contato(String telefone, String endereco, String email) throws TelefoneInvalidoException {
        setTelefone(telefone);  // Usa o setter para validar o telefone
        this.endereco = endereco;
        this.email = email;
    }

    // Getters e Setters
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws TelefoneInvalidoException {
        if (telefone == null || !telefone.matches("\\d{4,5}-\\d{4}")) {
            throw new TelefoneInvalidoException("Telefone inválido. Por favor, insira um número no formato: 1234-5678.");
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

    // Método abstrato para exibir as informações do contato
    public abstract void imprimirContato();

    // Sobrescreva o método `toString` nas subclasses (ContatoPessoal e ContatoProfissional)
    @Override
    public abstract String toString();
}
