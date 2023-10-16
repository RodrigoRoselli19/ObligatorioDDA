public class Partido {

    private String fecha;
    private String hora;
    private String equipoA;
    private String equipoB;
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

    public String getEquipoA() {
        return equipoA;
    }

    public void setEquipoA(String equipoA) {
        this.equipoA = equipoA;
    }

    public String getEquipoB() {
        return equipoB;
    }

    public void setEquipoB(String equipoB) {
        this.equipoB = equipoB;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

    public Partido(String fecha, String hora, String equipoA, String equipoB, Arbitro arbitro) {
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
