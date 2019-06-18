package com.example.agendamentocombate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class CombateAdapter extends ArrayAdapter {
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<CombatesList> aplicativos;

    public CombateAdapter(Context context, int resource, List<CombatesList> aplicativos) {
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

        viewHolder.tvRobo1.setText(appAtual.getNome_robo1());
        viewHolder.tvRobo2.setText(appAtual.getNome_robo2());
        viewHolder.tvRobo.setText(appAtual.getNome_robo1());
        viewHolder.tvHorario.setText(appAtual.getData().toString());

        return convertView;
    }

    private class ViewHolder {
        final TextView tvRobo1;
        final TextView tvRobo2;
        final TextView tvRobo;
        final TextView tvHorario;

        ViewHolder(View v) {
            this.tvRobo1 = v.findViewById(R.id.tvRobo1);
            this.tvRobo2 = v.findViewById(R.id.tvRobo2);
            this.tvRobo = v.findViewById(R.id.tvRobo);
            this.tvHorario = v.findViewById(R.id.tvHorario);
        }
    }
}
