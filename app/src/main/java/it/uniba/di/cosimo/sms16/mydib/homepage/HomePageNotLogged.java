package it.uniba.di.cosimo.sms16.mydib.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import it.uniba.di.cosimo.sms16.mydib.R;

import it.uniba.di.cosimo.sms16.mydib.flusso.libretto.AddEsame;
import it.uniba.di.cosimo.sms16.mydib.flusso.profilo_utente.ProfiloUtente;


import it.uniba.di.cosimo.sms16.mydib.flusso.ricerca_utenti.RicercaUtenti;
import it.uniba.di.cosimo.sms16.mydib.flusso.university_contacts.Contacts;
import it.uniba.di.cosimo.sms16.mydib.template.OptionBarActivity;
import it.uniba.di.cosimo.sms16.mydib.flusso.info_university.Info;
/*
    Libretto-C 16.00
 */
public class HomePageNotLogged extends OptionBarActivity {

    private Toolbar toolbar;
    private Button btnInfo, btnNews, btnContatti, btnSvago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_not_logged);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("HomePage");
        setSupportActionBar(toolbar);

        //catturo gli id dei button
        btnInfo = (Button)findViewById(R.id.btnInfo);
        btnNews = (Button)findViewById(R.id.btnNews);
        btnContatti = (Button)findViewById(R.id.btnContatti);
        btnSvago = (Button)findViewById(R.id.btnSvago);


        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Info.class);
                startActivity(intent);
            }
        });

        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //FIX ME
                Intent intent = new Intent(getApplicationContext(), ProfiloUtente.class);

                startActivity(intent);
            }
        });

        btnContatti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Contacts.class);
                startActivity(intent);
            }
        });

        btnSvago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //FIX ME
                /*
                Intent intent = new Intent(getApplicationContext(), ProfiloDirigente.class);
                intent.putExtra("idDirigente",1);
                startActivity(intent);
                */
                Intent intent = new Intent(getApplicationContext(),AddEsame.class);
                startActivity(intent);

            }
        });

    }
}
