package universidad.gestores;

import universidad.recursos.RecursoAcademico;
import universidad.interfaces.FiltroRecurso;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase encargada de gestionar los recursos académicos dentro del sistema.
 * Proporciona funcionalidades para registrar, filtrar, ordenar y generar informes
 * sobre los recursos académicos disponibles.
 * 
 * <p>Esta clase permite realizar diversas operaciones sobre los recursos, como
 * filtrarlos según criterios específicos, ordenarlos y generar informes con su
 * información.</p>
 * 
 * @author Kevin Plucci
 */
public class GestorRecursos {
    
    // Lista que almacena los recursos académicos registrados en el sistema
    private List<RecursoAcademico> recursos = new ArrayList<>();

    /**
     * Registra un nuevo recurso académico en el sistema.
     * 
     * @param recurso El recurso académico que se desea registrar.
     */
    public void registrarRecurso(RecursoAcademico recurso) {
        recursos.add(recurso); // Agrega el recurso a la lista de recursos
    }

    /**
     * Filtra los recursos académicos según el criterio proporcionado por el filtro.
     * 
     * @param filtro El filtro que define el criterio de evaluación para los recursos.
     * @return Una lista de recursos que cumplen con el criterio del filtro.
     */
    public List<RecursoAcademico> filtrarRecursos(FiltroRecurso filtro) {
        // Filtra los recursos usando el criterio definido en el filtro
        return recursos.stream()
                .filter(filtro::evaluar)
                .collect(Collectors.toList());
    }

    /**
     * Ordena los recursos académicos según el comparador proporcionado.
     * 
     * @param comparador El comparador que define el criterio de ordenación.
     * @return Una lista de recursos ordenada según el comparador.
     */
    public List<RecursoAcademico> ordenarRecursos(Comparator<RecursoAcademico> comparador) {
        // Ordena los recursos usando el comparador proporcionado
        return recursos.stream()
                .sorted(comparador)
                .collect(Collectors.toList());
    }

    /**
     * Genera un informe con el total de recursos registrados y los detalles de cada uno.
     * Este informe se imprime en la consola.
     */
    public void generarInforme() {
        // Muestra el total de recursos registrados
        System.out.println("Total de recursos registrados: " + recursos.size());
        
        // Muestra los detalles de cada recurso
        recursos.forEach(RecursoAcademico::mostrarDetalles);
    }
}
