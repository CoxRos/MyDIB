package it.uniba.di.cosimo.sms16.mydib.flusso.profilo_utente;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.network.Network;

public class ProfiloStudente extends AppCompatActivity {

    Intent intent;
    String idStudente;

    TextView txtNomeStudente, txtCognomeStudente, txtEmailStudente;

    RequestQueue queue;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo_studente);

        intent = getIntent();

        idStudente = intent.getStringExtra("idStudente");

        queue = Network.getInstance(getApplicationContext()).
                getRequestQueue();

        txtCognomeStudente = (TextView) findViewById(R.id.txtCognomeStudente);
        txtEmailStudente = (TextView) findViewById(R.id.txtEmailStudente);
        txtNomeStudente = (TextView) findViewById(R.id.txtNomeStudente);
        setUI("http://192.168.30.185/uni/MyDIB_Server/api/get_studente/" + idStudente);
    }

    private void setUI(String url) {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            txtCognomeStudente.setText(response.getString("CognomeStudente"));
                            txtNomeStudente.setText(response.getString("NomeStudente"));
                            txtEmailStudente.setText(response.getString("EmailStudente"));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        progressDialog.dismiss();
                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("JSON Errore connessione info: " + error.networkResponse);
                        progressDialog.dismiss();
                    }
                });
        Network.getInstance(getApplicationContext()).addToRequestQueue(jsObjRequest);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Attendere");
        progressDialog.setMessage("Caricamento dati del profilo...");
        progressDialog.show();
    }
}
