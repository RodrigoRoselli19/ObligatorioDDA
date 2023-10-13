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

    @Override
    public double calcularSalario() {
        // Calcula el salario base del árbitro
        double salarioBase =1000;

        // Aplica un 3% adicional por cada año de trabajo si tiene más de 5 años arbitrando
        if (añosExperiencia > 5) {
            int añosExperiencia = 6;
            double bonoExperiencia = salarioBase * (0.03 * añosExperiencia);
            salarioBase += bonoExperiencia;
        }

        return salarioBase;
    }
}







