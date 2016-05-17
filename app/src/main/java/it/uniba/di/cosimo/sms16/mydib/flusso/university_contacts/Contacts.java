package it.uniba.di.cosimo.sms16.mydib.flusso.university_contacts;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.entity.uni_contacts.E_Contacts;
import it.uniba.di.cosimo.sms16.mydib.system.GestioneSessione;

public class Contacts extends Activity {

    ListView contacts;
    TextView email,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uni_contacts);

        contacts = (ListView) findViewById(R.id.listUniContacts);
        email = (TextView) findViewById(R.id.textEmail);
        phone = (TextView) findViewById(R.id.textPhone);

        //Devo fare l'onClick sull'email e quindi mandarlo alla mail, stessa cosa per il phone

        contacts = (ListView) findViewById(R.id.listUniContacts);
        ContacsAdapter listAdapter = new ContacsAdapter(getApplicationContext(),R.layout.list_contact_detail);
        contacts.setAdapter(listAdapter);

        for(E_Contacts value : GestioneSessione.getContacts()) {
            listAdapter.add(value);
        }

    }
}
