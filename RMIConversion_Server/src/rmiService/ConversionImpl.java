package rmiService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class ConversionImpl extends UnicastRemoteObject implements IConversion {
    private static final long serialVersionUID = 1L;
    private static final double TAUX_EUR_TND = 3.4;
    public ConversionImpl() throws RemoteException {
        super();
    }
    @Override
    public double convertirMontant(double mt) throws RemoteException {
        System.out.println("Conversion demandee : " + mt + " EUR");
        return mt * TAUX_EUR_TND;
    }
}