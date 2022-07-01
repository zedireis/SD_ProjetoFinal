package Data;


import java.io.Serializable;
import java.sql.Date;

public class Pessoa implements Serializable {
    private String username;
    private String password;
    private String nome;
    private int tipo_id;
    private String morada;
    private String telefone;
    private int cc_number;
    private Date validade_cc;
    private int dep_id;

    public Pessoa(String username, String password, String nome, int tipo_id, String morada, String telefone, int cc_number, Date validade_cc, int dep_id) {
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.tipo_id = tipo_id;
        this.morada = morada;
        this.telefone = telefone;
        this.cc_number = cc_number;
        this.validade_cc = validade_cc;
        this.dep_id = dep_id;
    }

    public Pessoa(int cc_number, String nome) {
        this.nome = nome;
        this.cc_number = cc_number;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNome() {
        return nome;
    }

    public int getTipo_id() {
        return tipo_id;
    }

    public String getMorada() {
        return morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getCc_number() {
        return cc_number;
    }

    public Date getValidade_cc() {
        return validade_cc;
    }

    public int getDep_id() {
        return dep_id;
    }
}
