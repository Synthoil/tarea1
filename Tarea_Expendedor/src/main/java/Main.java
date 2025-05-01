import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Expendedor exp = new Expendedor(7);
        Moneda m = null;
        Comprador c = null;

        m = new Moneda1000();
        c = new Comprador(m, Expendedor.SPRITE,exp);
        System.out.println(c.queConsumiste());
        System.out.println(c.cuantoVuelto());

    }
}

