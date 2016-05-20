package it.uniba.di.cosimo.sms16.mydib.template;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.flusso.login.Login;

/**
 * Created by sergiocorvino on 19/05/16.
 */
public class OptionBarActivity extends AppCompatActivity {

    protected Button btnLogin, btnAnnulla;
    protected EditText edtUsername, edtPassword;
    protected Dialog dialog;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch(id) {
            case R.id.action_info :
                Log.d("OPTION", "ho cliccato info");
                break;
            case R.id.action_login :
                dialog.show();
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void createDialog() {

        dialog = new Dialog(this);
        dialog.setTitle("Login");
        dialog.setContentView(R.layout.activity_login);

        //catturo gli elementi della view per id
        btnLogin = (Button) dialog.findViewById(R.id.btnLogin);
        btnAnnulla = (Button) dialog.findViewById(R.id.btnAnnulla);
    }
}
