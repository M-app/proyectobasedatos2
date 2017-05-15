package alumno;

import java.util.Collection;

public interface Alumno {
    Collection<AlumnoDTO> getAlumnos();
    
    AlumnoDTO getAlumno(int idAlumno);
    
    Collection<AlumnoDTO> getAlumnosPorEncargado(int idEncargado);
    
    void insertarAlumno(AlumnoDTO alumno);
    
    void actualizarAlumno(AlumnoDTO alumno);
    
    void borrarAlumno(int idAlumno);
}
