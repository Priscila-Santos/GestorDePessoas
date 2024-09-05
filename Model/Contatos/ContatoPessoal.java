package Model.Contatos;

import java.time.LocalDate;

public class ContatoPessoal extends Contato {
    private LocalDate anviersario;
    private String instagram;

    public ContatoPessoal(String telefone, String endereco, String email){
        super(telefone, endereco, email);
    }

    public LocalDate getAnviersario() {
        return anviersario;
    }

    public void setAnviersario(LocalDate anviersario) {
        this.anviersario = anviersario;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}
