package Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Eleicao implements Serializable {

    private Timestamp data_inicio;
    private Timestamp data_fim;
    private String titulo;
    private String descricao;
    private long total_votos;
    private long votos_branco;
    private long votos_nulos;
    private int tipo_id;
    private int dep_id;
    private int id;

    public Eleicao(Timestamp data_inicio, Timestamp data_fim, String titulo, String descricao, long total_votos, long votos_branco, long votos_nulos, int tipo_id, int dep_id){
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo_id = tipo_id;
        this.dep_id = dep_id;
        this.total_votos = total_votos;
        this.votos_branco = votos_branco;
        this.votos_nulos = votos_nulos;
    }

    public Eleicao(Timestamp data_inicio, Timestamp data_fim, String titulo, String descricao,int tipo_id, int dep_id) {
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo_id = tipo_id;
        this.dep_id = dep_id;
        this.total_votos=0;
        this.votos_branco=0;
        this.votos_nulos=0;
    }

    public Eleicao(Timestamp data_inicio, Timestamp data_fim, String titulo, String descricao, long total_votos, long votos_branco, long votos_nulos, int tipo_id, int dep_id, int id){
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipo_id = tipo_id;
        this.dep_id = dep_id;
        this.total_votos = total_votos;
        this.votos_branco = votos_branco;
        this.votos_nulos = votos_nulos;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(int tipo_id) {
        this.tipo_id = tipo_id;
    }

    public Timestamp getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Timestamp data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Timestamp getData_fim() {
        return data_fim;
    }

    public void setData_fim(Timestamp data_fim) {
        this.data_fim = data_fim;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }
}
