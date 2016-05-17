package it.uniba.di.cosimo.sms16.mydib.flusso.university_contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.entity.uni_contacts.E_Contacts;


/**
 * Created by Cosimo on 17/05/2016.
 */
public class ContacsAdapter extends ArrayAdapter<E_Contacts> {

    private final int NEW_LAYOUT_RESOURCE;

    public ContacsAdapter(final Context context,final int NEW_LAYOUT_RESOURCE) {
        super(context, 0);
        this.NEW_LAYOUT_RESOURCE = NEW_LAYOUT_RESOURCE;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {

        // We need to get the best view (re-used if possible) and then
        // retrieve its corresponding ViewHolder, which optimizes lookup efficiency
        final View view = getWorkingView(convertView);
        final ViewHolder viewHolder = getViewHolder(view);
        final E_Contacts entry = getItem(position);

        viewHolder.titoloView.setText(entry.getTitolo());

        viewHolder.descrizioneView.setText(entry.getDescrizione());

        viewHolder.emailView.setText(entry.getEmail());

        viewHolder.phoneView.setText(entry.getTelefono());

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

            viewHolder.titoloView = (TextView) workingView.findViewById(R.id.textTitolo);
            viewHolder.descrizioneView = (TextView) workingView.findViewById(R.id.textDescrizione);
            viewHolder.emailView = (TextView) workingView.findViewById(R.id.textEmail);
            viewHolder.phoneView = (TextView) workingView.findViewById(R.id.textPhone);

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
        public TextView titoloView;
        public TextView descrizioneView;
        public TextView emailView;
        public TextView phoneView;

    }

}
