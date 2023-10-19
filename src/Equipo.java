public class Equipo {
    private String nombreE;

    public Equipo(String nombre) {
        this.nombreE = nombre;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    @Override
    public String toString() {
        return "Equipo: " +
                "nombre equipo=" + nombreE+'\n';
    }
}
