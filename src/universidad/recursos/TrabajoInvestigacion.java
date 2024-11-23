package universidad.recursos;

import java.time.LocalDate;  // Importación de LocalDate
import java.util.List;

/**
 * Clase que representa un trabajo de investigación dentro del sistema.
 * Extiende de la clase {@link RecursoAcademico} y agrega detalles específicos
 * sobre los autores y la línea de investigación a la que pertenece el trabajo.
 * 
 * <p>Un trabajo de investigación puede ser evaluado en términos de relevancia y 
 * puede contener información adicional sobre si tiene financiamiento asociado.</p>
 * 
 * @author Kevin Plucci
 */
public class TrabajoInvestigacion extends RecursoAcademico {
    
    // Lista de autores que contribuyen al trabajo de investigación
    private List<String> autores;
    
    // Línea de investigación a la que pertenece el trabajo
    private String lineaInvestigacion;

    /**
     * Constructor para inicializar un trabajo de investigación con su identificador,
     * título, fecha de creación, autor, autores y línea de investigación.
     * 
     * @param identificador El identificador único del trabajo.
     * @param titulo El título del trabajo de investigación.
     * @param fechaCreacion La fecha de creación del trabajo.
     * @param autor El autor principal del trabajo de investigación.
     * @param autores La lista de autores que participaron en la investigación.
     * @param lineaInvestigacion La línea de investigación a la que pertenece el trabajo.
     */
    public TrabajoInvestigacion(String identificador, String titulo, LocalDate fechaCreacion, String autor, List<String> autores, String lineaInvestigacion) {
        super(identificador, titulo, fechaCreacion, autor);
        this.autores = autores;
        this.lineaInvestigacion = lineaInvestigacion;
    }

    /**
     * Calcula la relevancia del trabajo de investigación basado en el número de autores.
     * Cada autor agrega 10 puntos de relevancia.
     * 
     * @return El puntaje de relevancia calculado.
     */
    @Override
    public double calcularRelevancia() {
        // La relevancia se calcula multiplicando el número de autores por 10
        return autores.size() * 10;
    }

    /**
     * Muestra los detalles del trabajo de investigación en la consola.
     * Imprime el título, la línea de investigación y los autores.
     */
    @Override
    public void mostrarDetalles() {
        System.out.println("Trabajo de Investigación: " + titulo + " sobre " + lineaInvestigacion);
        System.out.println("Autores: " + autores);
    }

    /**
     * Verifica si el trabajo de investigación tiene financiamiento.
     * 
     * @return true si la línea de investigación contiene la palabra "financiamiento",
     *         false en caso contrario.
     */
    public boolean tieneFinanciamiento() {
        // Comprueba si la línea de investigación contiene la palabra "financiamiento"
        return lineaInvestigacion.contains("financiamiento");
    }
}
