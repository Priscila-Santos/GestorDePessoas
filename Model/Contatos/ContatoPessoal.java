package Model.Contatos;

import Exception.TelefoneInvalidoException;

public class ContatoPessoal extends Contato {
    private String aniversario;
    private String instagram;

    public ContatoPessoal(String telefone, String endereco, String email, String aniversario, String instagram) throws TelefoneInvalidoException {
        super(telefone, endereco, email);
        this.aniversario = aniversario;
        this.instagram = instagram;
    }

    public ContatoPessoal(){
    }


    @Override
    public void imprimirContato() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return String.format("Contato Pessoal: %s, %s, %s, %s, %s", getTelefone(), getEndereco(), getEmail(), aniversario, instagram);
    }


    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}
