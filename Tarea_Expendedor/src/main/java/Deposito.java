import java.util.ArrayList;
class Deposito{
    private ArrayList<Producto> productos = new ArrayList<>();

    public void addProducto(Producto b){
        productos.add(b);
    }
    public Producto getProducto(){
        return productos.isEmpty() ? null : productos.remove(0);
    }
}