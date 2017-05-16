package nivelciclo;

public class NivelCicloDTO {
    private int idNivelCiclo;
    private int idCiclo;
    private int idNivel;

    public NivelCicloDTO(int idNivelCiclo, int idCiclo, int idNivel) {
        this.idNivelCiclo = idNivelCiclo;
        this.idCiclo = idCiclo;
        this.idNivel = idNivel;
    }

    public int getIdNivelCiclo() {
        return idNivelCiclo;
    }

    public void setIdNivelCiclo(int idNivelCiclo) {
        this.idNivelCiclo = idNivelCiclo;
    }

    public int getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }
    
    
}
