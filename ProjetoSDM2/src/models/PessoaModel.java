package models;

import Data.Pessoa;
import models.interfaces.ProductModel;

public class PessoaModel extends Pessoa implements ProductModel {

    public PessoaModel(int cc_number, String nome) {
        super(cc_number, nome);
    }

    public PessoaModel(){this(0, "");};

}
