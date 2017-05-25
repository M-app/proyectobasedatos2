package nivelciclo;

import java.util.Collection;

public interface NivelCiclo {
    
    void insertarNivelCiclo(NivelCicloDTO nivelCiclo);
    
    Collection<NivelCicloDTO> getNiveles();
    
    Collection<NivelCicloDTO> getNivelesPorCiclo(int idCiclo);
}
