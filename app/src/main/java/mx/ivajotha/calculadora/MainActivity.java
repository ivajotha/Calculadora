package mx.ivajotha.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.getBoxBinari).setOnClickListener(this);
        findViewById(R.id.getBoxDecimal).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.getBoxBinari:
                Toast.makeText(getApplicationContext(),"Binario",Toast.LENGTH_SHORT).show();
                break;

            case R.id.getBoxDecimal:
                Toast.makeText(getApplicationContext(),"Decimal",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
