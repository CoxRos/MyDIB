package it.uniba.di.cosimo.sms16.mydib.flusso.info_university;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.template.OptionBarActivity;

public class Info extends OptionBarActivity {
    private Toolbar toolbar;
    private Intent emailIntent;
    TextView doveSiamoView,pecView,nomeDiretView,emailDiretView,nomeSegretView,emailSegretView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_university);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("plain/text");

        doveSiamoView = (TextView) findViewById(R.id.textDoveSiamo);
        pecView = (TextView) findViewById(R.id.textPEC);
        nomeDiretView = (TextView) findViewById(R.id.nomeDirettore);
        emailDiretView = (TextView) findViewById(R.id.emailDirettore);
        nomeSegretView = (TextView) findViewById(R.id.nomeSegretario);
        emailSegretView = (TextView) findViewById(R.id.emailSegretario);

        doveSiamoView.setText("Campus Universitario \"Ernesto Quagliariello\" \n" +
                "Via E. Orabona, 4 - Bari 70125");
        pecView.setText("direzione.di@pec.uniba.it");
        nomeDiretView.setText("Prof. Donato Malerba");
        emailDiretView.setText("direttore.dib@uniba.it");
        nomeSegretView.setText("dott. Rosaria Lacalamita");
        emailSegretView.setText("sad.dib@uniba.it");

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
}
