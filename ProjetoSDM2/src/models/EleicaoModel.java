package models;

import Data.Eleicao;
import models.interfaces.ProductModel;

import java.sql.Timestamp;

public class EleicaoModel extends Eleicao implements ProductModel {

    public EleicaoModel(Timestamp data_inicio, Timestamp data_fim, String titulo, String descricao, long total_votos, long votos_branco, long votos_nulos, int tipo_id, int dep_id) {
        super(data_inicio, data_fim, titulo, descricao, total_votos, votos_branco, votos_nulos, tipo_id, dep_id);
    }

    public EleicaoModel(){this(null, null, "", "", 0,0,0,0,0);};
}
