package rmiServer;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import rmiService.ConversionImpl;
public class ConversionServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            ConversionImpl obj = new ConversionImpl();
            Naming.rebind("rmi://localhost:1099/conversion", obj);
            System.out.println("Serveur de conversion pret...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}