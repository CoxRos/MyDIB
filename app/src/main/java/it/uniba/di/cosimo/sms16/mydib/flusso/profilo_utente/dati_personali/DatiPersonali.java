package it.uniba.di.cosimo.sms16.mydib.flusso.profilo_utente.dati_personali;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.CustomRequestObject;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.network.Network;
import it.uniba.di.cosimo.sms16.mydib.template.OptionBarActivity;

public class DatiPersonali extends OptionBarActivity {

    RequestQueue queue;
    ProgressDialog progressDialog;

    private Toolbar toolbar;
    TextView txtVotoLaureaDati, txtMediaAritmeticaDati, txtMediaPonderataDati,
            txtAAInCorsoDati, txtAAIscrizioneDati, txtEmailDati, txtMatricolaDati,
            txtCognomeDati, txtNomeDati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dati_personali);

        queue = Network.getInstance(getApplicationContext()).
                getRequestQueue();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Profilo");
        setSupportActionBar(toolbar);

        txtAAInCorsoDati = (TextView) findViewById(R.id.txtAAInCorsoDati);
        txtAAIscrizioneDati = (TextView) findViewById(R.id.txtAAIscrizioneDati);
        txtCognomeDati = (TextView) findViewById(R.id.txtCognomeDati);
        txtEmailDati = (TextView) findViewById(R.id.txtEmailDati);
        txtMatricolaDati = (TextView) findViewById(R.id.txtMatricolaDati);
        txtMediaAritmeticaDati = (TextView) findViewById(R.id.txtMediaAritmeticaDati);
        txtMediaPonderataDati = (TextView) findViewById(R.id.txtMediaPonderataDati);
        txtNomeDati = (TextView) findViewById(R.id.txtNomeDati);
        txtVotoLaureaDati = (TextView) findViewById(R.id.txtVotoLaureaDati);

        /* QUI LI DEVO PRENDERE DAL DATABASE 192.168.30.119
        Prima verifico se il DB li ha avvalorati,altrimenti chiamo il server
        txtAAInCorsoDati.setText("");
        txtAAIscrizioneDati.setText("");
        txtCognomeDati.setText("");
        txtEmailDati.setText("");
        txtMatricolaDati.setText("");
        txtMediaAritmeticaDati.setText("");
        txtMediaPonderataDati.setText("");
        txtNomeDati.setText("");
        txtVotoLaureaDati.setText("");
        */

        //Suppongo che abbia già verificato all'interno del DB
        CustomRequestObject request = new CustomRequestObject
                (Request.Method.POST, "http://192.168.30.119/POST_MYDIB.php", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    txtAAInCorsoDati.setText(response.getString("AAinCorso"));
                    txtAAIscrizioneDati.setText(response.getString("AAIscrizione"));
                    txtCognomeDati.setText(response.getString("cognome"));
                    txtEmailDati.setText(response.getString("email"));
                    txtMatricolaDati.setText(response.getString("matricola"));
                    txtMediaAritmeticaDati.setText("Dato non disponibile"); //Perché lo carico da database
                    txtMediaPonderataDati.setText("Dato non disponibile"); //Perché lo carico da database
                    txtNomeDati.setText(response.getString("nome"));
                    txtVotoLaureaDati.setText("Dato non disponibile"); //Perché lo carico da database
                } catch (Exception e) {
                    System.out.println("catch");
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
                params.put("action", "infoUtente");
                return params;
            }
        };
        Network.getInstance(getApplicationContext()).addToRequestQueue(request);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Attendere");
        progressDialog.setMessage("Caricamento messaggi");
        progressDialog.show();
    }
}
