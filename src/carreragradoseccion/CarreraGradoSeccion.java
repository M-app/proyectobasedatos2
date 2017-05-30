package carreragradoseccion;

import java.util.Collection;
import seccion.SeccionDTO;

public interface CarreraGradoSeccion {
    void insertarCarreraGradoSeccion(CarreraGradoSeccionDTO carreraGradoSeccion);
    CarreraGradoSeccionDTO getCarreraGradoSeccion(int idCarreraGradoSeccion);
    Collection<CarreraGradoSeccionDTO> getCarreraGradoSeccion();
    Collection<SeccionDTO> getSeccionesPorGrado(int idGrado); // dudas aquí
}
