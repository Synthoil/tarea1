import java.util.ArrayList;
import java.util.Scanner;

public class MainInteracivo {
    public static void main(String[] args){
        Expendedor exp = new Expendedor(5); // 5 productos de cada tipo
        Scanner scanner = new Scanner(System.in);
        int opcion=-1;

        while (opcion !=0) {
            System.out.println("-------------Bienvenido a nuestro expendedor de productos-------------");
            System.out.println("Las opciones del producto son : \n1.Bebida CocaCola");
            System.out.println("2.Bebida Fanta");
            System.out.println("3.Bebida Sprite");
            System.out.println("4.Dulce Super8");
            System.out.println("5.Dulce Snickers");

            System.out.println("Digite su opcion de compra o el numero '0' si desea salir");

            opcion = scanner.nextInt();
            if (opcion == 0) {
                System.out.println("Presionó la opcion de salir,gracias por su compra.");
                break;
            }

            System.out.println("Introduzca el valor de su moneda (Monedas aceptadas : 100,500,1000):");
            int valorMoneda = scanner.nextInt();
            Moneda moneda = null;
            switch (valorMoneda){
                case 100:
                    moneda = new Moneda100();
                    break;
                case 500:
                    moneda = new Moneda500();
                    break;
                case 1000:
                    moneda = new Moneda1000();
            }

            try {
                Comprador c = new Comprador(moneda,opcion,exp);
                System.out.println("Producto que consumió : "+ c.queConsumiste());
                System.out.println("Su vuelto es de : "+c.cuantoVuelto());
            } catch (PagoIncorrectoException e){
                System.out.println("Lo sentimos "+ e.getMessage());
            }catch (PagoInsuficienteException e){
                System.out.println("Lo sentimos " + e.getMessage());
            }catch (NoHayProductoException e){
                System.out.println("Lo sentimos "+ e.getMessage());
            }catch (Exception e){
                System.out.println("Error : "+ e.getMessage());
            }
            System.out.println("Si no quiere comprar mas presione '0', de lo contrario ingrese 10");
            opcion = scanner.nextInt();

        }
        scanner.close();
    }
}
