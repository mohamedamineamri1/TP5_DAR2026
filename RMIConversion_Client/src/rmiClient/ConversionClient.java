package rmiClient;
import java.rmi.Naming;
import rmiService.IConversion;
public class ConversionClient {
    public static void main(String[] args) {
        try {
            IConversion stub = (IConversion) Naming.lookup("rmi://localhost:1099/conversion");
            double resultat = stub.convertirMontant(500);
            System.out.println("500 EUR = " + resultat + " TND");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}