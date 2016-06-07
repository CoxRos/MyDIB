package it.uniba.di.cosimo.sms16.mydib.flusso.info_university;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.network.Network;
import it.uniba.di.cosimo.sms16.mydib.template.OptionBarActivity;


public class Info extends OptionBarActivity {
    private Toolbar toolbar;
    private Intent emailIntent;
    TextView doveSiamoView,pecView,nomeDiretView,emailDiretView,nomeSegretView,emailSegretView;

    RequestQueue queue;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_university);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        setUI("http://192.168.30.185/uni/MyDIB_Server/api/info_uni");

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
