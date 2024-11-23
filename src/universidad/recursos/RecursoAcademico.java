package universidad.recursos;

/**
 *
 * @author Kevin Plucci
 */

import java.time.LocalDate;

/**
 * Clase abstracta que representa un recurso académico genérico.
 */
public abstract class RecursoAcademico {
    protected String identificador;
    protected String titulo;
    protected LocalDate fechaCreacion;
    protected String autor;

    // Constructor
    public RecursoAcademico(String identificador, String titulo, LocalDate fechaCreacion, String autor) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.autor = autor;
    }

    // Getter para el título
    public String getTitulo() {
        return titulo;
    }

    // Métodos abstractos
    public abstract double calcularRelevancia();
    public abstract void mostrarDetalles();
}


