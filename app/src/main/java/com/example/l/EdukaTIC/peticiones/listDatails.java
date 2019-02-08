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
        String hora = "";
        int imagen=R.drawable.questionsol;
        String para = "";


        try {
            JSONArray jsonArray = new JSONArray( respuesta );
            for (int i = 0;i <jsonArray.length(); i++ ){
                para = jsonArray.getJSONObject( i ).getString( "para" );
                opc = jsonArray.getJSONObject( i ).getString( "estado" );
                if(opc.equals( "0" ) && para.equals( "1144074153" )){
                    estado = "Pendiente";
                    imagen = R.drawable.questionsol;
                    hora = jsonArray.getJSONObject( i ).getString( "fecha_creacion" );
                }if(opc.equals( "0" ) && para.equals( "1144152500" )){
                    estado = "Pendiente";
                    imagen = R.drawable.questionsolval;
                    hora = jsonArray.getJSONObject( i ).getString( "fecha_creacion" );
                }if(opc.equals( "1" )){
                    estado = "Aprobada";
                    imagen = R.drawable.confirmsol;
                    hora = jsonArray.getJSONObject( i ).getString( "fecha_respuesta" );
                }if(opc.equals( "2" )){
                    estado = "Cancelada";
                    imagen = R.drawable.cancelsol;
                    hora = jsonArray.getJSONObject( i ).getString( "fecha_respuesta" );

                }

                penticionList.add( new Model( jsonArray.getJSONObject( i ).getString( "nombre" ),jsonArray.getJSONObject( i ).getString( "solicitud"),jsonArray.getJSONObject( i ).getString( "idP" ),estado,jsonArray.getJSONObject( i ).getString( "nota" ),imagen,hora  ));
            }




        } catch (JSONException e) {
            e.printStackTrace();
        }



        return  penticionList;

    }
}
