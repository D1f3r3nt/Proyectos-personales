package intercode.savings;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import com.android.volley.*;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class Home extends Fragment {

    View vista;
    Button btnOff;
    TextView email, username, amount;
    String validacion = ")(&%povnreuiSSvfrv4816!%";
    String ID;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
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

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        vista = inflater.inflate(R.layout.fragment_home, container, false);
        btnOff = (Button) vista.findViewById(R.id.logout);
        email = (TextView) vista.findViewById(R.id.gmail);
        amount = (TextView) vista.findViewById(R.id.dinero);
        username = (TextView) vista.findViewById(R.id.usuario);
        ID = Settings.Secure.getString(getActivity().getContentResolver(), Settings.Secure.ANDROID_ID);

        String[] precio_operacion,precio_inicial, precio_final, fecha, description, tipo;

        String dato_email = getArguments().getString("email");
        String dato_usuario = getArguments().getString("usuario");
        String dato_amount = getArguments().getString("amount");
        int lineas = getArguments().getInt("lineas");
        LinearLayout ly = (LinearLayout) vista.findViewById(R.id.layaout);
        if(lineas > 0){
            if(lineas > 20)
                lineas = 20;
            precio_operacion = getArguments().getStringArray("precio_operacion");
            precio_inicial = getArguments().getStringArray("precio_inicial");
            precio_final = getArguments().getStringArray("precio_final");
            fecha = getArguments().getStringArray("fecha");
            description = getArguments().getStringArray("description");
            tipo = getArguments().getStringArray("tipo");
            for(int i = 0; i < lineas; i++){
                TextView texto = new TextView(getActivity());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                params.setMargins(0,0,0,20);
                texto.setLayoutParams(params);
                texto.setGravity(Gravity.CENTER);
                texto.setTextSize(18);
                texto.setTextColor(getResources().getColor(R.color.white));
                String signo = "";
                if(tipo[i].equals("IN")){
                    texto.setBackgroundColor(getResources().getColor(R.color.verde));
                    signo = " + ";
                }else {
                    texto.setBackgroundColor(getResources().getColor(R.color.rojo));
                    signo = " - ";
                }
                texto.setText(girarAño(fecha[i])+"\n"+description[i]+"\n"+precio_inicial[i]+"€"+signo+precio_operacion[i]+"€ -> "+precio_final[i]+"€");

                ly.addView(texto);
            }
        }else{
            TextView texto = new TextView(getActivity());
            texto.setText("No hay ninguna transaccion hasta el momento");
            texto.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            texto.setGravity(Gravity.CENTER);
            texto.setTextSize(25);
            texto.setTextColor(getResources().getColor(R.color.white));
            ly.addView(texto);
        }
        email.setText(dato_email);
        amount.setText(dato_amount+"€");
        username.setText(dato_usuario);

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desenlazarDispositivos("https://savingscomp.000webhostapp.com/desenlazar.php", ID);
            }
        });

        return vista;
    }

    private void desenlazarDispositivos(String URL, String ID){

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast t;
                t = Toast.makeText(getActivity(), "Desenlazamiento: "+error.toString(), Toast.LENGTH_SHORT);
                t.show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("validacion", validacion);
                parametros.put("ID", ID);
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        requestQueue.add(stringRequest);

    }

    public String girarAño(String fecha){
        String any = fecha.substring(0,4);
        String mes = fecha.substring(5,7);
        String dia = fecha.substring(8,10);

        return dia+"-"+mes+"-"+any;
    }
}