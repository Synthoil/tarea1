import java.util.ArrayList;
class Deposito{
    private ArrayList<Bebida> bebidas = new ArrayList<>();

    public void addBebida(Bebida b){
        bebidas.add(b);
    }
    public Bebida getBebida(){
        return bebidas.isEmpty() ? null : bebidas.remove(0);
    }
}