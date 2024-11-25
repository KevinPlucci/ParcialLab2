package universidad.recursos;

import universidad.excepciones.CategoriaInvalidaException; // Importación correcta de la excepción
import java.time.LocalDate;

/**
 * Clase abstracta que representa un recurso académico genérico.
 */
public abstract class RecursoAcademico {
    protected String identificador;
    protected String titulo;
    protected LocalDate fechaCreacion;
    protected String autor;
    protected String categoria;

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

    // Método para asignar categoría con validación
    public void asignarCategoria(String categoria) throws CategoriaInvalidaException {
        // Lista de categorías válidas
        String[] categoriasValidas = {"Ciencia", "Tecnología", "Matemáticas"};
        boolean categoriaValida = false;
        
        for (String categoriaValidaStr : categoriasValidas) {
            if (categoriaValidaStr.equalsIgnoreCase(categoria)) {
                categoriaValida = true;
                break;
            }
        }
        
        if (!categoriaValida) {
            throw new CategoriaInvalidaException("La categoría '" + categoria + "' no es válida.");
        }
        
        this.categoria = categoria; // Asigna la categoría si es válida
    }
}
