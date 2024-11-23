package universidad;

/**
 *
 * @author Usuario
 */

import universidad.gestores.GestorRecursos;
import universidad.recursos.*;
import universidad.excepciones.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear el gestor de recursos
        GestorRecursos gestor = new GestorRecursos();

        // Registrar diferentes recursos académicos
        gestor.registrarRecurso(new Libro("L1", "Java Básico", LocalDate.now(), "Autor1", 300, "Editorial ABC"));
        gestor.registrarRecurso(new Articulo("A1", "Lambda en Java", LocalDate.now(), "Autor2", Arrays.asList("Java", "Lambda", "POO"), "Revista Dev"));
        gestor.registrarRecurso(new TrabajoInvestigacion("T1", "IA en la Educación", LocalDate.now(), "Autor3", Arrays.asList("Autor3", "Autor4"), "Inteligencia Artificial"));

        // Generar informe inicial
        System.out.println("Informe Inicial:");
        gestor.generarInforme();

        // Filtrar recursos que tienen la palabra clave "Java"
        System.out.println("\nRecursos que contienen 'Java':");
        List<RecursoAcademico> filtrados = gestor.filtrarRecursos(recurso -> {
            if (recurso instanceof Articulo) {
                return ((Articulo) recurso).contarPalabrasClave() > 0 && ((Articulo) recurso).contarPalabrasClave() == 3;
            }
            return false;
        });
        filtrados.forEach(RecursoAcademico::mostrarDetalles);

        // Evaluar relevancia de todos los recursos
        System.out.println("\nRelevancia de los recursos:");
        gestor.generarInforme();

        // Ordenar los recursos por título
        System.out.println("\nRecursos ordenados por título:");
        List<RecursoAcademico> ordenados = gestor.ordenarRecursos(
            (r1, r2) -> r1.getTitulo().compareTo(r2.getTitulo())
        );
        ordenados.forEach(RecursoAcademico::mostrarDetalles);

        // Manejo de excepción personalizada
        try {
            throw new RecursoNoEncontradoException("Recurso no encontrado en la base de datos.");
        } catch (RecursoNoEncontradoException e) {
            System.out.println("\nExcepción capturada: " + e.getMessage());
        }
    }
}


