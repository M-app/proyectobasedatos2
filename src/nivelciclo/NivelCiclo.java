package nivelciclo;

import java.util.Collection;
import nivel.NivelDTO;

public interface NivelCiclo {
    
    void insertarNivelCiclo(NivelCicloDTO nivelCiclo);
    
    NivelCicloDTO getNivelCiclo(int idNivelCiclo);
    
    Collection<NivelCicloDTO> getNivelesCiclos();
    
    Collection<NivelDTO> getNivelesPorCiclo(int idCiclo);
}
