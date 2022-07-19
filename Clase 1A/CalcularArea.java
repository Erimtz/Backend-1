public abstract class CalcularArea {
    private float lado;
    private Double radio;

    public CalcularArea(float lado) {
        this.lado = lado;
    }

    public CalcularArea(Double radio) {
        this.radio = radio;
    }

    public float getLado() {
        return lado;
    }

    public void setLado(float lado) {
        this.lado = lado;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(Double radio) {
        this.radio = radio;
    }

    public float calcularCuadrado(){
        return lado*2;
    }

    public double calcularCirculo(){
        Double calculo = Math.PI * (Math.pow(Math.PI, 2));
        return calculo;
    }

    public abstract String calculando(CalcularArea lado);
}


