package it.uniba.di.cosimo.sms16.mydib.flusso.ricerca_utenti;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
//import com.android.volley.toolbox.CustomRequestArray;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.entity.uni_search.UserSearched;
import it.uniba.di.cosimo.sms16.mydib.network.CustomRequestArray;
import it.uniba.di.cosimo.sms16.mydib.network.Network;

/*
ho la lista di Nome - Cognome - Tipo.
    Se ci clicco sopra, se è un professore mi manda alla schermata del professore, altrimenti direttamente alla mail alla
    persona interessata
 */
public class RicercaUtenti extends AppCompatActivity {

    RequestQueue queue;
    ProgressDialog progressDialog;

    Intent emailIntent;
    ListView utentiSearched;
    RadioGroup radioGroup;
    EditText nominativo;
    ImageButton btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uni_ricerca);

        queue = Network.getInstance(getApplicationContext()).
                getRequestQueue();

        utentiSearched = (ListView) findViewById(R.id.listSearch);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        nominativo = (EditText) findViewById(R.id.editNominativo);
        btnSearch = (ImageButton) findViewById(R.id.btnSearch);

        nominativo.setSelection(0);

        emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("plain/text");

        progressDialog = new ProgressDialog(this);



        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RicercaUtentiAdapter listAdapter = new RicercaUtentiAdapter(getApplicationContext(), R.layout.layout_list_ricerca);
                utentiSearched.setAdapter(listAdapter);
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
                    //Sergio:192.168.30.162 - Cosimo:http://192.168.30.119

                    CustomRequestArray request = new CustomRequestArray
                            (Request.Method.POST, "http://192.168.30.162/POST_MYDIB.php", null, new Response.Listener<JSONArray>() {
                                @Override
                                public void onResponse(JSONArray response) {
                                    String id, nome, cognome, tipo, email;
                                    for (int i = 0; i < response.length(); i++) {
                                        try {
                                            JSONObject oggettoJson = response.getJSONObject(i);
                                            id = oggettoJson.getString("id");
                                            nome = oggettoJson.getString("nome");
                                            cognome = oggettoJson.getString("cognome");
                                            tipo = oggettoJson.getString("tipo");
                                            email = oggettoJson.getString("email");
                                            listAdapter.add(new UserSearched(id, nome, cognome, tipo, email));
                                        } catch (Exception e) {
                                            System.out.println("catch");
                                        }
                                    }
                                    progressDialog.dismiss();

                                }
                            },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            System.out.println("ERR: " + error.getMessage());
                                            progressDialog.dismiss();
                                        }
                                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("action", "ricercaUtenti");
                            return params;
                        }
                    };
                    Network.getInstance(getApplicationContext()).addToRequestQueue(request);
                    progressDialog.setTitle("Attendere");
                    progressDialog.setMessage("Caricamento richiesta");
                    progressDialog.show();

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
