package services;

import Data.Eleicao;
import models.interfaces.ProductModel;
import models.rmiBean;
import services.interfaces.SearchService;
import utils.Compare;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* Search service that can be used to find shoe products according to user-defined conditions */
public class eleicaoForVotingSearchService implements SearchService {

    /* List of existing shoe products. Emulates a database in this example */
    private ArrayList<Eleicao> eleicoes = new ArrayList<>();
    private Eleicao eleicao = null;

    public eleicaoForVotingSearchService() throws RemoteException, SQLException {

    }
    /**
     * Searches for shoe products that match the non-null fields of the variable 'query'.
     * @param query ShoeProductModel that contains the search conditions as chosen by the user.
     * @return a list with the products that match the search, null if there is any problem.
     */
    @Override
    public List<Object> search(rmiBean rmi, ProductModel query, Map<String, Object> session) throws RemoteException, SQLException {
        this.eleicoes = rmi.getEleicao();

        if (query instanceof Eleicao)
        {
            Eleicao queryEleicao = (Eleicao) query;

            List<Object> results = new ArrayList<Object>();

            for (Eleicao i: eleicoes)
            {
                boolean condition = Compare.strings(queryEleicao.getTitulo(), i.getTitulo());

                // Assume AND condition
                if (condition)
                {
                    results.add(i);
                }
            }

            return results;

        }
        return null;
    }
}
