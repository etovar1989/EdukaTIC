package com.example.l.EdukaTIC;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class SesionFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {

    RequestQueue rq;
    JsonRequest jrq;

    EditText cajaUser, cajaPws;
    Button consultar;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate( R.layout.fragment_sesion,container,false );
        cajaUser = (EditText)vista.findViewById( R.id.txtUsuario );
        cajaPws = (EditText)vista.findViewById( R.id.txtClave );
        consultar = (Button) vista.findViewById( R.id.btnIngresar );

        rq = Volley.newRequestQueue(getContext());

        consultar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSesion();
            }
        } );



        return vista;






    }




    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText( getContext(),"No se encontro usuario "+ error.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        //Toast.makeText( getContext(),"Se ha encontrado el usuario "+ cajaUser.getText().toString(), Toast.LENGTH_LONG).show();
        com.example.l.EdukaTIC.User usuario = new com.example.l.EdukaTIC.User();


        JSONArray jsonArray = response.optJSONArray( "datos" );
        JSONObject jsonObject = null;
        try {
            jsonObject = jsonArray.getJSONObject( 0 );

            usuario.setNames( jsonObject.optString( "nombres" ) );
            usuario.setLastN( jsonObject.optString( "apellidos" ) );

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Intent carajo = new Intent( getContext(), Menu.class );
        carajo.putExtra( "nombres",usuario.getNames());
        carajo.putExtra( "apellidos",usuario.getLastN());
        startActivity( carajo );

    }

    private void iniciarSesion(){
        String url="http://edukatic.icesi.edu.co/complementos_apk/login.php?user="+cajaUser.getText().toString()+
                "&pwd="+cajaPws.getText().toString();
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);

    }
}
