package seccion;

public class SeccionDTO {
    private int idSeccion;
    private String seccion;

    public SeccionDTO(int idSeccion, String seccion) {
        this.idSeccion = idSeccion;
        this.seccion = seccion;
    }

    public int getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    
    
}
