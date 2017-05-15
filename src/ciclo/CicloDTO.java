package ciclo;
public class CicloDTO {
    private int idCiclo;
    private int anio;
    private String status;

    public CicloDTO(int idCiclo, int anio, String status) {
        this.idCiclo = idCiclo;
        this.anio = anio;
        this.status = status;
    }

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
    
}
