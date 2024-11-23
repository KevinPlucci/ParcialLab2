package universidad.recursos;

import java.time.LocalDate;  // Importación de LocalDate
import java.util.List;
/**
 *
 * @author Kevin Plucci
 */

/**
 * Clase que representa un artículo como recurso académico.
 */
public class Articulo extends RecursoAcademico {
    private List<String> palabrasClave; // Lista de palabras clave asociadas al artículo
    private String revista; // Revista donde fue publicado el artículo

    /**
     * Constructor de la clase Articulo.
     * @param identificador Identificador único del artículo.
     * @param titulo Título del artículo.
     * @param fechaCreacion Fecha de creación del artículo.
     * @param autor Autor del artículo.
     * @param palabrasClave Lista de palabras clave.
     * @param revista Revista donde fue publicado.
     */
    public Articulo(String identificador, String titulo, LocalDate fechaCreacion, String autor, List<String> palabrasClave, String revista) {
        super(identificador, titulo, fechaCreacion, autor);
        this.palabrasClave = palabrasClave;
        this.revista = revista;
    }

    /**
     * Calcula la relevancia del artículo en función del número de palabras clave.
     * @return Relevancia como un valor numérico.
     */
    @Override
    public double calcularRelevancia() {
        return palabrasClave.size() * 5; // Relevancia proporcional al número de palabras clave
    }

    /**
     * Muestra los detalles específicos del artículo.
     */
    @Override
    public void mostrarDetalles() {
        System.out.println("Artículo: " + titulo + " publicado en " + revista);
        System.out.println("Palabras clave: " + palabrasClave);
    }

    /**
     * Cuenta cuántas palabras clave tiene el artículo.
     * @return Cantidad de palabras clave.
     */
    public int contarPalabrasClave() {
        return palabrasClave.size();
    }
}

