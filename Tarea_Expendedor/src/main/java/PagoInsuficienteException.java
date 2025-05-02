/**
 * Excepcion lanzada cuando la moneda es tipo "null".
 */

public class PagoInsuficienteException extends Exception {

    /**
     * Crea la excepción con un mensaje.
     *
     * @param mensaje Mensaje que describe el error.
     */
    public PagoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
