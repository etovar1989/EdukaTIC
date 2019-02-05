package com.example.l.EdukaTIC.consultar;

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
import com.example.l.EdukaTIC.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ConsultaCCFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{
    RequestQueue rq;
    JsonRequest jrq;

    EditText cajaCC;
    Button consultarCC;
    String nombre = "";
    String taller = "";
    String ubicacion = "";
    String requisitos = "";
    String expositor = "";
    String idTaller = "";
    String TallerM1 = "";
    String TallerM2 = "";
    String GeneralM1 = "";
    String GeneralM2 = "";
    String GM1 = "";
    String GM2 = "";
    String GT1 = "";
    String GT2 = "";
    String GT3 = "";
    String D2CP1 = "";
    String D2CP2 = "";
    String D2CP3 = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate( R.layout.fragment_consulta_cc,container,false );
        cajaCC = (EditText)vista.findViewById( R.id.txtConCC );
        consultarCC = (Button) vista.findViewById( R.id.btnConCC );

        rq = Volley.newRequestQueue(getContext());
        consultarCC.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarCedula();
            }
        } );



        return vista;

    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText( getContext(),"Upss, hay algo que no esta bien con la CC: "+cajaCC.getText().toString(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), pantallaError.class);
        intent.putExtra("cc",cajaCC.getText().toString());
        startActivity(intent);
        cajaCC.setText("");


    }

    @Override
    public void onResponse(JSONObject response) {

        //Toast.makeText( getContext(),"OK ", Toast.LENGTH_SHORT).show();

        JSONArray jsonArray = response.optJSONArray( "datos" );
        JSONObject jsonObject = null;
        try {
            jsonObject = jsonArray.getJSONObject( 0 );

            nombre = ( jsonObject.optString( "nombreU" ) );
            taller = ( jsonObject.optString( "nombreTaller" ) );
            ubicacion = ( jsonObject.optString( "salaTaller" ) );
            requisitos = ( jsonObject.optString( "reqTaller" ) );
            expositor = ( jsonObject.optString( "expositorTaller" ) );
            idTaller = ( jsonObject.optString( "idTaller" ) );
            TallerM1 = ( jsonObject.optString( "tallerM1" ) );
            TallerM2 = ( jsonObject.optString( "tallerM2" ) );
            GeneralM1 = ( jsonObject.optString( "GeneralM1" ) );
            GeneralM2 = ( jsonObject.optString( "GeneralM2" ) );
            GM1 = ( jsonObject.optString( "GM1" ) );
            GM2 = ( jsonObject.optString( "GM2" ) );
            GT1 = ( jsonObject.optString( "GT1" ) );
            GT2 = ( jsonObject.optString( "GT2" ) );
            GT3 = ( jsonObject.optString( "GT3" ) );
            D2CP1 = ( jsonObject.optString( "D2CP1" ) );
            D2CP2 = ( jsonObject.optString( "D2CP2" ) );
            D2CP3 = ( jsonObject.optString( "D2CP3" ) );

        } catch (JSONException e) {
            e.printStackTrace();
        }


        Intent carajo = new Intent( getContext(), ResutadoConsultaCC.class );
        carajo.putExtra( "nombre",nombre);
        carajo.putExtra( "taller",taller);
        carajo.putExtra( "ubicacion",ubicacion);
        carajo.putExtra( "requisitos",requisitos);
        carajo.putExtra( "expositor",expositor);
        carajo.putExtra( "idTaller",idTaller);
        carajo.putExtra( "tallerM1",TallerM1);
        carajo.putExtra( "tallerM2",TallerM2);
        carajo.putExtra( "GeneralM1",GeneralM1);
        carajo.putExtra( "GeneralM2",GeneralM2);
        carajo.putExtra( "GM1",GM1);
        carajo.putExtra( "GM2",GM2);
        carajo.putExtra( "GT1",GT1);
        carajo.putExtra( "GT2",GT2);
        carajo.putExtra( "GT3",GT3);
        carajo.putExtra( "D2CP1",D2CP1);
        carajo.putExtra( "D2CP2",D2CP2);
        carajo.putExtra( "D2CP3",D2CP3);

        startActivity( carajo );
        cajaCC.setText("");

        //Toast.makeText( getContext(),"OK "+nombre, Toast.LENGTH_SHORT).show();



    }


    /*Envia la consulta a el php*/
    private void validarCedula(){
        String url="http://edukatic.icesi.edu.co/complementos_apk/consultar_usuario.php?idU="+cajaCC.getText().toString();
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);


    }
}
