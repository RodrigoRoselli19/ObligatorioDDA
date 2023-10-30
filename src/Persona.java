public abstract class Persona {
    private String cedula;
    private String nombre;
    private String apellido;

    private double salario;

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getCedula(){
        return cedula;
    }

    public void setCedula(String cedula){
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Persona(String cedula, String nombre, String apellido, double salario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Persona: " +'\'' +
                "Cedula= '" + cedula + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                ", Salario='" + salario + '\'';
    }

    public abstract double calcularSalario();
}
