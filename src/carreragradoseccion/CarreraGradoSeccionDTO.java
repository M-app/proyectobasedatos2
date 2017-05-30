package carreragradoseccion;

public class CarreraGradoSeccionDTO {
    private int idCarreraGradoSeccion;
    private int idCarreraGrado;
    private int idSeccion;

    public CarreraGradoSeccionDTO(int idCarreraGradoSeccion, int idCarreraGrado, int idSeccion) {
        this.idCarreraGradoSeccion = idCarreraGradoSeccion;
        this.idCarreraGrado = idCarreraGrado;
        this.idSeccion = idSeccion;
    }

    public int getIdCarreraGradoSeccion() {
        return idCarreraGradoSeccion;
    }

    public void setIdCarreraGradoSeccion(int idCarreraGradoSeccion) {
        this.idCarreraGradoSeccion = idCarreraGradoSeccion;
    }

    public int getIdCarreraGrado() {
        return idCarreraGrado;
    }

    public void setIdCarreraGrado(int idCarreraGrado) {
        this.idCarreraGrado = idCarreraGrado;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }
    
    
}
