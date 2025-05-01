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

    public Producto comprarProducto(Moneda m, int cual) throws  PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException{
        if(m == null){
            throw new PagoIncorrectoException("La moneda no puede ser null");
        }
        int valorMoneda = m.getValor();

        if (valorMoneda < precioProducto){
            monVu.addElemento(m);
            throw new PagoInsuficienteException("Dinero insuficiente");
        }
        Producto temp = null;
        switch (cual) {
            case COCA:
                temp = coca.getElemento();
                break;
            case SPRITE:
                temp = sprite.getElemento();
                break;
            case FANTA:
                temp = fanta.getElemento();
                break;
            case SNICKERS:
                temp = snickers.getElemento();
                break;
            case SUPER8:
                temp = super8.getElemento();
                break;
            default:
                monVu.addElemento(m);
                throw new NoHayProductoException("Numero de producto no valido");
        }
        if(temp == null){
            monVu.addElemento(m);
            throw new NoHayProductoException("No hay existencias");
        }

        int vuelto = valorMoneda - precioProducto;
        for(int i = 0; i < vuelto / 100; i++){
            monVu.addElemento(new Moneda100());
        }
        return temp;
    }
    public Moneda getVuelto() {
        return monVu.getElemento();
    }
}