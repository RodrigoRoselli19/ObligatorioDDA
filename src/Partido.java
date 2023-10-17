public class Partido {

    private String fecha;
    private String hora;
    private Equipo equipoA;
    private Equipo equipoB;
    private Arbitro arbitro;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Equipo getEquipoA() {
        return equipoA;
    }

    public void setEquipoA(Equipo equipoA) {
        this.equipoA = equipoA;
    }

    public Equipo getEquipoB() {
        return equipoB;
    }

    public void setEquipoB(Equipo equipoB) {
        this.equipoB = equipoB;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public Partido(String fecha, String hora, Equipo equipoA, Equipo equipoB, Arbitro arbitro) {
        this.fecha = fecha;
        this.hora = hora;
        this.equipoA = equipoA;
        this.equipoB = equipoB;
        this.arbitro = arbitro;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "Fecha='" + fecha + '\'' +
                ", Hora='" + hora + '\'' +
                 equipoA +
                " vs '" + equipoB + '\'' +
                ", Arbitro=" + arbitro +
                '}';
    }
}
