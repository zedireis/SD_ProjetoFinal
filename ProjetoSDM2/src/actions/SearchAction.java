package actions;

import com.opensymphony.xwork2.ActionSupport;
import models.interfaces.ProductModel;
import models.rmiBean;
import org.apache.struts2.interceptor.SessionAware;
import services.interfaces.SearchService;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Performs a search in the backend for a specific product and displays the result to the user
 */
public class SearchAction extends ActionSupport implements SessionAware {

    private ProductModel inputObject;     /* Object holding the user's input */

    private SearchService searchService;

    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;

    private rmiBean rmi;

    /* Search results to be populated by this action */
    private List<Object> results;

    public SearchAction()
    {
        setResults(new ArrayList<Object>());
    }

    public String execute() throws RemoteException, SQLException {
        this.rmi = this.getRMI();
        setResults(getSearchService().search(this.rmi, getInputObject(), this.session));
        return SUCCESS;
    }

    public rmiBean getRMI() {
        if(!session.containsKey("rmiBean"))
            this.setRMI(new rmiBean());
        return (rmiBean) session.get("rmiBean");
    }

    public void setRMI(rmiBean RMI) {
        this.session.put("rmiBean", RMI);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }


    public ProductModel getInputObject() {
        return inputObject;
    }

    public void setInputObject(ProductModel inputObject) { this.inputObject = inputObject; }

    public SearchService getSearchService() {
        return searchService;
    }

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    public List<Object> getResults() {
        return results;
    }

    public void setResults(List<Object> results) {
        this.results = results;
    }

}
