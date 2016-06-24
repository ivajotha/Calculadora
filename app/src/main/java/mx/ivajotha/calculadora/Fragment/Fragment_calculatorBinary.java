package mx.ivajotha.calculadora.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
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


    public static Fragment_calculatorBinary newInstance(String titulo) {
        
        Bundle args = new Bundle();
        Fragment_calculatorBinary fragment = new Fragment_calculatorBinary();
        args.putString("titulo_key",titulo);
        fragment.setArguments(args);
        return fragment;
    }

    public static int binaryToDecimal(String numeroBinario){
        int longitud = numeroBinario.length();
        int resultado = 0;
        int potencia = longitud - 1;
            for(int i = 0;i < longitud;i++){
                if(numeroBinario.charAt(i) == '1'){
                    resultado += Math.pow(2,potencia);
                } potencia --;
            }
        return resultado;
    }

    public  String operacionBinaria(char operador,String numero1, String numero2){
        int n1Decimal = binaryToDecimal(numero1);
        int n2Decimal = binaryToDecimal(numero2);

            return (decimalToBinary(n1Decimal + n2Decimal));
    }

    public String decimalToBinary(int numeroDecimal){
        int temp = numeroDecimal;
        String resultado = "";
        while (temp != 0){
            if(temp % 2 == 0){
                resultado = "0" + resultado;
            }else{
                resultado = "1" + resultado;
            }
            temp = temp / 2;
        }
        return resultado;
    }

    public void setOperation() {
        if (operator.equals("+")) {

            stringOper = display.getText().toString();
            String[] parts = stringOper.split("\\" + operator);
            String resultado = operacionBinaria('+',parts[0],parts[1]);
            display.setText(resultado);
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

        return v;
    }
}
