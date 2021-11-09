package com.veselove.calculatorv10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.veselove.calculatorv10.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    StringBuffer sb = new StringBuffer();
    char function;
    int firstOperand;
    int secondOperand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }

    public void buttonClick(View view){
        String inputSymbol = (String) view.getTag();
        if (inputSymbol.matches("\\d")) {
            sb.append(inputSymbol);
            binding.inputNum.setText(sb.toString());
        }

        if (inputSymbol.matches("\\=")) {
            secondOperand = Integer.parseInt(sb.toString());
            int result = (int) calculate(function, firstOperand, secondOperand);
            binding.inputNum.setText(result + "");
            binding.functionTextView.setText(R.string.empty_text);
            firstOperand = 0;
            secondOperand = 0;
            sb.setLength(0);
            sb.append(result);
        }

        if (inputSymbol.matches("clear")) {
            sb.setLength(0);
            binding.inputNum.setText(sb.toString());
            binding.functionTextView.setText(R.string.empty_text);
        }

        if (inputSymbol.matches("backspace")) {
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
                binding.inputNum.setText(sb.toString());
            }
        }

        if (inputSymbol.matches("(\\/)|(\\*)|(\\-)|(\\+)")) {
            if(firstOperand != 0 ) {
                function = inputSymbol.charAt(0);
                secondOperand = Integer.parseInt(sb.toString());
                sb.setLength(0);
                binding.inputNum.setText(sb.toString());
                binding.functionTextView.setText(inputSymbol);  //
            }
            else if (sb.length() != 0) {
                function = inputSymbol.charAt(0);
                firstOperand = Integer.parseInt(sb.toString());
                sb.setLength(0);
                binding.inputNum.setText(sb.toString());
                binding.functionTextView.setText(inputSymbol);
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