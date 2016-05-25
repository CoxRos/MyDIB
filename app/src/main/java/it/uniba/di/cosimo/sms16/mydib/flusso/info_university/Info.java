package it.uniba.di.cosimo.sms16.mydib.flusso.info_university;

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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.entity.uni_contacts.E_Contacts;
import it.uniba.di.cosimo.sms16.mydib.network.Network;

public class Info extends AppCompatActivity {
    private Intent emailIntent;
    TextView doveSiamoView,pecView,nomeDiretView,emailDiretView,nomeSegretView,emailSegretView;

    RequestQueue queue;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_university);

        queue = Network.getInstance(getApplicationContext()).
                getRequestQueue();

        emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("plain/text");

        doveSiamoView = (TextView) findViewById(R.id.textDoveSiamo);
        pecView = (TextView) findViewById(R.id.textPEC);
        nomeDiretView = (TextView) findViewById(R.id.nomeDirettore);
        emailDiretView = (TextView) findViewById(R.id.emailDirettore);
        nomeSegretView = (TextView) findViewById(R.id.nomeSegretario);
        emailSegretView = (TextView) findViewById(R.id.emailSegretario);
        setUI("https://api.myjson.com/bins/4uke8");
        /*
        doveSiamoView.setText("Campus Universitario \"Ernesto Quagliariello\" \n" +
                "Via E. Orabona, 4 - Bari 70125");
        pecView.setText("direzione.di@pec.uniba.it");
        nomeDiretView.setText("Prof. Donato Malerba");
        emailDiretView.setText("direttore.dib@uniba.it");
        nomeSegretView.setText("dott. Rosaria Lacalamita");
        emailSegretView.setText("sad.dib@uniba.it");
        */
        emailDiretView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{emailDiretView.getText().toString()});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "INFORMAZIONI");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(emailIntent, "Email al direttore."));
            }
        });

        emailSegretView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{emailSegretView.getText().toString()});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "INFORMAZIONI");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(emailIntent, "Email al segretario amministrativo."));
            }
        });

    }

    private void setUI(String url) {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                        public void onResponse(JSONObject response) {
                        try {
                            doveSiamoView.setText(response.getString("doveSiamo"));
                            pecView.setText(response.getString("pec"));
                            nomeDiretView.setText(response.getString("nomeDir"));
                            emailDiretView.setText(response.getString("emailDir"));
                            nomeSegretView.setText(response.getString("nomeSegr"));
                            emailSegretView.setText(response.getString("emailSegr"));
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
        progressDialog.setMessage("Caricamento info");
        progressDialog.show();
    }
}
