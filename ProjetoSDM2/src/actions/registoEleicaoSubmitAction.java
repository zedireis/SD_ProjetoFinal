package actions;

import Data.Eleicao;
import com.opensymphony.xwork2.ActionSupport;
import models.rmiBean;
import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Performs a search in the backend for a specific product and displays the result to the user
 */
public class registoEleicaoSubmitAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String dep_id = null;
    private String tipo_id = null;
    private String titulo = null;
    private String descricao = null;
    private String dataInicio = null;
    private String dataFim = null;

    @Override
    public String execute() throws RemoteException, SQLException, ParseException {
        if(validarInput()){
            try{
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                Date parsedDate = dateFormat.parse(dataInicio);
                Timestamp timestampInicio = new java.sql.Timestamp(parsedDate.getTime());

                parsedDate = dateFormat.parse(dataFim);
                Timestamp timestampFim = new java.sql.Timestamp(parsedDate.getTime());

                if(timestampFim.after(timestampInicio)){
                    Eleicao devolve = new Eleicao(timestampInicio, timestampFim, titulo, descricao, Integer.parseInt(tipo_id), Integer.parseInt(dep_id));
                    this.getRMI().createElection(devolve);
                }

                return SUCCESS;
            }
            catch (Exception e){
                return ERROR;
            }
        }
        return ERROR;
    }

    public boolean validarInput(){
        if((dep_id != null) && (tipo_id != null) && (titulo != null) && (descricao != null) && (dataInicio != null) && (dataFim != null)){
            // Fazer mais verificacoes
            return true;
        }
        return false;
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

    public void setDep_id(String dep_id) {
        this.dep_id = dep_id;
    }

    public void setTipo_id(String tipo_id) {
        this.tipo_id = tipo_id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
}
