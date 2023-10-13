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

    public Jugador(String cedula, String nombre, String apellido, double salario, String posicion, String equipo) {
        super(cedula, nombre, apellido, salario);
        this.posicion = posicion;
        this.equipo = equipo;
        this.minutos = 0;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Jugador: " +
                "Posicion='" + posicion + '\'' +
                ", Equipo='" + equipo + '\'' +
                ", Minutos=" + minutos + '\'';
    }

    @Override
    public double calcularSalario() {
        // Calcula el salario base del jugador
        double salarioBase = this.getSalario();

        // Aplica el 20% de prima sobre el salario base
        double prima = salarioBase * 0.2;

        return salarioBase + prima;
    }
}
