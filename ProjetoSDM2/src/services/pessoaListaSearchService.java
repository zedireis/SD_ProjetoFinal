package services;

import Data.Eleicao;
import Data.Pessoa;
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
public class pessoaListaSearchService implements SearchService {

    /* List of existing shoe products. Emulates a database in this example */
    private ArrayList<Pessoa> pessoasLista = new ArrayList<>();
    private Pessoa pessoa = null;

    public pessoaListaSearchService() throws RemoteException, SQLException {

    }
    /**
     * Searches for shoe products that match the non-null fields of the variable 'query'.
     * @param query ShoeProductModel that contains the search conditions as chosen by the user.
     * @return a list with the products that match the search, null if there is any problem.
     */
    @Override
    public List<Object> search(rmiBean rmi, ProductModel query, Map<String, Object> session) throws RemoteException, SQLException {
        Eleicao eleicao = (Eleicao) session.get("eleicao");
        this.pessoasLista = rmi.getPessoas_NOME_CC_ELEICAO(eleicao.getTipo_id(), eleicao.getId());
        if (query instanceof Pessoa)
        {
            Pessoa queryEleicao = (Pessoa) query;

            List<Object> results = new ArrayList<Object>();

            for (Pessoa i: pessoasLista)
            {
                //boolean condition = Compare.strings(queryEleicao.getTitulo(), i.getTitulo());
                results.add(i);
                // Assume AND condition
                //if (condition)
                //{
                    //results.add(i);
                //}
            }

            return results;

        }
        return null;
    }
}
