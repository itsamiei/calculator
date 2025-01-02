package com.example.calculator;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private String input = "";
    private String operator = "";
    private double num1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tv_result);


        findViewById(R.id.btn_0).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_1).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_2).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_3).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_4).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_5).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_6).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_7).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_8).setOnClickListener(this::onNumberClick);
        findViewById(R.id.btn_9).setOnClickListener(this::onNumberClick);


        findViewById(R.id.btn_add).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.btn_subtract).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.btn_multiply).setOnClickListener(this::onOperatorClick);
        findViewById(R.id.btn_divide).setOnClickListener(this::onOperatorClick);


        findViewById(R.id.btn_clear).setOnClickListener(view -> {
            input = "";
            num1 = 0;
            operator = "";
            tvResult.setText("0");
        });


        findViewById(R.id.btn_equal).setOnClickListener(this::onEqualClick);
    }

    private void onNumberClick(View view) {
        Button button = (Button) view;
        input += button.getText().toString();
        tvResult.setText(input);
    }

    private void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        if (!input.isEmpty()) {
            num1 = Double.parseDouble(input);
        }
        input = "";
    }

    private void onEqualClick(View view) {
        if (input.isEmpty() || operator.isEmpty()) {
            return;
        }

        double num2 = Double.parseDouble(input);
        double result = 0;


        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "×":
                result = num1 * num2;
                break;
            case "÷":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    tvResult.setText("Error");
                    input = "";
                    return;
                }
                break;
        }


        String finalResult;
        if (result == (long) result) {
            finalResult = String.valueOf((long) result);
        } else {
            finalResult = String.valueOf(result);
        }

        tvResult.setText(finalResult);
        input = finalResult;
        operator = "";
    }
}
