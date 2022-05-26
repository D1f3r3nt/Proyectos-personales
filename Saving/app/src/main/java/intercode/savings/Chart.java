package intercode.savings;

import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Chart extends Fragment {

    TextView email, amount;
    View vista;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Chart() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Chart newInstance(String param1, String param2) {
        Chart fragment = new Chart();
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
        vista = inflater.inflate(R.layout.fragment_chart, container, false);
        email = (TextView) vista.findViewById(R.id.gmail);
        amount = (TextView) vista.findViewById(R.id.dinero);
        String dato_email = getArguments().getString("email");
        String dato_amount = getArguments().getString("dinero");
        email.setText(dato_email);
        amount.setText(dato_amount+"€");
        return vista;
    }
}