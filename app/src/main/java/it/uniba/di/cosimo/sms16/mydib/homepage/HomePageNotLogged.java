package it.uniba.di.cosimo.sms16.mydib.homepage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.entity.uni_contacts.E_Contacts;
import it.uniba.di.cosimo.sms16.mydib.flusso.university_contacts.Contacts;
import it.uniba.di.cosimo.sms16.mydib.system.GestioneSessione;

public class HomePageNotLogged extends AppCompatActivity {

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

        // Da togliere
        GestioneSessione.contacts.add(new E_Contacts("Ministro", "E' la descrizione del ministro", "ministro@gmail.com", "0805392468"));
        GestioneSessione.contacts.add(new E_Contacts("Deputato","E' la descrizione del deputato","deputato@gmail.com","0805392468"));
        //------------

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_info) {
            Log.d("HOME", "hai cliccato le info");
        } else if(id == R.id.action_login) {
            //deve essere aperto il popup..
            //solo di prova
            Intent intent = new Intent(getApplicationContext(), HomePage.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
