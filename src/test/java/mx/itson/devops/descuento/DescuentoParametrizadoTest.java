package mx.itson.devops.descuento;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * P4 - Una sola prueba parametrizada sustituye la repeticion manual de
 * DescuentoFronteraTest (Semana 04) y DescuentoNivelesTest (Semana 05).
 *
 * Formato de @CsvSource: "unidades, porcentajeEsperado"
 *
 * Este archivo cubre los niveles que YA existen (0 %, 10 %, 15 %).
 * En el Paso 2 de la guia vas a agregar dos filas nuevas para el nivel
 * de 20 % que pide el area comercial, ANTES de tocar Descuento.java.
 */
class DescuentoParametrizadoTest {

    private final Descuento descuento = new Descuento();

    @ParameterizedTest(name = "{0} unidades -> {1} %")
    @CsvSource({
            "0,    0",
            "99,   0",
            "100,  10",
            "499,  10",
            "500,  15",
            "999,  15",
            "1000, 20",
            "1001, 20"
            // TODO(alumno, Paso 2): agrega aqui "1000, 20" y "1001, 20"
    })
    void aplicaElPorcentajeSegunElNivel(int unidades, int porcentajeEsperado) {
        int obtenido = descuento.porcentaje(unidades);
        assertEquals(porcentajeEsperado, obtenido);
    }
}
