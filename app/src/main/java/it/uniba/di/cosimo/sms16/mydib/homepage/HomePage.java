
package it.uniba.di.cosimo.sms16.mydib.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.flusso.profilo_utente.ProfiloUtente;
import it.uniba.di.cosimo.sms16.mydib.flusso.ricerca_utenti.RicercaUtenti;
import it.uniba.di.cosimo.sms16.mydib.template.OptionBarActivity;

public class HomePage extends OptionBarActivity {

    private Button btnNews, btnCondividi, btnRicerca, btnProfilo;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("HomePage");
        setSupportActionBar(toolbar);

        //catturo gli id dei button
        btnNews = (Button)findViewById(R.id.btnNewsLogged);
        btnCondividi = (Button)findViewById(R.id.btnCondividi);
        btnRicerca = (Button)findViewById(R.id.btnRicerca);
        btnProfilo = (Button)findViewById(R.id.btnProfilo);

        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BUTTON", "cliccato newsLogged");
            }
        });

        btnCondividi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BUTTON", "cliccato condividi");
            }
        });

        btnRicerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RicercaUtenti.class);
                startActivity(intent);
            }
        });

        btnProfilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfiloUtente.class);
                startActivity(intent);
            }
        });
    }
}


