package universidad.excepciones;

/**
 * Excepción personalizada que se lanza cuando un recurso específico no se encuentra en el sistema.
 * Esta clase extiende de la clase base {@link Exception}.
 * 
 * <p>Se utiliza para indicar que un recurso solicitado, como un aula, un curso, o un material,
 * no está disponible o no existe en el contexto de la universidad.</p>
 * 
 * @author Kevin Plucci
 */
public class RecursoNoEncontradoException extends Exception {

    /**
     * Constructor que inicializa la excepción con un mensaje descriptivo.
     * 
     * @param message El mensaje que describe el recurso no encontrado.
     */
    public RecursoNoEncontradoException(String message) {
        super(message); // Llama al constructor de la clase base Exception con el mensaje recibido.
    }
}
