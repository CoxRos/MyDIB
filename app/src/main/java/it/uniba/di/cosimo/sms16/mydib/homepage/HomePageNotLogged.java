package it.uniba.di.cosimo.sms16.mydib.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.entity.uni_contacts.E_Contacts;
import it.uniba.di.cosimo.sms16.mydib.flusso.profilo_utente.ProfiloUtente;
import it.uniba.di.cosimo.sms16.mydib.flusso.university_contacts.Contacts;
import it.uniba.di.cosimo.sms16.mydib.system.GestioneSessione;
import it.uniba.di.cosimo.sms16.mydib.template.OptionBarActivity;
import it.uniba.di.cosimo.sms16.mydib.entity.uni_search.UserSearched;
import it.uniba.di.cosimo.sms16.mydib.flusso.info_university.Info;
import it.uniba.di.cosimo.sms16.mydib.flusso.ricerca_utenti.RicercaUtenti;

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


        GestioneSessione.userSearched.add(new UserSearched("1", "Tizio", "Caio", "Docente", "tizio@gmail.com"));
        GestioneSessione.userSearched.add(new UserSearched("2","Carlo","Pizzo","Studente","pizzo@gmail.com"));
        GestioneSessione.userSearched.add(new UserSearched("3", "Fluvio", "Travia", "Dirigente", "travia@gmail.com"));
        GestioneSessione.userSearched.add(new UserSearched("4","Parolo","Creta","Docente","creta@gmail.com"));
        GestioneSessione.userSearched.add(new UserSearched("5","Terry","henry","Docente","henry@gmail.com"));
        GestioneSessione.userSearched.add(new UserSearched("6","Tizio","Caio","Docente","tizio@gmail.com"));
        GestioneSessione.userSearched.add(new UserSearched("7","Carlo","Pizzo","Studente","pizzo@gmail.com"));
        GestioneSessione.userSearched.add(new UserSearched("8","Fluvio","Travia","Dirigente","travia@gmail.com"));
        GestioneSessione.userSearched.add(new UserSearched("9","Parolo","Creta","Docente","creta@gmail.com"));
        GestioneSessione.userSearched.add(new UserSearched("10","Terry","henry","Docente","henry@gmail.com"));
        GestioneSessione.userSearched.add(new UserSearched("11","Tizio","Caio","Docente","tizio@gmail.com"));
        GestioneSessione.userSearched.add(new UserSearched("12","Carlo","Pizzo","Studente","pizzo@gmail.com"));
        GestioneSessione.userSearched.add(new UserSearched("13","Fluvio","Travia","Dirigente","travia@gmail.com"));
        GestioneSessione.userSearched.add(new UserSearched("14","Parolo","Creta","Docente","creta@gmail.com"));
        GestioneSessione.userSearched.add(new UserSearched("15","Terry","henry","Docente","henry@gmail.com"));
        //------------

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Info.class);
                startActivity(intent);
            }
        });

        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            public void onClick(View v) {

            }
        });
    }
}
