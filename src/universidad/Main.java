package universidad;

import universidad.recursos.Articulo;
import universidad.recursos.Libro;
import universidad.recursos.TrabajoInvestigacion;
import universidad.gestores.GestorRecursos;

import universidad.excepciones.CategoriaInvalidaException;  // Importamos la excepción
import universidad.recursos.RecursoAcademico;
import universidad.excepciones.RecursoNoEncontradoException;  // Importamos la excepción


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Crear instancia del gestor de recursos
        GestorRecursos gestorRecursos = new GestorRecursos();

        // Crear algunos recursos académicos
        Articulo articulo = new Articulo("A001", "Investigación sobre Java", LocalDate.of(2024, 11, 25), "Kevin Plucci", Arrays.asList("Java", "Programación", "Tecnología"), "Revista de Software");
        Libro libro = new Libro("L001", "Introducción a la Ciencia", LocalDate.of(2020, 5, 1), "Juan Pérez", 350, "Editorial Académica");
        TrabajoInvestigacion trabajoInvestigacion = new TrabajoInvestigacion("T001", "Avances en IA", LocalDate.of(2023, 3, 12), "Ana López", Arrays.asList("Ana López", "Carlos Gómez"), "Inteligencia Artificial con financiamiento");

        // Asignar categorías a los recursos y manejar la excepción
        try {
            articulo.asignarCategoria("Tecnología");
            libro.asignarCategoria("Ciencia");
            trabajoInvestigacion.asignarCategoria("Matemáticas");  // Esto podría lanzar una excepción
        } catch (CategoriaInvalidaException e) {
            System.out.println("Error al asignar categoría: " + e.getMessage());
        }

        // Registrar los recursos en el gestor
        gestorRecursos.registrarRecurso(articulo);
        gestorRecursos.registrarRecurso(libro);
        gestorRecursos.registrarRecurso(trabajoInvestigacion);

        // Generar un informe de los recursos
        gestorRecursos.generarInforme();

        // Buscar un recurso por identificador y manejar la excepción
        String identificadorBuscado = "L001";
        try {
            RecursoAcademico recursoBuscado = gestorRecursos.buscarRecurso(identificadorBuscado);
            System.out.println("\nRecurso encontrado con identificador " + identificadorBuscado + ":");
            recursoBuscado.mostrarDetalles();
        } catch (RecursoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Filtrar los recursos con un filtro ejemplo
        List<RecursoAcademico> recursosFiltrados = gestorRecursos.filtrarRecursos(recurso -> recurso.calcularRelevancia() > 50);
        System.out.println("\nRecursos filtrados por relevancia mayor a 50:");
        recursosFiltrados.forEach(RecursoAcademico::mostrarDetalles);

        // Ordenar los recursos por relevancia
        List<RecursoAcademico> recursosOrdenados = gestorRecursos.ordenarRecursos((r1, r2) -> Double.compare(r2.calcularRelevancia(), r1.calcularRelevancia()));
        System.out.println("\nRecursos ordenados por relevancia:");
        recursosOrdenados.forEach(RecursoAcademico::mostrarDetalles);
    }

}
