public class String  Arbol {
        //Atributos
        private Double alto;
        private Double horizontal;
        private String color;


        //Constructor


    public static Arbol(Double alto, Double horizontal, String color) {
        this.alto = alto;
        this.horizontal = horizontal;
        this.color = color;
    }

    public Double getAlto() {
        return alto;
    }

    public Double getHorizontal() {
        return horizontal;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Arbol{" +
                "alto=" + alto +
                ", Horizontal=" + Horizontal +
                ", color='" + color + '\'' +
                '}';
    }
}
