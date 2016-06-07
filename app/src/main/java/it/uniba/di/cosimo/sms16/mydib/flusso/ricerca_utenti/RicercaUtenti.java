package it.uniba.di.cosimo.sms16.mydib.flusso.ricerca_utenti;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.entity.uni_search.UserSearched;
import it.uniba.di.cosimo.sms16.mydib.network.Network;

public class RicercaUtenti extends AppCompatActivity {

    RequestQueue queue;
    ProgressDialog progressDialog;

    ListView utentiSearched;
    RadioGroup radioGroup;
    RadioButton radioStudente,radioUni;
    EditText nominativo;
    ImageButton btnSearch;

    public final int RADIOTUTTI = 0;
    public final int RADIOSTUDENTE = 1;
    public final int RADIODIRIGENTE = 2;

    RicercaUtentiAdapter listAdapter;

    int radioValue = 0;

    ArrayList<CoupleSearch> indiciRicerca;

    String radioType = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uni_ricerca);

        queue = Network.getInstance(getApplicationContext()).
                getRequestQueue();

        indiciRicerca = new ArrayList<CoupleSearch>();

        utentiSearched = (ListView) findViewById(R.id.listSearch);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioStudente = (RadioButton) findViewById(R.id.radioStudenti);
        radioUni = (RadioButton) findViewById(R.id.radioPersonale);
        nominativo = (EditText) findViewById(R.id.editNominativo);
        btnSearch = (ImageButton) findViewById(R.id.btnSearch);

        nominativo.setSelection(0);

        progressDialog = new ProgressDialog(this);

        listAdapter = new RicercaUtentiAdapter(getApplicationContext(),RicercaUtenti.this, R.layout.layout_list_ricerca);
        utentiSearched.setAdapter(listAdapter);

        radioStudente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioValue == RADIOSTUDENTE) {
                    radioGroup.clearCheck();
                    radioValue = RADIOTUTTI;
                } else {
                    radioValue = RADIOSTUDENTE;
                }
            }
        });

        radioUni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioValue == RADIODIRIGENTE) {
                    radioGroup.clearCheck();
                    radioValue = RADIOTUTTI;
                } else {
                    radioValue = RADIODIRIGENTE;
                }
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listAdapter.clear();

                String textToSearch = nominativo.getText().toString();
                if (radioGroup.getCheckedRadioButtonId() == R.id.radioStudenti) {
                    radioType = "Studente";
                } else if (radioGroup.getCheckedRadioButtonId() == R.id.radioPersonale) {
                    radioType = "Dirigente";
                } else {
                    radioType = "tutti";
                }

                if (textToSearch.length() > 0) {
                    JsonArrayRequest request = new JsonArrayRequest
                            (Request.Method.GET, "http://192.168.30.185/uni/MyDIB_Server/api/searchUtente/"+radioType + "/" + textToSearch, null, new Response.Listener<JSONArray>() {
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
                                            indiciRicerca.add(new CoupleSearch(id,tipo));
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
                                        Log.d("ATTENZIONE:",error.getCause().toString());
                                        error.printStackTrace();
                                        progressDialog.dismiss();
                                    }
                                });
                    Network.getInstance(getApplicationContext()).addToRequestQueue(request);
                    progressDialog.setTitle("Attendere");
                    progressDialog.setMessage("Caricamento richiesta");
                    progressDialog.show();
                } else {
                    Toast.makeText(RicercaUtenti.this, "Inserire un campo di ricerca",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private class CoupleSearch {
        public String id,tipo;

        public CoupleSearch(String id, String tipo) {
            this.id = id;
            this.tipo = tipo;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
    }


}
