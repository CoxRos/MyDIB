package it.uniba.di.cosimo.sms16.mydib.flusso.profilo_utente.libretto;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.entity.profilo_utente.Esame;


public class VotiFragment extends Fragment {

    ArrayList<Esame> esami = new ArrayList<Esame>(); //Verrà tolto

    VotiAdapter adapter;
    private List<Esame> rowEsami;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_voti, container, false);

        /*
            Non deve essere fatto così, gli utenti devono aggiungere e viene salvato nel
            database e quindi prenderli da li. Per il momento vedo se va.
         */
        esami.add(new Esame("Analisi","20.05.2014",9,25));
        esami.add(new Esame("Programmazione","20.05.2014",9,28));
        esami.add(new Esame("Linguaggi","20.05.2014",9,18));
        esami.add(new Esame("Economia","20.05.2014",9,23));
        esami.add(new Esame("Modelli","20.05.2014",9,22));

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);



        rowEsami = new ArrayList<Esame>();

        //for (int i = 0; i < esami.length; i++) {
            rowEsami = esami;
        //}

        adapter = new VotiAdapter(getActivity(), rowEsami);
        //setListAdapter(adapter);

    }

}
