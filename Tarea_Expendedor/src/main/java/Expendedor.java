class Expendedor {
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int FANTA = 3;
    public static final int SNICKERS = 4;
    public static final int SUPER8 = 5;

    private Deposito<Producto> coca;
    private Deposito<Producto> sprite;
    private Deposito<Producto> fanta;
    private Deposito<Producto> snickers;
    private Deposito<Producto> super8;
    private Deposito<Moneda> monVu;
    private int precioProducto;


    public Expendedor(int cantidadProducto, int precioProducto){
        this.precioProducto = precioProducto;
        coca = new Deposito<>();
        sprite = new Deposito<>();
        fanta = new Deposito<>();
        snickers = new Deposito<>();
        super8 = new Deposito<>();
        monVu = new Deposito<>();

        for(int i = 0; i < cantidadProducto; i++){
            coca.addElemento(new CocaCola(100+i));
            sprite.addElemento(new Sprite(200+i));
            fanta.addElemento(new Sprite(300+i));
            snickers.addElemento(new Sprite(400+i));
            super8.addElemento(new Sprite(500+i));
        }
    }
    
    public Producto comprarProducto(Moneda m, int cual){
        if(m == null){
            return null;
        }
        int valorMoneda = m.getValor();

        if (valorMoneda < precioProducto){
            monVu.addElemento(m);
            return null;
        }
        Producto b = null;
        switch (cual) {
            case COCA:
                b = coca.getElemento();
                break;
            case SPRITE:
                b = sprite.getElemento();
                break;
            case FANTA:
                b = fanta.getElemento();
                break;
            case SNICKERS:
                b = snickers.getElemento();
                break;
            case SUPER8:
                b = super8.getElemento();
                break;
            default:
                monVu.addElemento(m);
                return null;
        }
        if(b == null){
            monVu.addElemento(m);
            return null;
        }

        int vuelto = valorMoneda - precioProducto;
        for(int i = 0; i < vuelto / 100; i++){
            monVu.addElemento(new Moneda100());
        }
        return b;
    }
    public Moneda getVuelto() {
        return monVu.getElemento();
    }
}