package it.uniba.di.cosimo.sms16.mydib.flusso.libretto;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.template.OptionBarActivity;

/**
 * Created by sergiocorvino on 07/06/16.
 */
public class ModificaEsame extends OptionBarActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_esame);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
