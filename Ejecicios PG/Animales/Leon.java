public class Leon {
    private String nombre;
    private int edad;
    private String esAlfa;

    public Leon() {
        this.nombre = nombre;
        this.edad = edad;
        this.esAlfa = esAlfa;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String isEsAlfa() {
        return esAlfa;
    }

    public void correr(){
        correr();
        System.out.println("El" + nombre + "tiene" + edad + "y corre!");
    }

    public void esMayor(String nombre){
        if(edad >= 10){
            System.out.println("El" + this.nombre +"es un animal que" + esAlfa);
        }
        esMayor(this.nombre);
    }
}
