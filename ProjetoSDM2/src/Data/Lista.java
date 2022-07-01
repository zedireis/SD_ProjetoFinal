package Data;

import java.io.Serializable;

public class Lista implements Serializable {
    private int id;
    private String nome;
    private int tipo_id;
    private long votos;
    private int eleicao_id;

    public Lista(String nome, int tipo_id, int eleicao_id) {
        this.nome = nome;
        this.tipo_id = tipo_id;
        this.votos = 0;
        this.eleicao_id = eleicao_id;
    }

    public Lista(int id, String nome, int votos, int tipo_id, int eleicao_id) {
        this.id = id;
        this.nome = nome;
        this.votos = votos;
        this.tipo_id = tipo_id;
        this.eleicao_id = eleicao_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(int tipo_id) {
        this.tipo_id = tipo_id;
    }

    public long getVotos() {
        return votos;
    }

    public void setVotos(long votos) {
        this.votos = votos;
    }

    public int getEleicao_id() {
        return eleicao_id;
    }

    public void setEleicao_id(int eleicao_id) {
        this.eleicao_id = eleicao_id;
    }
}
