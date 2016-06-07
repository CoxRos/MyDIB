package it.uniba.di.cosimo.sms16.mydib.flusso.profilo_utente;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
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

public class ProfiloDirigente extends AppCompatActivity {

    Intent intent;
    String idDirigente;

    TextView txtNomeDirigente,txtCognomeDirigente,txtEmailDirigente,
            txtTelDirigente,txtRicevimentoDirigente,txtWebDirigente,labelWeb,labelRicevimento;

    RequestQueue queue;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo_dirigente);

        intent = getIntent();

        idDirigente = intent.getStringExtra("idDirigente");

        queue = Network.getInstance(getApplicationContext()).
                getRequestQueue();

        txtCognomeDirigente = (TextView) findViewById(R.id.txtCognomeDirigente);
        txtEmailDirigente = (TextView) findViewById(R.id.txtEmailDirigente);
        txtNomeDirigente = (TextView) findViewById(R.id.txtNomeDirigente);
        txtRicevimentoDirigente = (TextView) findViewById(R.id.txtRicevimentoDirigente);
        txtTelDirigente = (TextView) findViewById(R.id.txtTelDirigente);
        txtWebDirigente = (TextView) findViewById(R.id.txtWebDirigente);
        labelRicevimento = (TextView) findViewById(R.id.textView22);
        labelWeb = (TextView) findViewById(R.id.textView23);

        setUI("http://192.168.30.185/uni/MyDIB_Server/api/get_dirigente/" + idDirigente);
    }

    private void setUI(String url) {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if(response.getString("Prof").equalsIgnoreCase("Y")) {
                                txtWebDirigente.setVisibility(View.VISIBLE);
                                txtRicevimentoDirigente.setVisibility(View.VISIBLE);
                                labelWeb.setVisibility(View.VISIBLE);
                                labelRicevimento.setVisibility(View.VISIBLE);
                                txtWebDirigente.setText(response.getString("WebDirigente"));
                                txtRicevimentoDirigente.setText(response.getString("RicevimentoDirigente"));
                            }

                            txtCognomeDirigente.setText(response.getString("CognomeDirigente"));
                            txtNomeDirigente.setText(response.getString("NomeDirigente"));
                            txtEmailDirigente.setText(response.getString("EmailDirigente"));
                            txtTelDirigente.setText(response.getString("TelefonoDirigente"));
                        } catch(Exception e) {
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
