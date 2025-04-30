class Comprador{
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualProducto, Expendedor exp){
        this.sonido = null;
        this.vuelto = 0;

        if(m != null) {
            Producto b = exp.comprarProducto(m, cualProducto);

            if(b != null) {
                this.sonido = b.consumir();
            }

            Moneda monedaVuelto;
            while((monedaVuelto = exp.getVuelto()) != null) {
                this.vuelto += monedaVuelto.getValor();
            }
        }
    }
    public int cuantoVuelto(){
        return this.vuelto;
    }
    public String queConsumiste(){
        return (this.sonido != null) ? this.sonido : null;
    }
}