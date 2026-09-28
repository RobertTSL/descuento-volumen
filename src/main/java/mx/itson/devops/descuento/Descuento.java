package mx.itson.devops.descuento;

/**
 * Descuento por volumen.
 *
 * REGLA DE NEGOCIO acordada con el area comercial:
 *   - menos de 100 unidades  -> 0 %
 *   - DESDE 100 unidades     -> 10 %
 *   - unidades negativas     -> IllegalArgumentException
 */
public class Descuento {

    public int porcentaje(int unidades) {
        if (unidades < 0) {
            throw new IllegalArgumentException("unidades negativas: " + unidades);
        }
        return unidades >= 100 ? 10 : 0;
    }

    /** Total a cobrar en centavos, ya con el descuento aplicado. */
    public long totalCentavos(long precioUnitarioCentavos, int unidades) {
        long bruto = precioUnitarioCentavos * unidades;
        return bruto - (bruto * porcentaje(unidades)) / 100;
    }
}
