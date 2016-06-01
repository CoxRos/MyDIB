package it.uniba.di.cosimo.sms16.mydib.flusso.login;

import android.os.Bundle;
import android.util.DisplayMetrics;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.template.OptionBarActivity;

/**
 * Created by sergiocorvino on 19/05/16.
 */
public class Login extends OptionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(height*.6));
    }
}
