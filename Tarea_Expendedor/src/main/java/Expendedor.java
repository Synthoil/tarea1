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


    public Expendedor(int cantidadProducto){
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
        
        if(cual < 1 || cual > EnumeracionPrecios.values().length){
            throw new NoHayProductoException("Numero de producto no valido");
        }

        this.precioProducto = EnumeracionPrecios.values()[cual - 1].getPrecio();

        if (m.getValor() < precioProducto){
            monVu.addElemento(m);
            throw new PagoInsuficienteException("Dinero insuficiente");
        }

        Deposito<?> deposito;
        deposito = switch (cual) {
            case COCA -> coca;
            case SPRITE -> sprite;
            case FANTA -> fanta;
            case SNICKERS -> snickers;
            case SUPER8 -> super8;
            default -> throw new NoHayProductoException("Producto no existe");
        };

        Producto temp = (Producto) deposito.getElemento();
        if(temp == null){
            monVu.addElemento(m);
            throw new NoHayProductoException("No hay existencias");
        }

        int vuelto = m.getValor() - precioProducto;
        for(int i = 0; i < vuelto / 100; i++){
            monVu.addElemento(new Moneda100());
        }
        return temp;
    }
    public Moneda getVuelto() {
        return monVu.getElemento();
    }
}