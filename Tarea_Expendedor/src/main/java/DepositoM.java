import java.util.ArrayList;
class DepositoM {
    private ArrayList<Moneda> monedas = new ArrayList<>();

    public void addMoneda(Moneda m) {
        monedas.add(m);
    }

    public Moneda getMoneda() {
        return monedas.isEmpty() ? null : monedas.remove(0);
    }
}