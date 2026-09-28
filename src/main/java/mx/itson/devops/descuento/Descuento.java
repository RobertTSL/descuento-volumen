package mx.itson.devops.descuento;

/**
 * Descuento por volumen.
 *
 * REGLA DE NEGOCIO (actualizada esta semana por el area comercial):
 *   - menos de 100 unidades   -> 0 %
 *   - de 100 a 499 unidades   -> 10 %
 *   - DESDE 500 unidades      -> 15 %
 *   - unidades negativas      -> IllegalArgumentException
 *   - precio unitario <= 0    -> IllegalArgumentException (error de captura)
 */
public class Descuento {

    public int porcentaje(int unidades) {
        if (unidades < 0) {
            throw new IllegalArgumentException("unidades negativas: " + unidades);
        }
        if (unidades >= 500) {
            return 15;
        } else if (unidades >= 100) {
            return 10;
        }

        return 0;
    }

    /** Total a cobrar en centavos, ya con el descuento aplicado. */
    public long totalCentavos(long precioUnitarioCentavos, int unidades) {
        if (precioUnitarioCentavos <= 0) {
            throw new IllegalArgumentException("precio unitario invalido: " + precioUnitarioCentavos);
        }
        long bruto = precioUnitarioCentavos * unidades;
        return bruto - (bruto * porcentaje(unidades)) / 100;
    }
}
