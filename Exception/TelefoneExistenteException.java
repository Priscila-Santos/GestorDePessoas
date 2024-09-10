package Exception;

public class TelefoneExistenteException extends Exception {

    public TelefoneExistenteException() {
        super("O telefone já existe nesta agenda.");
    }

}
