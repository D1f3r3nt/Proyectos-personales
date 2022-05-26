package intercode.savings;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Add extends Fragment {
    View vista;
    RadioGroup grupo;
    TextView dinero, gmail;
    Button btn;
    EditText txt, number;
    String validacion = ")(&%povnreuiSSvfrv4816!%"; //<--
    String cantidad_ini, tipo, cantidad_fin, email;
    int fin;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Add() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Add newInstance(String param1, String param2) {
        Add fragment = new Add();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_add, container, false);

        grupo = (RadioGroup) vista.findViewById(R.id.grupo);
        number = (EditText) vista.findViewById(R.id.cant);
        dinero = (TextView) vista.findViewById(R.id.dinero);
        gmail = (TextView) vista.findViewById(R.id.gmail);
        txt = (EditText) vista.findViewById(R.id.texto);
        btn = (Button) vista.findViewById(R.id.doit);
        email = getArguments().getString("email");//Enviado por DoAdd
        cantidad_ini = getArguments().getString("money");//Enviado por DoAdd
        dinero.setText(cantidad_ini);
        gmail.setText(email);
        cantidad_ini = cantidad_ini.substring(0, (cantidad_ini.length()-1));
        String ID = Settings.Secure.getString(getActivity().getContentResolver(), Settings.Secure.ANDROID_ID);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t;
                boolean flag = true;

                int index = grupo.getCheckedRadioButtonId();
                if(index == R.id.in){
                    tipo = "IN";
                    fin = Integer.parseInt(cantidad_ini) + Integer.parseInt(number.getText().toString());
                }else{
                    tipo = "OUT";
                }


                if(tipo == "OUT"){
                    if(Integer.parseInt(cantidad_ini) < Integer.parseInt(number.getText().toString())){
                        t = Toast.makeText(getActivity(), "¡¡PONGA DATOS CORRECTOS!!", Toast.LENGTH_SHORT);
                        t.show();
                        flag = false;
                    }else{
                        fin = Integer.parseInt(cantidad_ini) - Integer.parseInt(number.getText().toString());
                    }
                }

                if(txt.getText().toString().length() > 0 && number.getText().toString().length() > 0 && flag){
                    cantidad_fin = String.valueOf(fin);
                    ejecutarServicio("https://savingscomp.000webhostapp.com/insertar.php", email, cantidad_ini, cantidad_fin, ID);

                }else if(flag){
                    t = Toast.makeText(getActivity(), "¡¡PONGA DATOS!!", Toast.LENGTH_SHORT);
                    t.show();
                }

            }
        });

        return vista;
    }

    public void ejecutarServicio(String URL, String email, String cantidad_ini, String cantidad_fin, String ID){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast t;
                t = Toast.makeText(getActivity(), "OPERACION EXITOSA", Toast.LENGTH_SHORT);
                t.show();
                ActualizarDatos("https://savingscomp.000webhostapp.com/actualizar.php",cantidad_fin, email);
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast t;
                t = Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_SHORT);
                t.show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("validacion", validacion);
                parametros.put("amount", number.getText().toString());
                parametros.put("type", tipo);
                parametros.put("description", txt.getText().toString());
                parametros.put("cant_i", cantidad_ini);
                parametros.put("cant_f", cantidad_fin);
                parametros.put("email", email);
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        requestQueue.add(stringRequest);

    }

    public void ActualizarDatos(String URL,String cantidad_fin, String email){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast t;
                t = Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_SHORT);
                t.show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("validacion", validacion);
                parametros.put("cant_f", cantidad_fin);
                parametros.put("email", email);
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        requestQueue.add(stringRequest);
    }


}