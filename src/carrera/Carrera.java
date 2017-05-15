package carrera;

import java.util.Collection;

public interface Carrera {
    Collection<CarreraDTO> getCarreras();
    
    CarreraDTO getCarrera(int idCarrera);
    
    Collection<CarreraDTO> getCarrerasPorNivel(int idNivel);
    
    void insertarCarrera(CarreraDTO carrera);
    
    void actualizarCarrera(CarreraDTO carrera);
    
    void borrarCarrera(int idCarrera);
}
