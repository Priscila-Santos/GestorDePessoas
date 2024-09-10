package Exception;

public class ContatoNaoEncontradoException extends Exception {

    public ContatoNaoEncontradoException() {
        super("O contato não existe na agenda.");
    }

    public ContatoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
