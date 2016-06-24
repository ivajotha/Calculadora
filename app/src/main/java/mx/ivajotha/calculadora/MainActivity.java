package mx.ivajotha.calculadora;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import mx.ivajotha.calculadora.Fragment.Fragment_calculatorBinary;
import mx.ivajotha.calculadora.Fragment.Fragment_calculatorDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Fragment fragmentdecimal = new Fragment_calculatorDecimal();
    Fragment fragmentbinary = new Fragment_calculatorBinary();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.getBoxBinari).setOnClickListener(this);
        findViewById(R.id.getBoxDecimal).setOnClickListener(this);
        getFragmentManager().beginTransaction().replace(R.id.fragmentMain,fragmentdecimal).commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.getBoxDecimal:
                //Toast.makeText(getApplicationContext(),"Binario",Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.fragmentMain,fragmentdecimal).commit();
                break;

            case R.id.getBoxBinari:
                //Toast.makeText(getApplicationContext(),"Binario",Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.fragmentMain,fragmentbinary).commit();
                break;
        }
    }
}
