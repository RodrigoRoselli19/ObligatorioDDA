public class Arbitro extends Persona{

    private int partidosDirigidos;
    private int añosExperiencia;

    public int getPartidosDirigidos() {
        return partidosDirigidos;
    }

    public void setPartidosDirigidos(int partidosDirigidos) {
        this.partidosDirigidos = partidosDirigidos;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(int añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    public Arbitro(String cedula, String nombre, String apellido, int añosExperiencia) {
        super(cedula, nombre, apellido);
        this.partidosDirigidos = 0;
        this.añosExperiencia = añosExperiencia;
    }

    public void incrementarPartidosDirigidos() {
        partidosDirigidos++;
    }

    @Override
    public String toString() {
        return "Arbitro{" +
                "Partidos Dirigidos=" + partidosDirigidos +
                ", Años Experiencia=" + añosExperiencia +
                '}';
    }
}
