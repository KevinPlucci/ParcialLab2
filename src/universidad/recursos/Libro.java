package universidad.recursos;

import java.time.LocalDate;  // Importación de LocalDate
/**
 *
 * @author Usuario
 */

/**
 * Clase que representa un libro como recurso académico.
 */
public class Libro extends RecursoAcademico {
    private int numeroPaginas; // Número de páginas del libro
    private String editorial;  // Editorial del libro

    /**
     * Constructor de la clase Libro.
     * @param identificador Identificador único del libro.
     * @param titulo Título del libro.
     * @param fechaCreacion Fecha de creación del libro.
     * @param autor Autor del libro.
     * @param numeroPaginas Número de páginas del libro.
     * @param editorial Editorial del libro.
     */
    public Libro(String identificador, String titulo, LocalDate fechaCreacion, String autor, int numeroPaginas, String editorial) {
        super(identificador, titulo, fechaCreacion, autor);
        this.numeroPaginas = numeroPaginas;
        this.editorial = editorial;
    }

    /**
     * Calcula la relevancia del libro en función del número de páginas.
     * @return Relevancia como un valor numérico.
     */
    @Override
    public double calcularRelevancia() {
        return numeroPaginas * 0.1; // Relevancia proporcional al número de páginas
    }

    /**
     * Muestra los detalles específicos del libro.
     */
    @Override
    public void mostrarDetalles() {
        System.out.println("Libro: " + titulo + " de " + autor);
        System.out.println("Editorial: " + editorial + ", Páginas: " + numeroPaginas);
    }

    /**
     * Determina si el libro es digital basado en su editorial.
     * @return `true` si la editorial es "Digital", de lo contrario `false`.
     */
    public boolean esLibroDigital() {
        return editorial.equalsIgnoreCase("Digital");
    }
    
}
