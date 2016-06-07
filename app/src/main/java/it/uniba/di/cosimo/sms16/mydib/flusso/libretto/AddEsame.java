package it.uniba.di.cosimo.sms16.mydib.flusso.libretto;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import it.uniba.di.cosimo.sms16.mydib.DAO.DAOLibretto;
import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.template.OptionBarActivity;

/**
 * Created by sergiocorvino on 06/06/16.
 */
public class AddEsame extends OptionBarActivity {

    private Toolbar toolbar;
    private EditText edtEsame, edtVoto, edtCfu;
    private EditText edtData;
    private Button btnSalva;

    private final int DATE_DIALOG_ID = 0;
    private DAOLibretto db;

    private int year;
    private int month;
    private int day;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_esame);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new DAOLibretto(this);

        //prendo la data corrente
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        edtEsame = (EditText) findViewById(R.id.edtEsame);
        edtVoto = (EditText) findViewById(R.id.edtVoto);
        edtCfu = (EditText) findViewById(R.id.edtCFU);
        edtData = (EditText) findViewById(R.id.edtData);
        btnSalva = (Button) findViewById(R.id.buttonAggiungi);

        edtEsame.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //vuoto
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                enableButton();
            }

            @Override
            public void afterTextChanged(Editable s) {
                //vuoto
            }
        });

        edtVoto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                enableButton();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtCfu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                enableButton();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                enableButton();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        btnSalva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String materia = edtEsame.getText().toString();
                String cfu = edtCfu.getText().toString();
                String voto = edtVoto.getText().toString();
                String data = edtData.getText().toString();

                boolean isInserted = db.insertEsame(materia, cfu, voto, data);

                if(isInserted) {
                    Toast.makeText(getApplicationContext(), "Dati inseriti con successo", Toast.LENGTH_LONG).show();
                    //Intent intent = new Intent(getApplicationContext(), Libretto.class);
                    //startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Non è stato possibile inserire i dati", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * Rende cliccabile il bottone solo se non stati avvalorati tutti i campi
     */
    private void enableButton() {
        if(edtEsame.getText().length() > 0 && edtVoto.getText().length() > 0
                && edtCfu.getText().length() > 0 && edtData.getText().length() > 0) {
            btnSalva.setEnabled(true);
        }
        else {
            btnSalva.setEnabled(false);
        }
    }

    /**
     * setta la data dopo la scelta nel dialog
     */
    private void updateDisplay() {
        edtData.setText(new StringBuilder()
                        // Mese inizia da 0 quindi aggiungo 1
                        .append(month + 1).append("-")
                        .append(day).append("-")
                        .append(year).append(" "));
    }

    /**
     * Setta il listener del dialog del dataPicker
     */
    private DatePickerDialog.OnDateSetListener dataListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int years, int monthOfYear, int dayOfMonth) {
            year = years;
            month = monthOfYear;
            day = dayOfMonth;
            updateDisplay();
        }
    };

    /**
     * Crea il dialog
     * @param id
     *      l'id del dialog
     * @return
     *      il nuovo dialog
     */
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, dataListener, year, month, day);
        }
        return null;
    }
}
