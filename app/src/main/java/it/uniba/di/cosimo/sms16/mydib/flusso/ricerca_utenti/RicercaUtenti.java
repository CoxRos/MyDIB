package it.uniba.di.cosimo.sms16.mydib.flusso.ricerca_utenti;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.ScrollView;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.entity.uni_search.UserSearched;
import it.uniba.di.cosimo.sms16.mydib.system.GestioneSessione;
import it.uniba.di.cosimo.sms16.mydib.template.OptionBarActivity;

/*
ho la lista di Nome - Cognome - Tipo.
    Se ci clicco sopra, se è un professore mi manda alla schermata del professore, altrimenti direttamente alla mail alla
    persona interessata
 */
public class RicercaUtenti extends OptionBarActivity {

    private Intent emailIntent;
    private ListView utentiSearched;
    private RadioGroup radioGroup;
    private EditText nominativo;
    private ImageButton btnSearch;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uni_ricerca);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        utentiSearched = (ListView) findViewById(R.id.listSearch);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        nominativo = (EditText) findViewById(R.id.editNominativo);
        btnSearch = (ImageButton) findViewById(R.id.btnSearch);

        nominativo.setSelection(0);

        emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("plain/text");

        RicercaUtentiAdapter listAdapter = new RicercaUtentiAdapter(getApplicationContext(),R.layout.layout_list_ricerca);
        utentiSearched.setAdapter(listAdapter);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToSearch = nominativo.getText().toString();
                String tipo = "";
                if (radioGroup.getCheckedRadioButtonId() == R.id.radioStudenti) {
                    tipo = "studente";
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.radioPersonale) {
                    tipo = "universita";
                } else {
                    tipo = "tutti";
                }

                if (textToSearch.length() > 0) {
                    //Fai la chiamata al server passandogli il nominativo e il tipo per fare un filtro
                    //--
                    /*
                    for(UserSearched value : DAL SERVER) {
                        listAdapter.add(value);
                    }
                     */
                }

            }
        });

        utentiSearched.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Qui devo vedere. Se quello che ho cliccato è un professore allora
                //lo devo mandare alla pagina del professore altrimenti gli invio la mail -->

                /*
                UserSearched contact = GestioneSessione.getUsersSearched().get(position);
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{contact.getEmail()});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "INFORMAZIONI");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(emailIntent, "Email to: " + contact.getEmail()));
                */
            }
        });
    }
}
