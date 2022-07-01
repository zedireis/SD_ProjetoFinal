package actions;

import Data.*;
import com.opensymphony.xwork2.ActionSupport;
import models.rmiBean;
import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Performs a search in the backend for a specific product and displays the result to the user
 */
public class gerirEleicoesAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private Eleicao eleicao = null;
    private Integer idEleicao = null;

    // Submit Editar Eleicao
    private String titulo = null;
    private String descricao = null;
    private String dataInicio = null;
    private String dataFim = null;

    // Submit Lista Eleicao
    private List<String> ccMembros = null;
    private String nomeLista = null;

    // Ver Estatistica Eleicao
    private String tipo;
    private String dep;
    private ArrayList<Lista> listaList;
    private long total_votos;
    private long votos_branco;
    private long votos_nulos;
    private String votos_branco_percent;
    private String votos_nulos_percent;

    // Saber em que local votou cada eleitor
    private ArrayList<Lista_Votantes> listaVotantes;

    @Override
    public String execute() throws RemoteException, SQLException {
        this.getRMI().printOnServer("execute");
        return SUCCESS;
    }

    public String selecionar() throws RemoteException, SQLException {
        this.eleicao = this.getRMI().getEleicaoById(idEleicao);
        session.put("idEleicao", idEleicao);
        session.put("eleicao", eleicao);
        this.getRMI().printOnServer("selecionar: Id-" + this.eleicao.getId() +" Titulo-" + this.eleicao.getTitulo());
        return SUCCESS;
    }

    public String gerirCandidatura() throws RemoteException, SQLException{
        if((ccMembros==null) || (nomeLista==null) || (nomeLista=="")){
            return ERROR;
        }

        long id_lista;
        this.getRMI().printOnServer("gerirCandidatura");
        // Adicionar pessoas à lista
        this.eleicao = (Eleicao) session.get("eleicao");
        // Nota: só se pode adicionar pessoas à lista que não façam parte de outra

        if(ccMembros.size() == 0) {
            System.out.println("Não selecionou nenhum membro!");
            return ERROR;
        }

        Lista devolve = new Lista(nomeLista, eleicao.getTipo_id(), eleicao.getId());
        id_lista = this.getRMI().createList(devolve);

        for(String i: ccMembros){
            Lista_Pessoa temp = new Lista_Pessoa((int)id_lista, Integer.parseInt(i));
            this.getRMI().createLista_Pessoa(temp);
        }

        return SUCCESS;
    }

    public String editar() throws RemoteException, SQLException {
        this.eleicao = (Eleicao) session.get("eleicao");
        this.getRMI().printOnServer("editar: Id-" + this.eleicao.getId() +" Titulo-" + this.eleicao.getTitulo());
        return SUCCESS;
    }

    public String editarSubmit() throws RemoteException, SQLException {
        this.eleicao = (Eleicao) session.get("eleicao");
        this.getRMI().printOnServer("editarSubmit: Id-" + this.eleicao.getId() +" Titulo-" + this.eleicao.getTitulo());
        try{
            if(titulo != null && titulo!=""){
                eleicao.setTitulo(titulo);
            }
            if(descricao != null && descricao!=""){
                eleicao.setDescricao(descricao);
            }
            if(dataInicio != null && dataInicio!="" && dataFim != null && dataFim!="") {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
                Date parsedDate = dateFormat.parse(dataInicio);
                Timestamp timestampInicio = new java.sql.Timestamp(parsedDate.getTime());

                parsedDate = dateFormat.parse(dataFim);
                Timestamp timestampFim = new java.sql.Timestamp(parsedDate.getTime());

                Calendar cal = Calendar.getInstance();
                cal.setTime(timestampInicio);
                cal.add(Calendar.HOUR, 1);
                timestampInicio = new Timestamp(cal.getTime().getTime());

                cal.setTime(timestampFim);
                cal.add(Calendar.HOUR, 1);
                timestampFim = new Timestamp(cal.getTime().getTime());

                if (timestampFim.after(timestampInicio)) {
                    eleicao.setData_inicio(timestampInicio);
                    eleicao.setData_fim(timestampFim);
                }
            }
            this.getRMI().editEleicao(eleicao);
            session.put("eleicao", eleicao);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public boolean validarInput(){
        if((eleicao != null)){
            // Fazer mais verificacoes
            return true;
        }
        return false;
    }

    public String statsEleicao() throws RemoteException, SQLException{
        this.eleicao = this.getRMI().getEleicaoById(idEleicao);
        try{
            this.tipo = this.getRMI().getTipoPorId(this.eleicao.getTipo_id());
            this.dep = this.getRMI().getDepPorId(this.eleicao.getDep_id());
            this.listaList = this.getRMI().getFullListasByElection(this.eleicao.getId()); // Lista de listas

            this.total_votos = this.eleicao.getTotal_votos();
            this.votos_branco = this.eleicao.getVotos_branco();
            this.votos_nulos = this.eleicao.getVotos_nulos();

            this.votos_branco_percent = String.format("%.2f", ((double)this.votos_branco/(double)this.total_votos)*100);
            this.votos_nulos_percent = String.format("%.2f", ((double)this.votos_nulos/(double)this.total_votos)*100);

            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String saberLocal()throws RemoteException, SQLException {
        this.eleicao = this.getRMI().getEleicaoById(idEleicao);
        try{
            this.tipo = this.getRMI().getTipoPorId(this.eleicao.getTipo_id());
            this.dep = this.getRMI().getDepPorId(this.eleicao.getDep_id());

            this.listaVotantes = this.getRMI().getVotantesByElection(this.eleicao.getId());

            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public rmiBean getRMI() {
        if(!session.containsKey("rmiBean"))
            this.setRMI(new rmiBean());
        return (rmiBean) session.get("rmiBean");
    }

    public void setRMI(rmiBean RMI) {
        this.session.put("rmiBean", RMI);
    }

    public void setEleicao(Eleicao eleicao) {
        this.eleicao = eleicao;
    }

    public Eleicao getEleicao() {
        return eleicao;
    }

    public int getIdEleicao() {
        return idEleicao;
    }

    public void setIdEleicao(int idEleicao) {
        this.idEleicao = idEleicao;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public void setIdEleicao(Integer idEleicao) {
        this.idEleicao = idEleicao;
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

    public void setCcMembros(List<String> ccMembros) {
        this.ccMembros = ccMembros;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public ArrayList<Lista> getListaList() {
        return listaList;
    }

    public void setListaList(ArrayList<Lista> listaList) {
        this.listaList = listaList;
    }

    public long getTotal_votos() {
        return total_votos;
    }

    public void setTotal_votos(long total_votos) {
        this.total_votos = total_votos;
    }

    public long getVotos_branco() {
        return votos_branco;
    }

    public void setVotos_branco(long votos_branco) {
        this.votos_branco = votos_branco;
    }

    public long getVotos_nulos() {
        return votos_nulos;
    }

    public void setVotos_nulos(long votos_nulos) {
        this.votos_nulos = votos_nulos;
    }

    public String getVotos_branco_percent() {
        return votos_branco_percent;
    }

    public void setVotos_branco_percent(String votos_branco_percent) {
        this.votos_branco_percent = votos_branco_percent;
    }
    public String getVotos_nulos_percent() {
        return votos_nulos_percent;
    }

    public void setVotos_nulos_percent(String votos_nulos_percent) {
        this.votos_nulos_percent = votos_nulos_percent;
    }

    public ArrayList<Lista_Votantes> getListaVotantes() {
        return listaVotantes;
    }

    public void setListaVotantes(ArrayList<Lista_Votantes> listaVotantes) {
        this.listaVotantes = listaVotantes;
    }
}
