package Exception;

public class TelefoneInvalidoException extends Exception{
    public TelefoneInvalidoException(){
        super("Telefone inválido. Por favor adicione um número válido. Exemplo: 001234-5678");
    }
}
