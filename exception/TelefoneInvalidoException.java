package exception;

public class TelefoneInvalidoException extends Exception{
    public TelefoneInvalidoException(String s){
        super("Telefone inválido. Por favor adicione um número válido. Exemplo: 1234-5678");
    }
}
