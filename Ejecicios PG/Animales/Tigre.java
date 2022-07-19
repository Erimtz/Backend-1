public class Tigre {
    private String nombre;
    private int edad;

    public Tigre() {
        this.nombre = getNombre();
        this.edad = getEdad();
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Tigre(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void correr(){
        correr();
        System.out.println("El" + nombre + "tiene" + edad + "y corre!");
    }

}
