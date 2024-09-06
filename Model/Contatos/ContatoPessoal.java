package Model.Contatos;

import java.time.LocalDate;

public class ContatoPessoal extends Contato {
    private LocalDate aniversario;
    private String instagram;

    public ContatoPessoal(String telefone, String endereco, String email){
        super(telefone, endereco, email);
    }

    public LocalDate getAnviersario() {
        return aniversario;
    }

    public void setAnviersario(LocalDate anviersario) {
        this.aniversario = anviersario;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    @Override
    public String getTipoContato() {
        return "Pessoal";
    }
}
