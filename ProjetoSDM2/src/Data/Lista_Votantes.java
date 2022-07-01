package Data;


import java.io.Serializable;
import java.sql.Timestamp;

public class Lista_Votantes implements Serializable {
    private String nome;
    private String mesaVoto;
    private Timestamp momento;

    public Lista_Votantes(String nome, String mesaVoto, Timestamp momento) {
        this.nome = nome;
        this.mesaVoto = mesaVoto;
        this.momento = momento;
    }

    public String getNome() {
        return nome;
    }

    public String getMesaVoto() {
        return mesaVoto;
    }

    public Timestamp getMomento() {
        return momento;
    }
}
