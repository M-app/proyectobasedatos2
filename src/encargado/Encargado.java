package encargado;

import java.util.Collection;

public interface Encargado {
    Collection<EncargadoDTO> getEncargados();
    
    EncargadoDTO getEncargado(int idEncrgado);
    
    void insertarEncargado(EncargadoDTO encargado);
    
    void actualizarEncargado(EncargadoDTO encargado);
    
    void borrarEncargado(int idEncargado);
}
