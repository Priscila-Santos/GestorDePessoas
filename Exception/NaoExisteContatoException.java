package Exception;

public class NaoExisteContatoException extends Exception {

    public NaoExisteContatoException() {
        super("Nao há um contato com este número. Tente novamente!");
    }

}
