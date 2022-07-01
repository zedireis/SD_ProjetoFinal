package actions;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import models.rmiBean;

import Data.*;

public class loginVotanteAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String username = null, password = null;
    private Pessoa votante = null;

    //Dados para votar
    private ArrayList<Eleicao> eleicoesForVote = null;
    private String idEleicaoSelecionada = null;
    private ArrayList<Lista> listasForVote = null;
    private String idListaVotada = null;
    private Eleicao eleicao = null;

    @Override
    public String execute() throws RemoteException, SQLException {
        if(this.username != null && !username.equals("")) { //Verifica se o utilizador está registado.
            votante = this.getRMI().getUserMatchesPassword(this.username, this.password);
            if(votante != null){
                this.session.put("votante", votante);
                this.eleicoesForVote = this.getRMI().getEleicaoForPessoa(votante.getTipo_id(),votante.getDep_id());
                this.session.put("eleicoesForVote", eleicoesForVote);
                setVotante(votante);
                return SUCCESS;
            }
            return LOGIN;
        }
        else
            return LOGIN;
    }

    public String EscolherEleicaoEleitor() throws RemoteException, SQLException{
        // Como a Eleicao foi selecionada, apenas e preciso obter as listas para votar
        this.votante = (Pessoa)session.get("votante");
        if(this.idEleicaoSelecionada == null){
            this.eleicoesForVote = this.getRMI().getEleicaoForPessoa(votante.getTipo_id(),votante.getDep_id());
            this.session.put("eleicoesForVote", eleicoesForVote);
            return ERROR;
        }
        if(this.getRMI().getJa_Votou_Eleicao(votante.getCc_number(), Integer.parseInt(idEleicaoSelecionada)) > 0){
            this.eleicoesForVote = this.getRMI().getEleicaoForPessoa(votante.getTipo_id(),votante.getDep_id());
            this.session.put("eleicoesForVote", eleicoesForVote);
            return ERROR;
        }
        this.eleicao = this.getRMI().getEleicaoById(Integer.parseInt(idEleicaoSelecionada));
        this.session.put("eleicao", eleicao);
        this.listasForVote = this.getRMI().getListasForEleicao(eleicao.getId(), eleicao.getTipo_id());
        Lista branco = new Lista("Voto Branco", eleicao.getTipo_id(), eleicao.getId());
        Lista nulo = new Lista("Voto Nulo", eleicao.getTipo_id(), eleicao.getId());
        this.listasForVote.add(branco);
        this.listasForVote.add(nulo);
        this.session.put("listasForVote", listasForVote);
        return SUCCESS;
    }

    public String registarVoto()throws RemoteException, SQLException{
        if(idListaVotada == null){
            return ERROR;
        }
        eleicao = (Eleicao)session.get("eleicao");
        votante = (Pessoa)session.get("votante");
        Timestamp data = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.getRMI().registarVoto(idListaVotada, "WebServer", data, eleicao.getId(), votante.getCc_number());
        return SUCCESS;
    }

    public void setUsername(String username) {
        this.username = username; // will you sanitize this input? maybe use a prepared statement?
    }

    public void setPassword(String password) {
        this.password = password; // what about this input?
    }

    public rmiBean getRMI() {
        if(!session.containsKey("rmiBean"))
            this.setRMI(new rmiBean());
        return (rmiBean) session.get("rmiBean");
    }

    public void setVotante(Pessoa votante) {
        this.session.put("votante", votante);
    }

    public void setRMI(rmiBean loginVotante) {
        this.session.put("rmiBean", loginVotante);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Pessoa getVotante() {
        return votante;
    }

    public ArrayList<Eleicao> getEleicoesForVote() {
        return eleicoesForVote;
    }

    public void setEleicoesForVote(ArrayList<Eleicao> eleicoesForVote) {
        this.eleicoesForVote = eleicoesForVote;
    }

    public String getIdEleicaoSelecionada() {
        return idEleicaoSelecionada;
    }

    public void setIdEleicaoSelecionada(String idEleicaoSelecionada) {
        this.idEleicaoSelecionada = idEleicaoSelecionada;
    }

    public ArrayList<Lista> getListasForVote() {
        return listasForVote;
    }

    public void setListasForVote(ArrayList<Lista> listasForVote) {
        this.listasForVote = listasForVote;
    }

    public String getIdListaVotada() {
        return idListaVotada;
    }

    public void setIdListaVotada(String idListaVotada) {
        this.idListaVotada = idListaVotada;
    }

    public Eleicao getEleicao() {
        return eleicao;
    }

    public void setEleicao(Eleicao eleicao) {
        this.eleicao = eleicao;
    }

}
