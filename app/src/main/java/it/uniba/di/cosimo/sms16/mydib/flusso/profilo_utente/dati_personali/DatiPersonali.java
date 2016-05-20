package it.uniba.di.cosimo.sms16.mydib.flusso.profilo_utente.dati_personali;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.template.OptionBarActivity;

public class DatiPersonali extends OptionBarActivity {

    private Toolbar toolbar;
    TextView txtVotoLaureaDati,txtMediaAritmeticaDati,txtMediaPonderataDati,
            txtAAInCorsoDati,txtAAIscrizioneDati,txtEmailDati,txtMatricolaDati,
            txtCognomeDati,txtNomeDati;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dati_personali);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Profilo");
        setSupportActionBar(toolbar);

        txtAAInCorsoDati = (TextView) findViewById(R.id.txtAAInCorsoDati);
        txtAAIscrizioneDati = (TextView) findViewById(R.id.txtAAIscrizioneDati);
        txtCognomeDati = (TextView) findViewById(R.id.txtCognomeDati);
        txtEmailDati = (TextView) findViewById(R.id.txtEmailDati);
        txtMatricolaDati = (TextView) findViewById(R.id.txtMatricolaDati);
        txtMediaAritmeticaDati = (TextView) findViewById(R.id.txtMediaAritmeticaDati);
        txtMediaPonderataDati = (TextView) findViewById(R.id.txtMediaPonderataDati);
        txtNomeDati = (TextView) findViewById(R.id.txtNomeDati);
        txtVotoLaureaDati = (TextView) findViewById(R.id.txtVotoLaureaDati);

        /* QUI LI DEVO PRENDERE DAL DATABASE
        Prima verifico se il DB li ha avvalorati,altrimenti chiamo il server
        txtAAInCorsoDati.setText("");
        txtAAIscrizioneDati.setText("");
        txtCognomeDati.setText("");
        txtEmailDati.setText("");
        txtMatricolaDati.setText("");
        txtMediaAritmeticaDati.setText("");
        txtMediaPonderataDati.setText("");
        txtNomeDati.setText("");
        txtVotoLaureaDati.setText("");
        */
     }
}
