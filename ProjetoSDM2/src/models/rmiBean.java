package models;

import Data.*;
import RMI_Server.Server_Instance;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class rmiBean {
	private Server_Instance server;

	public rmiBean() {

		//Mudar esta linha para um path que o TomCat reconheca o policy
		//System.getProperties().put("java.security.policy", "C:\\Users\\zedir\\policy.all");
		//System.getProperties().put("java.security.policy", "C:\\Users\\Pedro Tiago\\policy.all");
		System.getProperties().put("java.security.policy", "C:\\Users\\GL504\\policy.all");
		System.setSecurityManager(new RMISecurityManager());

		/*
		Policy allPermissionPolicy = new Policy(){
			@Override
			public boolean implies(ProtectionDomain domain, Permission permission){
				return true;
			}

		};

		Policy.getPolicy();
		Policy.setPolicy(allPermissionPolicy);
		System.setSecurityManager(new SecurityManager());
		 */

		try {
			server = (Server_Instance) Naming.lookup("//rmi.sd:7000/XPTO");
		}
		catch(NotBoundException|MalformedURLException|RemoteException e) {
			e.printStackTrace();
		}
	}

	public Pessoa getUserMatchesPassword(String username, String password) throws RemoteException, SQLException {
		return server.getPessoaByLogin(username, password);
	}

	public void insertUser(Pessoa pessoa) throws RemoteException, SQLException {
		server.insertUser(pessoa);
	}

	public void createElection(Eleicao election) throws RemoteException, SQLException {
		server.createElection(election);
	}

	public ArrayList<String> getDep() throws RemoteException, SQLException {
		return server.getDep();
	}

	public ArrayList<Eleicao> getEleicao() throws RemoteException, SQLException {
		return server.getEleicao();
	}

	public void printOnServer(String cena) throws RemoteException, SQLException {
		server.print_on_server(cena);
	}

	public Eleicao getEleicaoById(int idEleicao) throws RemoteException, SQLException {
		return server.getEleicaoById(idEleicao);
	}

	public void editEleicao(Eleicao eleicao) throws RemoteException, SQLException {
		server.updateTituloEleicao(eleicao);
		server.updateDescricaoEleicao(eleicao);
		server.updateInicioEleicao(eleicao);
		server.updateFimEleicao(eleicao);
	}

	public ArrayList<Pessoa> getPessoas_NOME_CC_ELEICAO(int tipo, int id_eleicao) throws RemoteException, SQLException {
		return server.getPessoas_NOME_CC_ELEICAO(tipo, id_eleicao);
	}

	public long createList(Lista lista) throws RemoteException, SQLException {
		return server.createList(lista);
	}

	public void createLista_Pessoa(Lista_Pessoa lista_pessoa)throws RemoteException, SQLException {
		server.createLista_Pessoa(lista_pessoa);
	}

	public String getTipoPorId(int id) throws RemoteException, SQLException{
		return server.getTipoPorId(id);
	}
	public String getDepPorId(int id) throws RemoteException, SQLException{
		return server.getDepPorId(id);
	}

	public ArrayList<Lista> getFullListasByElection(int election_id) throws RemoteException, SQLException{
		return server.getFullListasByElection(election_id);
	}

	public ArrayList<Eleicao> getEleicaoPassada() throws RemoteException, SQLException{
		return server.getEleicaoPassada();
	}

	public ArrayList<Eleicao> getEleicaoForPessoa(int tipo_id, int dep_id) throws RemoteException, SQLException {
		return server.getEleicaoForPessoa(tipo_id, dep_id);
	}

	public ArrayList<Lista> getListasForEleicao(int election_id, int tipo_id) throws RemoteException, SQLException {
		return server.getListasForEleicao(election_id, tipo_id);
	}

	public void registarVoto(String lista, String mesa_voto, Timestamp data, int idEleicao, int cc)throws RemoteException, SQLException {
		server.registarVoto(lista, mesa_voto, data, idEleicao, cc);
	}

	public int getJa_Votou_Eleicao(int ccNumber, int id_eleicao) throws RemoteException, SQLException{
		return server.getJa_Votou_Eleicao(ccNumber, id_eleicao);
	}

	public ArrayList<Eleicao> getAllEleicao() throws RemoteException, SQLException{
		return server.getAllEleicao();
	}

	public ArrayList<Lista_Votantes> getVotantesByElection(int electionId) throws RemoteException, SQLException{
		return server.getVotantesByElection(electionId);
	}
}
