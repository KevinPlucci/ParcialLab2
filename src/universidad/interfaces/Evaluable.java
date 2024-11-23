package universidad.interfaces;

import universidad.recursos.RecursoAcademico;

/**
 * Interfaz que define los métodos necesarios para evaluar un objeto dentro del sistema.
 * Los objetos que implementen esta interfaz deben ser capaces de obtener un puntaje de evaluación
 * y permitir la realización de una evaluación a través de un evaluador.
 * 
 * <p>Esta interfaz es útil para los recursos académicos u otras entidades que necesiten ser evaluadas
 * con base en ciertos criterios y obtener un puntaje que refleje dicha evaluación.</p>
 * 
 * @author Kevin Plucci
 */
public interface Evaluable {

    /**
     * Obtiene el puntaje de evaluación de un objeto.
     * 
     * @return El puntaje de evaluación, un valor numérico que refleja el desempeño del objeto evaluado.
     */
    double obtenerPuntaje();

    /**
     * Permite realizar una evaluación de un recurso académico utilizando un evaluador.
     * 
     * @param evaluador El evaluador que llevará a cabo la evaluación del recurso.
     */
    void realizarEvaluacion(Evaluador evaluador);

    /**
     * Interfaz que define el comportamiento de un evaluador de recursos académicos.
     * Los evaluadores deben implementar este método para evaluar un recurso académico específico.
     */
    interface Evaluador {

        /**
         * Evalúa un recurso académico y devuelve un puntaje basado en la evaluación.
         * 
         * @param recurso El recurso académico que se va a evaluar.
         * @return El puntaje obtenido tras evaluar el recurso.
         */
        double evaluarRecurso(RecursoAcademico recurso);
    }
}
