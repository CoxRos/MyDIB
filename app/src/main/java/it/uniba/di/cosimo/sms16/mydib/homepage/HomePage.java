package it.uniba.di.cosimo.sms16.mydib.homepage;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.template.OptionBarActivity;

/**
 * Questo è il master 15.30
 */
public class HomePage extends OptionBarActivity {

    private Button btnNews, btnCondividi, btnRicerca, btnProfilo;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("HomePage");
        setSupportActionBar(toolbar);

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
