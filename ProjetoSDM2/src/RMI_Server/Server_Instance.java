package RMI_Server;

import Data.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public interface Server_Instance extends Remote {
	public void print_on_server(String s) throws java.rmi.RemoteException;
	public void insertUser(Pessoa pessoa) throws RemoteException, SQLException;
	public void createElection(Eleicao election) throws RemoteException, SQLException;
	public long createList(Lista lista) throws RemoteException, SQLException;
	public void createLista_Pessoa(Lista_Pessoa lista_pessoa)throws RemoteException, SQLException;
	public ArrayList<String> getDep() throws RemoteException, SQLException;
	public ArrayList<String> getTipo() throws RemoteException, SQLException;
	public ArrayList<Eleicao> getEleicao() throws RemoteException, SQLException;
	public ArrayList<Eleicao> getEleicaoPassada() throws RemoteException, SQLException;
	public ArrayList<Pessoa> getPessoas_NOME_CC_ELEICAO(int tipo, int id_eleicao) throws RemoteException, SQLException;
	public void updateTituloEleicao(Eleicao election) throws RemoteException, SQLException;
	public void updateDescricaoEleicao(Eleicao election) throws RemoteException, SQLException;
	public void updateInicioEleicao(Eleicao election) throws RemoteException, SQLException;
	public void updateFimEleicao(Eleicao election) throws RemoteException, SQLException;
	public int getJa_Votou_Eleicao(int ccNumber, int id_eleicao) throws RemoteException, SQLException;
	public Pessoa getPessoasByCC(int cc) throws RemoteException, SQLException;
	public String getTipoPorId(int id) throws RemoteException, SQLException;
	public String getDepPorId(int id) throws RemoteException, SQLException;
	public ArrayList<Eleicao> getEleicaoForPessoa(int tipo_id, int dep_id) throws RemoteException, SQLException;
	public ArrayList<Lista> getListasForEleicao(int election_id, int tipo_id) throws RemoteException, SQLException;
	public ArrayList<Lista> getFullListasByElection(int election_id) throws RemoteException, SQLException;
	public void registarVoto(String lista, String mesa_voto, Timestamp data, int idEleicao, int cc)throws RemoteException, SQLException;
	public Pessoa getPessoaByLogin(String username, String password) throws RemoteException, SQLException;
	public ArrayList<Lista_Votantes> getVotantesByElection(int electionId) throws RemoteException, SQLException;
	public ArrayList<Eleicao> getAllEleicao() throws RemoteException, SQLException;
	public Eleicao getEleicaoById(int idEleicao) throws RemoteException, SQLException;
}
