package intercode.savings;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Profit extends Fragment {

    View vista;
    String[] precio_operacion, precio_inicial, precio_final, description, fecha;
    TextView email, amount;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Profit() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Profit newInstance(String param1, String param2) {
        Profit fragment = new Profit();
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
        vista = inflater.inflate(R.layout.fragment_profit, container, false);

        email = (TextView) vista.findViewById(R.id.gmail);
        amount = (TextView) vista.findViewById(R.id.dinero);
        String dato_email = getArguments().getString("email");
        String dato_amount = getArguments().getString("dinero");

        int lineas = getArguments().getInt("lineas");
        LinearLayout ly = (LinearLayout) vista.findViewById(R.id.layaoutPro);
        if(lineas > 0){
            if(lineas > 20)
                lineas = 20;
            precio_operacion = getArguments().getStringArray("precio_operacion");
            precio_inicial = getArguments().getStringArray("precio_inicial");
            precio_final = getArguments().getStringArray("precio_final");
            fecha = getArguments().getStringArray("fecha");
            description = getArguments().getStringArray("description");

            for(int i = 0; i < lineas; i++){
                TextView texto = new TextView(getActivity());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                params.setMargins(0,0,0,10);
                texto.setLayoutParams(params);
                texto.setGravity(Gravity.CENTER);
                texto.setTextSize(18);
                texto.setTextColor(getResources().getColor(R.color.white));
                texto.setBackgroundColor(getResources().getColor(R.color.verde));
                String signo = " + ";
                texto.setText(girarAño(fecha[i])+"\n"+description[i]+"\n"+precio_inicial[i]+"€"+signo+precio_operacion[i]+"€ -> "+precio_final[i]+"€");
                ly.addView(texto);
            }
        }else{
            TextView texto = new TextView(getActivity());
            texto.setText("No hay ningun beneficio hasta el momento");
            texto.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            texto.setGravity(Gravity.CENTER);
            texto.setTextSize(25);
            texto.setTextColor(getResources().getColor(R.color.white));
            ly.addView(texto);
        }
        email.setText(dato_email);
        amount.setText(dato_amount+"€");
        return vista;
    }

    public String girarAño(String fecha){
        String any = fecha.substring(0,4);
        String mes = fecha.substring(5,7);
        String dia = fecha.substring(8,10);

        return dia+"-"+mes+"-"+any;
    }
}