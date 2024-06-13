
public class ParametrosInvalidosException extends Exception {
    public ParametrosInvalidosException(String message) {
        super(message);
    }

    public ParametrosInvalidosException() {
        super("O segundo parâmetro deve ser maior que o primeiro");
    }

}
