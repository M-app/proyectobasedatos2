package carrera;

public class CarreraDTO {
    private int idCarrera;
    private String carrera;
    private int idNivel;

    public CarreraDTO(int idCarrera, String carrera, int idNivel) {
        this.idCarrera = idCarrera;
        this.carrera = carrera;
        this.idNivel = idNivel;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }
    
    
}
