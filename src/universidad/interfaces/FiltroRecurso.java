package universidad.interfaces;

import universidad.recursos.RecursoAcademico;

/**
 * Interfaz funcional que define un filtro para evaluar un recurso académico.
 * Este filtro permite aplicar criterios específicos sobre los recursos académicos 
 * para determinar si cumplen con determinadas condiciones.
 * 
 * <p>Esta interfaz es útil en contextos donde se necesite filtrar recursos según ciertos criterios
 * definidos por el usuario o el sistema. Al ser funcional, puede ser utilizada con expresiones lambda.</p>
 * 
 * @author Kevin Plucci
 */
@FunctionalInterface
public interface FiltroRecurso {

    /**
     * Evalúa si un recurso académico cumple con el criterio definido en el filtro.
     * 
     * @param recurso El recurso académico que se va a evaluar.
     * @return true si el recurso cumple con el criterio, false en caso contrario.
     */
    boolean evaluar(RecursoAcademico recurso);
}
