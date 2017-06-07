package nivel;

public class NivelDTO {
    private int idNivel;
    private String nivel;

    public NivelDTO(int idNivel, String nivel) {
        this.idNivel = idNivel;
        this.nivel = nivel;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    @Override
    public String toString(){
        return String.valueOf(getIdNivel()) + "---" + getNivel();
    }
}
