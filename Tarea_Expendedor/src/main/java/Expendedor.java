class Expendedor {
    public static final int COCA = 1;
    public static final int SPRITE = 2;

    private Deposito coca;
    private Deposito sprite;
    private DepositoM monVu;
    private int precioBebidas;


    public Expendedor(int numBebidas, int precioBebidas){
        this.precioBebidas = precioBebidas;
        coca = new Deposito();
        sprite = new Deposito();
        monVu = new DepositoM();

        for(int i = 0; i < numBebidas; i++){
            coca.addBebida(new CocaCola(100+i));
            sprite.addBebida(new Sprite(200+i));
        }
    }

    public Bebida comprarBebida(Moneda m, int cual){
        if(m == null){
            return null;
        }
        int valorMoneda = m.getValor();

        if (valorMoneda < precioBebidas){
            monVu.addMoneda(m);
            return null;
        }
        Bebida b = null;
        switch (cual) {
            case COCA:
                b = coca.getBebida();
                break;
            case SPRITE:
                b = sprite.getBebida();
                break;
            default:
                monVu.addMoneda(m);
                return null;
        }
        if(b == null){
            monVu.addMoneda(m);
            return null;
        }

        int vuelto = valorMoneda - precioBebidas;
        for(int i = 0; i < vuelto / 100; i++){
            monVu.addMoneda(new Moneda100());
        }
        return b;
    }
    public Moneda getVuelto() {
        return monVu.getMoneda();
    }
}