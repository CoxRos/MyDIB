package it.uniba.di.cosimo.sms16.mydib.homepage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import it.uniba.di.cosimo.sms16.mydib.R;

/**
 * Created by sergiocorvino on 18/05/16.
 */
public class HomePage extends Activity {

    private Button btnNews, btnCondividi, btnRicerca, btnProfilo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //catturo gli id dei button
        btnNews = (Button)findViewById(R.id.btnNewsLogged);
        btnCondividi = (Button)findViewById(R.id.btnCondividi);
        btnRicerca = (Button)findViewById(R.id.btnRicerca);
        btnProfilo = (Button)findViewById(R.id.btnProfilo);

        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnCondividi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnRicerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnProfilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
