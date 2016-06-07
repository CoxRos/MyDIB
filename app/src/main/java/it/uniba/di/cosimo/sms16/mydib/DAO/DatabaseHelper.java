package it.uniba.di.cosimo.sms16.mydib.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

import it.uniba.di.cosimo.sms16.mydib.system.Costants;

/**
 * Created by sergiocorvino on 01/06/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "MyDib.db";
    private static String TABLE_LIBRETTO = "libretto";
    private static String TABLE_STUDENTE = "studente"; //creare la tabella

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_LIBRETTO + " (idEsame INTEGER PRIMARY KEY AUTOINCREMENT, materia TEXT, CFU TEXT, voto TEXT, data TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIBRETTO);
        onCreate(db);
    }

    public boolean insertData(List<Coppia> param, String table) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        for(Coppia c : param) {
            contentValues.put(c.getKey(), c.getValue());
        }

        long result = db.insert(table, null, contentValues);

        if(result == -1) {
            return false;
        }
        return true;
    }

    public Cursor getAllData(String table) {
        String query = "SELECT * FROM " + table;
        SQLiteDatabase db = getWritableDatabase();
        Cursor result = db.rawQuery(query, null);
        return result;
    }

    public boolean updateData(List<Coppia> param, String table, String clausolaWhere, String argomento) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        for(Coppia c : param) {
            contentValues.put(c.getKey(), c.getValue());
        }

        int rows = db.update(table, contentValues, clausolaWhere + " = ?", new String[] {argomento});

        if(rows > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteData(String table, String clausolaWhere, String argomento) {
        SQLiteDatabase db = getWritableDatabase();
        int rows = db.delete(table, clausolaWhere + " = ?", new String[] {argomento});

        if(rows > 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
