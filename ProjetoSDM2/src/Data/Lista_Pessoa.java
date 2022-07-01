package Data;

import java.io.Serializable;

public class Lista_Pessoa implements Serializable {
    private int lista_id;
    private int pessoa_cc_number;

    public Lista_Pessoa(int lista_id, int pessoa_cc_number) {
        this.lista_id = lista_id;
        this.pessoa_cc_number = pessoa_cc_number;
    }

    public int getLista_id() {
        return lista_id;
    }

    public void setLista_id(int lista_id) {
        this.lista_id = lista_id;
    }

    public int getPessoa_cc_number() {
        return pessoa_cc_number;
    }

    public void setPessoa_cc_number(int pessoa_cc_number) {
        this.pessoa_cc_number = pessoa_cc_number;
    }
}
