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
    String salon = "";
    String requisitos = "";
    String paralela1 = "";
    String lugar1 = "";
    String paralela2 = "";
    String lugar2 = "";
    String paralela3 = "";
    String lugar3 = "";




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
        //Intent intent = new Intent(getActivity(), pantallaError.class);
        //intent.putExtra("cc",cajaCC.getText().toString());
        //startActivity(intent);
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
            taller = ( jsonObject.optString( "taller" ) );
            salon = ( jsonObject.optString( "salon" ) );
            requisitos = ( jsonObject.optString( "requisitos" ) );
            paralela1 = ( jsonObject.optString( "paralela1" ) );
            lugar1 = ( jsonObject.optString( "lugar1" ) );
            paralela2 = ( jsonObject.optString( "paralela2" ) );
            lugar2 = ( jsonObject.optString( "lugar2" ) );
            paralela3 = ( jsonObject.optString( "paralela3" ) );
            lugar3 = ( jsonObject.optString( "lugar3" ) );


        } catch (JSONException e) {
            e.printStackTrace();
        }


        Intent carajo = new Intent( getContext(), ResutadoConsultaCC.class );
        carajo.putExtra( "nombreU",nombre);
        carajo.putExtra( "taller",taller);
        carajo.putExtra( "salon",salon);
        carajo.putExtra( "requisitos",requisitos);
        carajo.putExtra( "paralela1",paralela1);
        carajo.putExtra( "lugar1",lugar1);
        carajo.putExtra( "paralela2",paralela2);
        carajo.putExtra( "lugar2",lugar2);
        carajo.putExtra( "paralela3",paralela3);
        carajo.putExtra( "lugar3",lugar3);

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
