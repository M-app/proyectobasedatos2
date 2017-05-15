package nivel;

import java.util.Collection;

public interface Nivel {
    
    Collection<NivelDTO> getNiveles();
    
    NivelDTO getNivel(int idNivel);
    
    void insertarNivel(NivelDTO nivel);
    
    void actualizarNivel(NivelDTO nivel);
    
    void borrarNivel(int idNivel);
}
