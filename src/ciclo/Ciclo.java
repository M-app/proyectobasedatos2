package ciclo;

import java.util.Collection;

public interface Ciclo{
    Collection<CicloDTO> getCiclos();
    
    CicloDTO getCiclo(int idCiclo);
    
    void insertarCiclo(CicloDTO ciclo);
    
    void actualizarCiclo(CicloDTO ciclo);
    
    void borrarCiclo(int idCiclo);
    
}
