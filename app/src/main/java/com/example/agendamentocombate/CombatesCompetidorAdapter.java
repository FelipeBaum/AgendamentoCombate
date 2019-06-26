package com.example.agendamentocombate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CombatesCompetidorAdapter extends ArrayAdapter {
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<CombatesList> aplicativos;

    public CombatesCompetidorAdapter(Context context, int resource, List<CombatesList> aplicativos) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.aplicativos = aplicativos;
    }

    @Override
    public int getCount() {
        return aplicativos.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(layoutResource, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        CombatesList appAtual = aplicativos.get(position);

            viewHolder.tvRobo.setText(appAtual.getNome_robo1());
            viewHolder.tvHorario.setText(appAtual.getData());

        return convertView;
    }

    private class ViewHolder {
        final TextView tvRobo;
        final TextView tvHorario;

        ViewHolder(View v) {
            this.tvRobo = v.findViewById(R.id.tvRobo);
            this.tvHorario = v.findViewById(R.id.tvHorario);
        }
    }
}
