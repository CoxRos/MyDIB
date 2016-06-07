package it.uniba.di.cosimo.sms16.mydib.flusso.ricerca_utenti;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.entity.uni_contacts.E_Contacts;
import it.uniba.di.cosimo.sms16.mydib.entity.uni_search.UserSearched;
import it.uniba.di.cosimo.sms16.mydib.flusso.profilo_utente.ProfiloDirigente;
import it.uniba.di.cosimo.sms16.mydib.flusso.profilo_utente.ProfiloStudente;

/**
 * Created by Cosimo on 19/05/2016.
 */
public class RicercaUtentiAdapter extends ArrayAdapter<UserSearched> {

    private final int NEW_LAYOUT_RESOURCE;
    private Activity activity;
    Intent intent;

    public RicercaUtentiAdapter(final Context context,Activity a,final int NEW_LAYOUT_RESOURCE) {
        super(context, 0);
        this.activity = a;
        this.NEW_LAYOUT_RESOURCE = NEW_LAYOUT_RESOURCE;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        // We need to get the best view (re-used if possible) and then
        // retrieve its corresponding ViewHolder, which optimizes lookup efficiency
        final View view = getWorkingView(convertView);
        final ViewHolder viewHolder = getViewHolder(view);
        final UserSearched entry = getItem(position);

        viewHolder.nomeView.setText(entry.getNome());

        viewHolder.cognomeView.setText(entry.getCognome());

        viewHolder.tipoView.setText(entry.getTipo());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idRicerca = entry.getId();
                String tipo = entry.getTipo();
                if(tipo.equalsIgnoreCase("Studente")) {
                    intent = new Intent(activity,ProfiloStudente.class);
                    intent.putExtra("idStudente",idRicerca);
                    activity.startActivity(intent);
                } else {
                    intent = new Intent(activity, ProfiloDirigente.class);
                    intent.putExtra("idDirigente",idRicerca);
                    activity.startActivity(intent);
                }
            }
        });

        return view;
    }

    private View getWorkingView(final View convertView) {
        // The workingView is basically just the convertView re-used if possible
        // or inflated new if not possible
        View workingView = null;

        if(null == convertView) {
            final Context context = getContext();
            final LayoutInflater inflater = (LayoutInflater)context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);

            workingView = inflater.inflate(NEW_LAYOUT_RESOURCE, null);
        } else {
            workingView = convertView;
        }

        return workingView;
    }

    private ViewHolder getViewHolder(final View workingView) {
        // The viewHolder allows us to avoid re-looking up view references
        // Since views are recycled, these references will never change
        final Object tag = workingView.getTag();
        ViewHolder viewHolder = null;


        if(null == tag || !(tag instanceof ViewHolder)) {
            viewHolder = new ViewHolder();

            viewHolder.nomeView = (TextView) workingView.findViewById(R.id.textNomeRicerca);
            viewHolder.cognomeView = (TextView) workingView.findViewById(R.id.textCognomeRicerca);
            viewHolder.tipoView = (TextView) workingView.findViewById(R.id.textTipoRicerca);

            workingView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) tag;
        }

        return viewHolder;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    /**
     * ViewHolder allows us to avoid re-looking up view references
     * Since views are recycled, these references will never change
     */
    private static class ViewHolder {
        public TextView nomeView;
        public TextView cognomeView;
        public TextView tipoView;

    }

}