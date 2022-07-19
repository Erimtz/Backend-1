public class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private int edad;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String mostrarNombreConApellido(){
        return this.nombre + this.apellido;
    }

    public boolean esMayorEdad(){
        return this.edad >18;
    }
}


