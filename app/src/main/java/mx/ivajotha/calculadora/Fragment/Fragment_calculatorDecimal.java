package mx.ivajotha.calculadora.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.ivajotha.calculadora.R;

/**
 * Created by jonathan on 22/06/16.
 */

public class Fragment_calculatorDecimal extends Fragment {

    private String operator, stringOper;
    private EditText display;
    private Button zero, one, two, three, four, five, six, seven, eight, nine, point ,div, sub, mul, add, equal, mod;
    private float num1, num2;
    private boolean endOp, oper_div, last_num;

    public static Fragment_calculatorDecimal newInstance(String titulo){

        Bundle b = new Bundle();

        Fragment_calculatorDecimal f = new Fragment_calculatorDecimal();
        b.putString("titulo_key",titulo);
        f.setArguments(b);
        return f;
    }


    public void splidOperator(String string, String oper, String typeSet) {
        String[] parts = string.split(oper);
    }


    public void setOperation() {
        if (operator.equals("+")) {

            stringOper = display.getText().toString();
            String[] parts = stringOper.split("\\" + operator);
            num1 = Float.parseFloat(parts[0]);
            num2 = Float.parseFloat(parts[1]);
            num1 = num1 + num2;

            /** Valida Infinity y NaN **/
            double d = (double) num1;

            if(Double.isInfinite(d) || Double.isNaN(d)){
                display.setText("0");
            }else{
                display.setText(Float.toString(num1));
            }


        } else if (operator.equals("-")) {

            stringOper = display.getText().toString();
            String[] parts = stringOper.split("\\" + operator);
            num1 = Float.parseFloat(parts[0]);
            num2 = Float.parseFloat(parts[1]);
            num1 = num1 - num2;

            /** Valida Infinity y NaN **/
            double d = (double) num1;

            if(Double.isInfinite(d) || Double.isNaN(d)){
                display.setText("0");
            }else{
                display.setText(Float.toString(num1));
            }

        } else if (operator.equals("*")) {

            stringOper = display.getText().toString();
            String[] parts = stringOper.split("\\" + operator);
            num1 = Float.parseFloat(parts[0]);
            num2 = Float.parseFloat(parts[1]);
            num1 = num1 * num2;

            /** Valida Infinity y NaN **/
            double d = (double) num1;

            if(Double.isInfinite(d) || Double.isNaN(d)){
                display.setText("0");
            }else{
                display.setText(Float.toString(num1));
            }

        } else if (operator.equals("/")) {

                stringOper = display.getText().toString();
                String[] parts = stringOper.split(operator);
                num1 = Float.parseFloat(parts[0]);
                num2 = Float.parseFloat(parts[1]);
                num1 = num1 / num2;

                /** Valida Infinity y NaN **/
                double d = (double) num1;

                if(Double.isInfinite(d) || Double.isNaN(d)){
                    display.setText("0");
                }else{
                    display.setText(Float.toString(num1));
                }


        } else if (operator.equals("mod")) {

            stringOper = display.getText().toString();
            String[] parts = stringOper.split(operator);
            num1 = Float.parseFloat(parts[0]);
            num2 = Float.parseFloat(parts[1]);
            num1 = num1%num2;

            /** Valida Infinity y NaN **/
            double d = (double) num1;

            if(Double.isInfinite(d) || Double.isNaN(d)){
                display.setText("0");
            }else{
                display.setText(Float.toString(num1));
            }
        }
    }

    /** Click btn Number**/
    View.OnClickListener clickNumber = new View.OnClickListener() {
        public void onClick(View view) {
            Button b = (Button)view;
            Editable str = display.getText();

            if(endOp){
                display.setText("");
                str = display.getText();
                last_num = true;
                oper_div = false;
                endOp = false;
            }else{
                last_num = true;
            }

            str = str.append(b.getText().toString());
            display.setText(str);


        }
    };

    /** Click btn Operator**/
    View.OnClickListener clickOperator = new View.OnClickListener() {
        public void onClick(View view) {
            if (!oper_div && last_num) {
                Button b = (Button)view;
                Editable str = display.getText();
                str = str.append(b.getText().toString());
                display.setText(str);
                oper_div = true;
                last_num = false;
                endOp = false;
                operator = b.getText().toString();
            }
        }
    };

    View.OnClickListener clicResult = new View.OnClickListener() {
        public void onClick(View view) {
            if (oper_div && last_num){
                setOperation();
                oper_div = false;
                last_num = true;
                endOp = true;
                operator = "";
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.calculator_decimal, container, false);

        display = (EditText) v.findViewById(R.id.displayOperations);

        zero = (Button) v.findViewById(R.id.num_0);
        one = (Button) v.findViewById(R.id.num_1);
        two = (Button) v.findViewById(R.id.num_2);
        three = (Button) v.findViewById(R.id.num_3);
        four= (Button) v.findViewById(R.id.num_4);
        five = (Button) v.findViewById(R.id.num_5);
        six = (Button) v.findViewById(R.id.num_6);
        seven = (Button) v.findViewById(R.id.num_7);
        eight = (Button) v.findViewById(R.id.num_8);
        nine = (Button) v.findViewById(R.id.num_9);
        point = (Button) v.findViewById(R.id.btn_point);
        equal = (Button) v.findViewById(R.id.btn_equal);

        sub = (Button) v.findViewById(R.id.oper_rest);
        div = (Button) v.findViewById(R.id.oper_div);
        mul = (Button) v.findViewById(R.id.oper_mul);
        add = (Button) v.findViewById(R.id.oper_mas);
        mod = (Button) v.findViewById(R.id.oper_mod);


        zero.setOnClickListener(clickNumber);
        one.setOnClickListener(clickNumber);
        two.setOnClickListener(clickNumber);
        three.setOnClickListener(clickNumber);
        four.setOnClickListener(clickNumber);
        five.setOnClickListener(clickNumber);
        six.setOnClickListener(clickNumber);
        seven.setOnClickListener(clickNumber);
        eight.setOnClickListener(clickNumber);
        nine.setOnClickListener(clickNumber);

        equal.setOnClickListener(clicResult);
        sub.setOnClickListener(clickOperator);
        add.setOnClickListener(clickOperator);
        mul.setOnClickListener(clickOperator);
        div.setOnClickListener(clickOperator);
        mod.setOnClickListener(clickOperator);


        return v;
    }
}