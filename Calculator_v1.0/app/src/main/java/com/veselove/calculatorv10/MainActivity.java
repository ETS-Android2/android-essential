package com.veselove.calculatorv10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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

    public void handleDigitButton(View view){
        String inputSymbol = (String) view.getTag();
        sb.append(inputSymbol);
        binding.inputNum.setText(sb.toString());
    }

    public void handleFunctionButton(View view){
        String inputSymbol = (String) view.getTag();
        switch (inputSymbol) {
            case "/":
            case "*":
            case "-":
            case "+":
                handleFunction(view);
                break;
            case "clear":
                clearInput();
                break;
            case "backspace":
                trimInput();
                break;
            case "=":
                calculate();
                break;

        }
    }

    public void handleFunction(View view) {
        String inputSymbol = (String) view.getTag();
        if(firstOperand != 0) {
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

    public void clearInput() {
        sb.setLength(0);
        binding.inputNum.setText(sb.toString());
        binding.functionTextView.setText(R.string.empty_text);
    }

    public void trimInput() {
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
            binding.inputNum.setText(sb.toString());
        }
    }

    public void calculate() {
        if (sb.length() == 0) {
            return;
        }
        secondOperand = Integer.parseInt(sb.toString());
        int result = 0;
        if (secondOperand != 0) {
            result = (int) Logic.calculate(function, firstOperand, secondOperand);
        } else {
            Toast.makeText(MainActivity.this, R.string.divide_by_zero_err, Toast.LENGTH_SHORT).show();
        }
        binding.inputNum.setText(result + "");
        binding.functionTextView.setText(R.string.empty_text);
        firstOperand = 0;
        secondOperand = 0;
        sb.setLength(0);
        sb.append(result);
    }
}