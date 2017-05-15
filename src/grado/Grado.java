package grado;

import java.util.Collection;

public interface Grado {
    Collection<GradoDTO> getGrados();
    
    GradoDTO getGrado(int idGrado);
    
    void insertarGrado(GradoDTO grado);
    
    void actualizarGrado(GradoDTO grado);
    
    void borrarGrado(int idGrado);
}
