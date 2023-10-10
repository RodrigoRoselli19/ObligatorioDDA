public class Jugador extends Persona{

    private String posicion;
    private String equipo;
    private int minutos;

    public String getPosicion(){
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getEquipo(){
        return equipo;
    }
public void setEquipo(String equipo){
        this.equipo = equipo;
}

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public Jugador(String cedula, String nombre, String apellido, String posicion, String equipo) {
        super(cedula, nombre, apellido);
        this.posicion = posicion;
        this.equipo = equipo;
        this.minutos = 0;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "Posicion='" + posicion + '\'' +
                ", Equipo='" + equipo + '\'' +
                ", Minutos=" + minutos +
                '}';
    }
}
