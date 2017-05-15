package seccion;

import java.util.Collection;

public interface Seccion {
    Collection<SeccionDTO> getSecciones();
    
    SeccionDTO getSeccion(int idSeccion);
    
    void insertarSeccion(SeccionDTO seccion);
    
    void actualizarSeccion(SeccionDTO seccion);
    
    void borrarSeccion(int idSeccion);
}
