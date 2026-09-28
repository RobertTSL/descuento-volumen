package mx.itson.devops.descuento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * P2 - Pruebas de frontera.
 *
 * Un fallo por fail("TODO...") solo significa "no escribi la prueba".
 * NO es evidencia de un defecto: eso lo demuestra un fallo con
 * valor esperado y valor obtenido.
 */
class DescuentoFronteraTest {

    private final Descuento descuento = new Descuento();

    @Test
    void sinDescuentoJustoAntesDeLaFrontera() {
        // preparar / ejecutar / comparar
        int obtenido = descuento.porcentaje(99);
        assertEquals(0, obtenido);
    }

    @Test
    void diezPorCientoEnLaFrontera() {
        int obtenido = descuento.porcentaje(100);
        assertEquals(10, obtenido);
    }

    @Test
    void diezPorCientoDespuesDeLaFrontera() {
        int obtenido = descuento.porcentaje(101);
        assertEquals(10, obtenido);
    }
    @Test
    void totalConDescuentoEnLaFrontera() {
        // 100 unidades a 1000 centavos = 100000 bruto, menos 10 % = 90000
        long obtenido = descuento.totalCentavos(1000, 100);
        assertEquals(90000, obtenido);
    }
    @Test
    void totalSinDescuentoJustoAntesDeLaFrontera() {
        // 99 * 1000 = 99000, sin descuento
        assertEquals(99000, descuento.totalCentavos(1000, 99));
    }
    @Test
    void totalConCeroUnidadesEsCero() {
        assertEquals(0, descuento.totalCentavos(1000, 0));
    }
    @Test
    void cantidadNegativaEsUnErrorEnElTotal() {
        assertThrows(IllegalArgumentException.class,
                () -> descuento.totalCentavos(1000, -5));
    }
}
