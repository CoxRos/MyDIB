package it.uniba.di.cosimo.sms16.mydib.homepage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.entity.uni_contacts.E_Contacts;
import it.uniba.di.cosimo.sms16.mydib.flusso.ristoro.Ristoro_Maps;
import it.uniba.di.cosimo.sms16.mydib.system.GestioneSessione;

public class HomePage extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Da togliere
        GestioneSessione.contacts.add(new E_Contacts("Ministro", "E' la descrizione del ministro", "ministro@gmail.com", "0805392468"));
        GestioneSessione.contacts.add(new E_Contacts("Deputato","E' la descrizione del deputato","deputato@gmail.com","0805392468"));
        //------------
        //Da spostare nel bottone VAI A CONTATTI
        //Intent intent = new Intent(this, it.uniba.di.cosimo.sms16.mydib.flusso.university_contacts.Contacts.class);
        //startActivity(intent);
        //---------
        //Da spostare nel bottone INFO UNI
        //Intent intent = new Intent(this, Info.class);
        //startActivity(intent);
        //---------
        //Da spostare nel bottone RISTORO
        Intent intent = new Intent(this, Ristoro_Maps.class);
        startActivity(intent);

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
            Log.d("HOME", "vai alla login con popup");
        }
        return super.onOptionsItemSelected(item);
    }
}
