package Model.Contatos;

public class ContatoProfissional extends Contato {
    String empresa;
    String cargo;
    String site;

    public ContatoProfissional(String nome, String telefone, String email){
        super(nome, telefone, email);
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

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
