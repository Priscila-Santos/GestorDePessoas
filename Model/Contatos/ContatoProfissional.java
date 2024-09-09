package Model.Contatos;

import Exception.TelefoneInvalidoException;

public class ContatoProfissional extends Contato {
    private String empresa;
    private String cargo;

    public ContatoProfissional(String telefone, String endereco, String email, String empresa, String cargo) throws TelefoneInvalidoException {
        super(telefone, endereco, email);
        this.empresa = empresa;
        this.cargo = cargo;
    }

    @Override
    public void imprimirContato() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return String.format("Contato Profissional: %s, %s, %s, %s, %s", getTelefone(), getEndereco(), getEmail(), empresa, cargo);
    }


    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
