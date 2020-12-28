package com.veselove.calculatorv10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    StringBuffer sb = new StringBuffer();
    char function;
    int firstOperand;
    int secondOperand;

    private Button button_0;
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_9;
    private Button button_div;
    private Button button_mul;
    private Button button_min;
    private Button button_plus;
    private Button button_equals;
    private Button button_backspace;
    private TextView functionTextView;
    private TextView inputNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_0 = (Button) findViewById(R.id.button0);
        button_1 = (Button) findViewById(R.id.button1);
        button_2 = (Button) findViewById(R.id.button2);
        button_3 = (Button) findViewById(R.id.button3);
        button_4 = (Button) findViewById(R.id.button4);
        button_5 = (Button) findViewById(R.id.button5);
        button_6 = (Button) findViewById(R.id.button6);
        button_7 = (Button) findViewById(R.id.button7);
        button_8 = (Button) findViewById(R.id.button8);
        button_9 = (Button) findViewById(R.id.button9);
        button_div = (Button) findViewById(R.id.button_div);
        button_mul = (Button) findViewById(R.id.button_mul);
        button_min = (Button) findViewById(R.id.button_minus);
        button_plus = (Button) findViewById(R.id.button_plus);
        button_equals = (Button) findViewById(R.id.button_equals);
        button_backspace = (Button) findViewById(R.id.button_backspace);
        functionTextView = (TextView) findViewById(R.id.functionTextView);
        inputNum = (TextView) findViewById(R.id.inputNum);
    }

    public void buttonClick(View view){
        String inputSymbol = (String) view.getTag();
        if (inputSymbol.matches("\\d")) {
            sb.append(inputSymbol);
            inputNum.setText(sb.toString());
        }

        if (inputSymbol.matches("\\=")) {
            secondOperand = Integer.parseInt(sb.toString());
            int result = (int) calculate(function, firstOperand, secondOperand);
            inputNum.setText(result + "");
            functionTextView.setText(R.string.empty_text);
            firstOperand = 0;
            secondOperand = 0;
            sb.setLength(0);
            sb.append(result);
        }

        if (inputSymbol.matches("clear")) {
            sb.setLength(0);
            inputNum.setText(sb.toString());
            functionTextView.setText(R.string.empty_text);
        }

        if (inputSymbol.matches("backspace")) {
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
                inputNum.setText(sb.toString());
            }
        }

        if (inputSymbol.matches("(\\/)|(\\*)|(\\-)|(\\+)")) {
            if(firstOperand != 0 ) {
                function = inputSymbol.charAt(0);
                secondOperand = Integer.parseInt(sb.toString());
                sb.setLength(0);
                inputNum.setText(sb.toString());
                functionTextView.setText(inputSymbol);  //
            }
            else if (sb.length() != 0) {
                function = inputSymbol.charAt(0);
                firstOperand = Integer.parseInt(sb.toString());
                sb.setLength(0);
                inputNum.setText(sb.toString());
                functionTextView.setText(inputSymbol);
            }
        }
    }

    public double calculate (char function, int firstOperand, int secondOperand) {
        double result = 0;
        switch (function) {
            case '/':
                try {
                    result = firstOperand / secondOperand;
                } catch (ArithmeticException e) {
                    Toast.makeText(MainActivity.this, R.string.divide_by_zero_err, Toast.LENGTH_SHORT).show();
                }
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '+':
                result = firstOperand + secondOperand;
                break;
        }
        return result;
    }
}