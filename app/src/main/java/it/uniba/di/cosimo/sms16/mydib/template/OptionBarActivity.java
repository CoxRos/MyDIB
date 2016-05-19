package it.uniba.di.cosimo.sms16.mydib.template;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.flusso.login.Login;

/**
 * Created by sergiocorvino on 19/05/16.
 */
public class OptionBarActivity extends AppCompatActivity {

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
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
/*  Intent intent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
*/