package com.example.l.EdukaTIC.peticiones;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.l.EdukaTIC.R;

import java.util.ArrayList;

public class PeticionAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Model> models;

    public PeticionAdapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }



    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View converView, ViewGroup viewGroup) {
        if(converView == null){
            converView = View.inflate( context,R.layout.list_items,null );
        }

        TextView title = (TextView) converView.findViewById( R.id.namemonitor );
        TextView peticion = (TextView) converView.findViewById( R.id.peticionmonitor );
        TextView estado = (TextView) converView.findViewById( R.id.estadonmonitor );
        TextView nota = (TextView) converView.findViewById( R.id.notaadmin );
        ImageView imagen = (ImageView) converView.findViewById( R.id.monitorImageView );
        TextView hora = (TextView) converView.findViewById( R.id.hora );
        Model model = models.get( i );


        title.setText( model.getNombreMonitor() );
        peticion.setText( model.getSolicitudMonitor() );
        estado.setText( model.getEstado() );
        nota.setText( model.getNota() );
        imagen.setImageResource(model.getImagen());
        hora.setText( model.getHora() );



        return converView;
    }
}
