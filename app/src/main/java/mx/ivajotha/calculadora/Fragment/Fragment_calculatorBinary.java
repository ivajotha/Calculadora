package mx.ivajotha.calculadora.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import mx.ivajotha.calculadora.R;

/**
 * Created by jonathan on 24/06/16.
 */
public class Fragment_calculatorBinary extends Fragment {

    private String operator, stringOper;
    private EditText display;
    private Button zero, one, two, three, four, five, six, seven, eight, nine, add, equal;
    private boolean endOp, oper_div, last_num;
    private Integer num1, num2;


    public static Fragment_calculatorBinary newInstance(String titulo) {
        
        Bundle args = new Bundle();
        Fragment_calculatorBinary fragment = new Fragment_calculatorBinary();
        args.putString("titulo_key",titulo);
        fragment.setArguments(args);
        return fragment;
    }

    /* converción a Binario*/
    public static long toBinary(int n)
    {
        String b = "";
        while (n != 0) {
            int r = (int)(n % 2);
            b = r + b;
            n /= 2;
        }
        return Long.parseLong(b);
    }

    /** Realiza la uperiacin de SUMA **/
    public void setOperation() {
            stringOper = display.getText().toString();
            String[] parts = stringOper.split("\\" + operator);
            num1 = Integer.parseInt(parts[0]);
            num2 = Integer.parseInt(parts[1]);
            String tbinary_ = Long.toString(toBinary(num1 + num2));
            display.setText(tbinary_);

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
                last_num = false;
                endOp = true;
                operator = "";
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.calculator_binary, container, false);

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
        equal = (Button) v.findViewById(R.id.btn_equal);

        add = (Button) v.findViewById(R.id.oper_mas);


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
        add.setOnClickListener(clickOperator);
        display.setText("");

        return v;
    }
}
