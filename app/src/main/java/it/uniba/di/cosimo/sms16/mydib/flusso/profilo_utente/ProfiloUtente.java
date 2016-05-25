package it.uniba.di.cosimo.sms16.mydib.flusso.profilo_utente;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.flusso.profilo_utente.dati_personali.DatiPersonali;
import it.uniba.di.cosimo.sms16.mydib.flusso.ricerca_utenti.RicercaUtenti;
import it.uniba.di.cosimo.sms16.mydib.template.OptionBarActivity;
// sul branch alle 10.35
public class ProfiloUtente extends OptionBarActivity {

    private Toolbar toolbar;
    Button libretto,shareAppunti,datiPersonali;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo_utente);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Profilo");
        setSupportActionBar(toolbar);

        libretto = (Button) findViewById(R.id.btnLibrettoProfilo);
        shareAppunti = (Button) findViewById(R.id.btnShareAppuntiProfilo);
        datiPersonali = (Button) findViewById(R.id.btnDatiPersonaliProfilo);

        libretto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        shareAppunti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        datiPersonali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DatiPersonali.class);
                startActivity(intent);
            }
        });


    }
}
