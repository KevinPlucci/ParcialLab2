package universidad.gestores;

import universidad.recursos.RecursoAcademico;
import universidad.excepciones.LimiteRecursosException;
import universidad.interfaces.FiltroRecurso;
import universidad.excepciones.RecursoNoEncontradoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase encargada de gestionar los recursos académicos dentro del sistema.
 * Proporciona funcionalidades para registrar, filtrar, ordenar y generar informes
 * sobre los recursos académicos disponibles.
 * 
 * @author Kevin Plucci
 */
public class GestorRecursos {
    
    // Lista que almacena los recursos académicos registrados en el sistema
    private List<RecursoAcademico> recursos = new ArrayList<>();
    
    // Limite máximo de recursos que se pueden registrar
    private static final int LIMITE_RECURSOS = 100;

    /**
     * Registra un nuevo recurso académico en el sistema.
     * 
     * @param recurso El recurso académico que se desea registrar.
     * @throws LimiteRecursosException Si se alcanza el límite de recursos.
     */
    public void registrarRecurso(RecursoAcademico recurso) {
        try {
            if (recursos.size() >= LIMITE_RECURSOS) {
                throw new LimiteRecursosException("Se ha alcanzado el límite de recursos permitidos.");
            }
            recursos.add(recurso);
        } catch (LimiteRecursosException e) {
            // Manejo de la excepción, por ejemplo, registrar el error en un log o mostrar un mensaje al usuario
            System.out.println(e.getMessage());
        }
    }

    /**
     * Filtra los recursos académicos según el criterio proporcionado por el filtro.
     * 
     * @param filtro El filtro que define el criterio de evaluación para los recursos.
     * @return Una lista de recursos que cumplen con el criterio del filtro.
     */
    public List<RecursoAcademico> filtrarRecursos(FiltroRecurso filtro) {
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
        return recursos.stream()
                .sorted(comparador)
                .collect(Collectors.toList());
    }

    /**
     * Genera un informe con el total de recursos registrados y los detalles de cada uno.
     */
    public void generarInforme() {
        System.out.println("Total de recursos registrados: " + recursos.size());
        recursos.forEach(RecursoAcademico::mostrarDetalles);
    }

    /**
     * Busca un recurso por su identificador.
     * 
     * @param identificador El identificador del recurso a buscar.
     * @return El recurso encontrado, o null si no se encuentra.
     */
    public RecursoAcademico buscarRecurso(String identificador) throws RecursoNoEncontradoException {
        for (RecursoAcademico recurso : recursos) {
            if (recurso.getIdentificador().equals(identificador)) {
                return recurso;
            }
        }
        throw new RecursoNoEncontradoException("El recurso con identificador " + identificador + " no existe.");
    }

}
