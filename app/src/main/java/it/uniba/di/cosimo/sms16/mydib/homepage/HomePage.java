package it.uniba.di.cosimo.sms16.mydib.homepage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import it.uniba.di.cosimo.sms16.mydib.R;

public class HomePage extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_info) {
            Log.d("HOME", "hai cliccato le info");
        } else if(id == R.id.action_login) {
            Log.d("HOME", "vai alla login con popup");
        }
        return super.onOptionsItemSelected(item);
    }
}
