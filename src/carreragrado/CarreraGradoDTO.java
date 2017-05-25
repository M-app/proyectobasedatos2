package carreragrado;

public class CarreraGradoDTO {
    private int idCarreraGrado;
    private int idCarrera;
    private int idGrado;

    public CarreraGradoDTO(int idCarreraGrado, int idCarrera, int idGrado) {
        this.idCarreraGrado = idCarreraGrado;
        this.idCarrera = idCarrera;
        this.idGrado = idGrado;
    }

    public int getIdCarreraGrado() {
        return idCarreraGrado;
    }

    public void setIdCarreraGrado(int idCarreraGrado) {
        this.idCarreraGrado = idCarreraGrado;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }
    
    
}
