package com.example.l.EdukaTIC;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class listDatails {
    public static ArrayList<Model> getList(String respuesta ){

        ArrayList<Model> penticionList = new ArrayList<>( );


        try {
            JSONArray jsonArray = new JSONArray( respuesta );
            for (int i = 0;i <jsonArray.length(); i++ ){
                penticionList.add( new Model( jsonArray.getJSONObject( i ).getString( "nombre" ),jsonArray.getJSONObject( i ).getString( "solicitud"),jsonArray.getJSONObject( i ).getString( "idP" ) ));
            }




        } catch (JSONException e) {
            e.printStackTrace();
        }



        return  penticionList;

    }
}
