package mx.ivajotha.calculadora.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.ivajotha.calculadora.R;

/**
 * Created by jonathan on 24/06/16.
 */
public class Fragment_calculatorBinary extends Fragment {



    public static Fragment_calculatorBinary newInstance(String titulo) {
        
        Bundle args = new Bundle();
        Fragment_calculatorBinary fragment = new Fragment_calculatorBinary();
        args.putString("titulo_key",titulo);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.calculator_binary, container, false);
        return v;
    }
}
