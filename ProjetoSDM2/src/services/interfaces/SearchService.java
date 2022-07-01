package services.interfaces;

import models.interfaces.ProductModel;
import models.rmiBean;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/* Every service needs to implement this interface and its function */
public interface SearchService {
    List<Object> search(rmiBean rmi, ProductModel query, Map<String, Object> session) throws RemoteException, SQLException;
}
