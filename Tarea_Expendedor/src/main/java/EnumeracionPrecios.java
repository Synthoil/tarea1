public enum EnumeracionPrecios {
    COCA(100),
    SPRITE(200),
    FANTA(300),
    SNICKERS(400),
    SUPER8(500);

    private int precio;

    EnumeracionPrecios(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}
