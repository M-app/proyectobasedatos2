package carreragrado;

import grado.GradoDTO;
import java.util.Collection;

public interface CarreraGrado {
       
    void insertarCarreraGrado(CarreraGradoDTO carreraGrado);
    
    Collection<CarreraGradoDTO> getCarrerasGrados();
    
    CarreraGradoDTO getCarreraGrado(int codigoCarrerGrado);
    
    Collection<GradoDTO> getGradosPorCarrera(int idCarrera);
}
