package rmiClient;
import java.util.Date;
import javax.naming.Context;
import javax.naming.InitialContext;
import metier.Compte;
import rmiService.IBanque;
public class BanqueClient {
    public static void main(String[] args) {
        try {
            Context ctx = new InitialContext();
            IBanque stub = (IBanque) ctx.lookup("BK");
            System.out.println(stub.creerCompte(new Compte(1, 5000, new Date())));
            System.out.println(stub.creerCompte(new Compte(1, 200, new Date())));
            System.out.println(stub.getInfoCompte(1));
            System.out.println(stub.getInfoCompte(99));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}