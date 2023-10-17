public class Tecnico extends Persona {
    private Equipo equipo;
    private int partidosGanados;

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public Tecnico(String cedula, String nombre, String apellido,double salario, Equipo equipo) {
        super(cedula, nombre, apellido, salario);
        this.equipo = equipo;
        this.partidosGanados = 0;
    }

    public void incrementarPartidosGanados() {
        partidosGanados++;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Tecnico: " +
                "Equipo='" + equipo + '\'' +
                ", Partidos Ganados=" + partidosGanados;
    }

    @Override
    public double calcularSalario() {
        // Calcula el salario base del técnico
        double salarioBase = this.getSalario();

        // Aplica el 10% de complemento sobre el salario base si ha ganado al menos 3 partidos
        if (partidosGanados > 3) {
            double complemento = salarioBase * 0.1;
            salarioBase += complemento;
        }

        return salarioBase;
    }
}