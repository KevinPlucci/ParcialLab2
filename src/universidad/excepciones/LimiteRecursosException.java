package universidad.excepciones;

/**
 * Excepción personalizada que indica que se ha alcanzado el límite de recursos permitidos en el sistema.
 * Esta clase extiende de la clase base {@link Exception}.
 * 
 * @author Kevin Plucci
 */
public class LimiteRecursosException extends Exception {

    /**
     * Constructor que inicializa la excepción con un mensaje descriptivo.
     * 
     * @param message El mensaje que describe el error relacionado con el límite de recursos alcanzado.
     */
    public LimiteRecursosException(String message) {
        super(message); // Llama al constructor de la clase base Exception con el mensaje recibido.
    }
}
