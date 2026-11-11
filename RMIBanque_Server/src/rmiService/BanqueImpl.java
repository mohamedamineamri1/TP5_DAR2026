package rmiService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import metier.Compte;
public class BanqueImpl extends UnicastRemoteObject implements IBanque {
    private static final long serialVersionUID = 1L;
    private Map<Integer, Compte> comptes = new HashMap<>();
    public BanqueImpl() throws RemoteException {
        super();
    }
    @Override
    public synchronized String creerCompte(Compte c) throws RemoteException {
        if (comptes.containsKey(c.getCode())) {
            return "Erreur : le compte " + c.getCode() + " existe deja.";
        }
        comptes.put(c.getCode(), c);
        return "Compte " + c.getCode() + " cree avec succes.";
    }
    @Override
    public synchronized String getInfoCompte(int code) throws RemoteException {
        Compte c = comptes.get(code);
        if (c == null) {
            return "Compte " + code + " introuvable.";
        }
        return c.toString();
    }
}