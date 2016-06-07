package it.uniba.di.cosimo.sms16.mydib.flusso.university_contacts;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.entity.uni_contacts.E_Contacts;
import it.uniba.di.cosimo.sms16.mydib.network.Network;
import it.uniba.di.cosimo.sms16.mydib.system.GestioneSessione;
import it.uniba.di.cosimo.sms16.mydib.template.OptionBarActivity;

public class Contacts extends OptionBarActivity {

    private ListView contacts;
    private TextView email,phone;
    private Intent emailIntent;
    private Toolbar toolbar;


    RequestQueue queue;
    ContacsAdapter listAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uni_contacts);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        queue = Network.getInstance(getApplicationContext()).
                getRequestQueue();

        emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("plain/text");

        contacts = (ListView) findViewById(R.id.listUniContacts);
        email = (TextView) findViewById(R.id.textEmail);
        phone = (TextView) findViewById(R.id.textPhone);

        contacts = (ListView) findViewById(R.id.listUniContacts);
        listAdapter = new ContacsAdapter(getApplicationContext(),R.layout.list_contact_detail);
        contacts.setAdapter(listAdapter);
        setUI("https://api.myjson.com/bins/4h2z8");

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

    private void setUI(String url) {

        JsonArrayRequest jsObjRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        for(int i= 0; i< response.length(); i++) {
                            try {
                                JSONObject oggettoNota = response.getJSONObject(i);
                                String titolo = oggettoNota.getString("titolo");
                                String descrizione = oggettoNota.getString("descrizione");
                                String email = oggettoNota.getString("email");
                                String telefono = oggettoNota.getString("phone");
                                listAdapter.add(new E_Contacts(titolo,descrizione,email,telefono));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        progressDialog.dismiss();
                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("JSON Errore connessione contatti: " + error.networkResponse);
                        progressDialog.dismiss();

                    }
                });
        Network.getInstance(getApplicationContext()).addToRequestQueue(jsObjRequest);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Attendere");
        progressDialog.setMessage("Caricamento messaggi");
        progressDialog.show();
    }
}
