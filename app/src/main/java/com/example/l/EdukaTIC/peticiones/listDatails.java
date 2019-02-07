package com.example.l.EdukaTIC.peticiones;

import com.example.l.EdukaTIC.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class listDatails {
    public static ArrayList<Model> getList(String respuesta ){

        ArrayList<Model> penticionList = new ArrayList<>( );
        String opc = "";
        String estado = "";
        int imagen=R.drawable.cancelsol;


        try {
            JSONArray jsonArray = new JSONArray( respuesta );
            for (int i = 0;i <jsonArray.length(); i++ ){
                opc = jsonArray.getJSONObject( i ).getString( "estado" );
                if(opc.equals( "0" )){
                    estado = "Pendiente";
                    imagen = R.drawable.questionsol;
                }if(opc.equals( "1" )){
                    estado = "Aprobada";
                    imagen = R.drawable.confirmsol;
                }if(opc.equals( "2" )){
                    estado = "Canselada";
                    imagen = R.drawable.cancelsol;
                }

                penticionList.add( new Model( jsonArray.getJSONObject( i ).getString( "nombre" ),jsonArray.getJSONObject( i ).getString( "solicitud"),jsonArray.getJSONObject( i ).getString( "idP" ),estado,jsonArray.getJSONObject( i ).getString( "nota" ),imagen  ));
            }




        } catch (JSONException e) {
            e.printStackTrace();
        }



        return  penticionList;

    }
}
