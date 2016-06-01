package it.uniba.di.cosimo.sms16.mydib.flusso.profilo_utente.libretto;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import it.uniba.di.cosimo.sms16.mydib.R;
import it.uniba.di.cosimo.sms16.mydib.entity.profilo_utente.Esame;

public class VotiAdapter extends BaseAdapter {
    Context context;
    List<Esame> rowItem;

    VotiAdapter(Context context, List<Esame> rowItem) {
        this.context = context;
        this.rowItem = rowItem;
    }

    @Override
    public int getCount() {

        return rowItem.size();
    }

    @Override
    public Object getItem(int position) {

        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position) {

        return rowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_voti_detail, null);
        }

        TextView materia = (TextView) convertView.findViewById(R.id.txtNomeEsameList);
        TextView cfu = (TextView) convertView.findViewById(R.id.txtCfuList);
        TextView voto = (TextView) convertView.findViewById(R.id.txtVotoList);
        TextView data = (TextView) convertView.findViewById(R.id.txtDataList);

        Esame row_pos = rowItem.get(position);

        materia.setText(row_pos.getTitolo());
        cfu.setText(Integer.toString(row_pos.getCfu()));
        voto.setText(Integer.toString(row_pos.getVoto()));
        data.setText(row_pos.getData());

        if(row_pos.getVoto() > 26) {
            //colora di verde
            GradientDrawable drawable = (GradientDrawable)convertView.getBackground();
            drawable.setStroke(3, Color.GREEN);
        } else if(row_pos.getVoto() > 22) {
            //colora di giallo
            GradientDrawable drawable = (GradientDrawable)convertView.getBackground();
            drawable.setStroke(3, Color.YELLOW);
        } else {
            //colora di rosso
            GradientDrawable drawable = (GradientDrawable)convertView.getBackground();
            drawable.setStroke(3, Color.RED);
        }
        return convertView;
    }

}
