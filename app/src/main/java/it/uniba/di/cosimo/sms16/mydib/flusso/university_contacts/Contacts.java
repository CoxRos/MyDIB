package it.uniba.di.cosimo.sms16.mydib.flusso.university_contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.entity.uni_contacts.E_Contacts;
import it.uniba.di.cosimo.sms16.mydib.system.GestioneSessione;
import it.uniba.di.cosimo.sms16.mydib.template.OptionBarActivity;

public class Contacts extends OptionBarActivity {

    private ListView contacts;
    private TextView email,phone;
    private Intent emailIntent;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uni_contacts);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("plain/text");

        contacts = (ListView) findViewById(R.id.listUniContacts);
        email = (TextView) findViewById(R.id.textEmail);
        phone = (TextView) findViewById(R.id.textPhone);

        contacts = (ListView) findViewById(R.id.listUniContacts);
        ContacsAdapter listAdapter = new ContacsAdapter(getApplicationContext(),R.layout.list_contact_detail);
        contacts.setAdapter(listAdapter);

        for(E_Contacts value : GestioneSessione.getContacts()) {
            listAdapter.add(value);
        }

        //Con il click sulla lista sto andando a inviare l'email corrispondente
        contacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                E_Contacts contact = GestioneSessione.getContacts().get(position);
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{contact.getEmail()});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "INFORMAZIONI");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(emailIntent, "Email to: " + contact.getTitolo()));
            }
        });

    }
}
