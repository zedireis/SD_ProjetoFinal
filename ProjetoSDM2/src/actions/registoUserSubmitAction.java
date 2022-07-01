package actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;
import java.util.regex.Pattern;

import models.rmiBean;

import Data.*;

/**
 * Performs a search in the backend for a specific product and displays the result to the user
 */
public class registoUserSubmitAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String dep_id = null;
    private String tipo_id = null;
    private String username = null;
    private String password = null;
    private String nome = null;
    private String morada = null;
    private String nrTelemovel = null;
    private String ccNumber = null;
    private String diaCC = null;
    private String mesCC = null;
    private String anoCC = null;

    @Override
    public String execute() throws RemoteException, SQLException {
        if(validarInput()){
            Date validade_cc = new Date(Integer.parseInt(anoCC) - 1900, Integer.parseInt(mesCC) - 1, Integer.parseInt(diaCC));
            Pessoa devolve = new Pessoa(username, password, nome, Integer.parseInt(tipo_id), morada, nrTelemovel, Integer.parseInt(ccNumber), validade_cc, Integer.parseInt(dep_id));
            this.getRMI().insertUser(devolve);
            return SUCCESS;
        }
        return ERROR;
    }

    public boolean validarInput(){
        if((dep_id != null) && (tipo_id != null) && (username != null) && (password != null) && (nome != null) && (morada != null) && (nrTelemovel != null) && (ccNumber != null) && (diaCC != null) && (mesCC != null) && (anoCC != null)){
            // Fazer mais verificacoes
            if((Pattern.matches("[a-zA-Z]+", nrTelemovel) == false) && (nrTelemovel.length()==9) && (Pattern.matches("[a-zA-Z]+", ccNumber) == false) && (ccNumber.length()==8) && (username != "") && (password != "") && (nome != "") && (morada != "")) {
                return true;
            }
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDep_id(String dep_id) {
        this.dep_id = dep_id;
    }

    public void setTipo_id(String tipo_id) {
        this.tipo_id = tipo_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setNrTelemovel(String nrTelemovel) {
        this.nrTelemovel = nrTelemovel;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public void setDiaCC(String diaCC) {
        this.diaCC = diaCC;
    }

    public void setMesCC(String mesCC) {
        this.mesCC = mesCC;
    }

    public void setAnoCC(String anoCC) {
        this.anoCC = anoCC;
    }
}
