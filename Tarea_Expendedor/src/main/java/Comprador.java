class Comprador{
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualBebida, Expendedor exp){
        this.sonido = null;
        this.vuelto = 0;

        if(m != null) {
            Bebida b = exp.comprarBebida(m, cualBebida);

            if(b != null) {
                this.sonido = b.beber();
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
    public String queBebiste(){
        return (this.sonido != null) ? this.sonido : null;
    }
}