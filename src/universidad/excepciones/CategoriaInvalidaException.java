package universidad.excepciones;

/**
 * Excepción personalizada que indica que una categoría no es válida dentro del sistema.
 * Esta clase extiende de la clase base {@link Exception}.
 * 
 * @author Kevin Plucci
 */
public class CategoriaInvalidaException extends Exception {

    /**
     * Constructor que inicializa la excepción con un mensaje personalizado.
     * 
     * @param message El mensaje descriptivo del error relacionado con la categoría inválida.
     */
    public CategoriaInvalidaException(String message) {
        super(message); // Llama al constructor de la clase base Exception con el mensaje recibido.
    }
}
