class Expendedor {
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int FANTA = 3;
    public static final int SNICKERS = 4;
    public static final int SUPER8 = 5;

    private Deposito coca;
    private Deposito sprite;
    private Deposito fanta;
    private Deposito snickers;
    private Deposito super8;
    private DepositoM monVu;
    private int precioProducto;


    public Expendedor(int cantidadProducto, int precioProducto){
        this.precioProducto = precioProducto;
        coca = new Deposito();
        sprite = new Deposito();
        fanta = new Deposito();
        snickers = new Deposito();
        super8 = new Deposito();
        monVu = new DepositoM();

        for(int i = 0; i < cantidadProducto; i++){
            coca.addProducto(new CocaCola(100+i));
            sprite.addProducto(new Sprite(200+i));
            fanta.addProducto(new Sprite(300+i));
            snickers.addProducto(new Sprite(400+i));
            super8.addProducto(new Sprite(500+i));
        }
    }

    public Producto comprarProducto(Moneda m, int cual){
        if(m == null){
            return null;
        }
        int valorMoneda = m.getValor();

        if (valorMoneda < precioProducto){
            monVu.addMoneda(m);
            return null;
        }
        Producto b = null;
        switch (cual) {
            case COCA:
                b = coca.getProducto();
                break;
            case SPRITE:
                b = sprite.getProducto();
                break;
            case FANTA:
                b = fanta.getProducto();
                break;
            case SNICKERS:
                b = snickers.getProducto();
                break;
            case SUPER8:
                b = super8.getProducto();
                break;
            default:
                monVu.addMoneda(m);
                return null;
        }
        if(b == null){
            monVu.addMoneda(m);
            return null;
        }

        int vuelto = valorMoneda - precioProducto;
        for(int i = 0; i < vuelto / 100; i++){
            monVu.addMoneda(new Moneda100());
        }
        return b;
    }
    public Moneda getVuelto() {
        return monVu.getMoneda();
    }
}