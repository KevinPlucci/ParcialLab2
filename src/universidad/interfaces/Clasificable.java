package universidad.interfaces;

/**
 * Interfaz que define los métodos necesarios para clasificar un objeto dentro del sistema.
 * Los objetos que implementen esta interfaz deben ser capaces de obtener y asignar categorías de clasificación.
 * 
 * <p>Esta interfaz es útil para recursos académicos o cualquier entidad que requiera ser clasificada
 * según diferentes categorías dentro del sistema de la universidad.</p>
 * 
 * @author Kevin Plucci
 */
public interface Clasificable {

    /**
     * Obtiene las categorías disponibles para la clasificación de un objeto.
     * 
     * @return Un arreglo de cadenas que contiene las categorías de clasificación.
     */
    String[] obtenerCategoriasClasificacion();

    /**
     * Asigna una categoría específica a un objeto.
     * 
     * @param categoria La categoría que se asignará al objeto.
     */
    void asignarCategoria(String categoria);
}
