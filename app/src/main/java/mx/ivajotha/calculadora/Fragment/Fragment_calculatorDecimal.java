package mx.ivajotha.calculadora.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.ivajotha.calculadora.R;

/**
 * Created by jonathan on 22/06/16.
 */

public class Fragment_calculatorDecimal extends Fragment {

   public static Fragment_calculatorDecimal newInstance(String titulo){

        Fragment_calculatorDecimal f = new Fragment_calculatorDecimal();
        Bundle b = new Bundle();
        b.putString("titulo_key",titulo);
        f.setArguments(b);
        return f;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.calculator_decimal, container, false);

        return v;
    }
}