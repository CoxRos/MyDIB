package it.uniba.di.cosimo.sms16.mydib.DAO;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import it.uniba.di.cosimo.sms16.mydib.entity.profilo_utente.Esame;
import it.uniba.di.cosimo.sms16.mydib.system.Costants;

/**
 * Created by sergiocorvino on 01/06/16.
 */
public class DAOLibretto {

    private DatabaseHelper db;

    public  DAOLibretto(Context context) {
        db = new DatabaseHelper(context);
    }

    public List<Esame> getEsami() {
        List<Esame> result = new ArrayList<Esame>();

        Cursor resultSet = db.getAllData(Costants.TABLE_LIBRETTO);

        while (resultSet.moveToNext()) {
            Esame esame = new Esame(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
            result.add(esame);
        }
        return result;
    }

    public boolean insertEsame(String materia, String cfu, String voto, String data) {

        List<Coppia> param = new ArrayList<Coppia>();
        param.add(new Coppia("materia", materia));
        param.add(new Coppia("CFU", cfu));
        param.add(new Coppia("voto", voto));
        param.add(new Coppia("data", data));

        return db.insertData(param, Costants.TABLE_LIBRETTO);
    }

    public boolean updateEsame(String id, String materia, String cfu, String voto, String data) {

        List<Coppia> param = new ArrayList<Coppia>();
        param.add(new Coppia("materia", materia));
        param.add(new Coppia("CFU", cfu));
        param.add(new Coppia("voto", voto));
        param.add(new Coppia("data", data));

        return db.updateData(param, Costants.TABLE_LIBRETTO, Costants.CAMPO_ID, id);
    }

    public boolean deleteEsame(String id) {
        return db.deleteData(Costants.TABLE_LIBRETTO, Costants.CAMPO_ID, id);
    }
}
