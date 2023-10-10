public class Tecnico extends Persona {
    private String equipo;
    private int partidosGanados;

    public String getEquipo(){
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public Tecnico(String cedula, String nombre, String apellido, String equipo) {
        super(cedula, nombre, apellido);
        this.equipo = equipo;
        this.partidosGanados = 0;
    }

    public void incrementarPartidosGanados() {
        partidosGanados++;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "Equipo='" + equipo + '\'' +
                ", Partidos Ganados=" + partidosGanados +
                '}';
    }
}