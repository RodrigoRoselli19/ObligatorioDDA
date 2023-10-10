public abstract class Persona {
    private String cedula;
    private String nombre;
    private String apellido;

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

    public Persona(String cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Cedula='" + cedula + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Apellido='" + apellido + '\'' +
                '}';
    }
}
