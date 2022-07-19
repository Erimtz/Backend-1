public class CalculoFigura extends CalcularArea{
    public CalculoFigura(float lado) {
        super(lado);
    }

    @Override
    public String calculando(CalcularArea lado) {
        String mensaje = "El valor del radio o lado debe ser mayor que cero.";
        if (lado instanceof CalcularArea){
        }
        return mensaje;
    }
}
