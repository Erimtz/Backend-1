import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalcularAreaTest {

    @Test
    public void confimarAreaCirculo() {
        CalcularArea calcularCirculo = new CalcularArea(12.56) {
            @Override
            public String calculando(CalcularArea lado) {
                return null;
            }
        };

    }

    @Test
    public void confimarAreaCuaadrado() {
        CalcularArea calcularCuadrado = new CalcularArea(4) {
            @Override
            public String calculando(CalcularArea lado) {
                return null;
            }
        };


    }

    @Test
    public void confimarAreaFigura() {
        CalcularArea CalculoFigura = new CalcularArea(10) {
            @Override
            public String calculando(CalcularArea lado) {
                return null;
            }
        };


    }
}
