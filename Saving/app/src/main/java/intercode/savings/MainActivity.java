package intercode.savings;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity<ID> extends AppCompatActivity {
    Home ho = new Home();
    Profit pro = new Profit();
    Add ad = new Add();
    Loss lo = new Loss();
    Chart ch = new Chart();
    Wait wt = new Wait();
    int valor = 0;
    String ID;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint({"HardwareIds", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout fl = (FrameLayout) findViewById(R.id.frame_container);
        fl.setElevation(90);
        loadFragment(wt);
         ID = Secure.getString(getBaseContext().getContentResolver(), Secure.ANDROID_ID);
         buscarID("https://savingscomp.000webhostapp.com/buscar_id.php?ID="+ID+"", ID, fl);
         BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
         navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public void onBackPressed(){
        return;
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.ho:
                    loadFragment(ho);
                    valor = 0;
                    return true;

                case R.id.profit:
                    loadFragment(pro);
                    valor = 1;
                    return true;

                case R.id.add:
                    DoADD();
                    valor = 2;
                    return true;

                case R.id.loss:
                    loadFragment(lo);
                    valor = 3;
                    return true;

                case R.id.chart:
                    loadFragment(ch);
                    valor = 4;
                    return true;
            }
            return false;
        }
    };

    public void DoADD(){
        TextView email, dinero;
        email = (TextView) findViewById(R.id.gmail);
        dinero = (TextView) findViewById(R.id.dinero);
        String mail = email.getText().toString();
        String money = dinero.getText().toString();
        Bundle enviar = new Bundle();
        enviar.putString("email",mail);
        enviar.putString("money",money);
        ad.setArguments(enviar);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, ad);
        transaction.commit();
    }

    public void DoHome(String ID, FrameLayout fl){


        buscarDispositivosYEjecutar("https://savingscomp.000webhostapp.com/buscar_dispositivos.php?Android="+ID, ho, fl);

    }

    public void buscarDispositivosYEjecutar(String URL, Fragment fragment, FrameLayout fl){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject fila=null;
                String[] dato_email = new String[response.length()];
                for(int i = 0; i<response.length(); i++){
                    try{
                        fila=response.getJSONObject(i);
                        dato_email[i] = fila.getString("email");
                    }catch(JSONException e){
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                buscarPersonaYDinero("https://savingscomp.000webhostapp.com/buscar_personaYDinero.php?Email="+dato_email[0], dato_email[0], fragment, fl);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "ERROR\nNo se ha encontrado la cuenta", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonArrayRequest);


    }

    public void buscarPersonaYDinero(String URL, String email, Fragment fragment, FrameLayout fl){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject fila=null;
                String[] dato_usuario = new String[response.length()];
                String[] dato_amount = new String[response.length()];

                for(int i = 0; i<response.length(); i++){
                    try{
                        fila=response.getJSONObject(i);
                        dato_usuario[i] = fila.getString("username");
                        dato_amount[i] = fila.getString("cant_inicial");
                    }catch(JSONException e){
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                buscarDatosApartados("https://savingscomp.000webhostapp.com/buscar_transacciones_profit.php?Email="+email, email, pro, dato_amount[0]);
                buscarDatosApartados("https://savingscomp.000webhostapp.com/buscar_transacciones_loss.php?Email="+email, email, lo, dato_amount[0]);
                buscarDatosApartados("https://savingscomp.000webhostapp.com/buscar_transacciones_loss.php?Email="+email, email, ch, dato_amount[0]);
                buscarDatos("https://savingscomp.000webhostapp.com/buscar_transacciones_home.php?Email="+email, email, fragment, dato_amount[0], dato_usuario[0], fl);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "ERROR\nNo hay ningun usuario", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonArrayRequest);


    }

    public void buscarDatos(String URL, String email, Fragment fragment, String amount, String usuario, FrameLayout fl){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onResponse(JSONArray response) {
                JSONObject fila=null;
                String[] precios_operaciones = new String[response.length()];
                String[] precios_iniciales = new String[response.length()];
                String[] precios_finales = new String[response.length()];
                String[] fechas = new String[response.length()];
                String[] descriptions = new String[response.length()];
                String[] tipos = new String[response.length()];

                for(int i = 0; i<response.length(); i++){
                    try{
                        fila=response.getJSONObject(i);
                        precios_operaciones[i] = fila.getString("cant_operacion");
                        precios_iniciales[i] = fila.getString("cant_inicial");
                        precios_finales[i] = fila.getString("cant_final");
                        fechas[i] = fila.getString("fecha");
                        descriptions[i] = fila.getString("descripcion");
                        tipos[i] = fila.getString("tipo");
                    }catch(JSONException e){
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                Bundle enviar = new Bundle();
                enviar.putInt("lineas", response.length());
                enviar.putStringArray("precio_operacion", precios_operaciones);
                enviar.putStringArray("precio_inicial", precios_iniciales);
                enviar.putStringArray("precio_final", precios_finales);
                enviar.putStringArray("fecha", fechas);
                enviar.putStringArray("description", descriptions);
                enviar.putStringArray("tipo", tipos);
                enviar.putString("amount", amount);
                enviar.putString("usuario", usuario);
                enviar.putString("email", email);
                fl.setElevation(0);
                fragment.setArguments(enviar);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, fragment);
                transaction.commit();


            }
        }, new Response.ErrorListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onErrorResponse(VolleyError error) {
                Bundle enviar = new Bundle();
                enviar.putInt("lineas", 0);
                enviar.putString("amount", amount);
                enviar.putString("usuario", usuario);
                enviar.putString("email", email);
                fl.setElevation(0);
                fragment.setArguments(enviar);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, fragment);
                transaction.commit();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonArrayRequest);

    }//Envia a Home i se mueve alli

    public void buscarDatosApartados(String URL, String email, Fragment fragment, String amount){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject fila=null;
                String[] precios_operaciones = new String[response.length()];
                String[] precios_iniciales = new String[response.length()];
                String[] precios_finales = new String[response.length()];
                String[] fechas = new String[response.length()];
                String[] descriptions = new String[response.length()];

                for(int i = 0; i<response.length(); i++){
                    try{
                        fila=response.getJSONObject(i);
                        precios_operaciones[i] = fila.getString("cant_operacion");
                        precios_iniciales[i] = fila.getString("cant_inicial");
                        precios_finales[i] = fila.getString("cant_final");
                        fechas[i] = fila.getString("fecha");
                        descriptions[i] = fila.getString("descripcion");
                    }catch(JSONException e){
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                Bundle enviar = new Bundle();
                enviar.putInt("lineas", response.length());
                enviar.putStringArray("precio_operacion", precios_operaciones);
                enviar.putStringArray("precio_inicial", precios_iniciales);
                enviar.putStringArray("precio_final", precios_finales);
                enviar.putStringArray("fecha", fechas);
                enviar.putStringArray("description", descriptions);
                enviar.putString("email", email);
                enviar.putString("dinero", amount);
                fragment.setArguments(enviar);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Bundle enviar = new Bundle();
                enviar.putInt("lineas", 0);
                enviar.putString("email", email);
                enviar.putString("dinero", amount);
                fragment.setArguments(enviar);
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonArrayRequest);

    }//Envia a Apartados

    private void buscarID(String URL, String ID, FrameLayout fl){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                DoHome(ID, fl);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);

    }

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}