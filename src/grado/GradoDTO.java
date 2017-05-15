package grado;

public class GradoDTO {
    private int idGrado;
    private String grado;

    public GradoDTO(int idGrado, String grado) {
        this.idGrado = idGrado;
        this.grado = grado;
    }

    public int getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(int idGrado) {
        this.idGrado = idGrado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
}
