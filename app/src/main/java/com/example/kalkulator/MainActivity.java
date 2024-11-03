package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.material.button.MaterialButton;
import com.udojava.evalex.Expression;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    public TextView solutionTv;
    public MaterialButton buttonC, buttonBrackOpen, buttonBrackClose;
    public MaterialButton buttonDivide, buttonMultiply, buttonPlus, buttonMinus, buttonEquals;
    public MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    public MaterialButton buttonAC, buttonDot;
    public ArrayList<Button> btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        solutionTv = findViewById(R.id.solution_tv);
        buttonEquals = findViewById(R.id.button_equals);
        buttonC = findViewById(R.id.button_c);
        buttonBrackOpen = findViewById(R.id.button_open_bracket);
        buttonBrackClose = findViewById(R.id.button_close_bracket);
        buttonDivide = findViewById(R.id.button_divide);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        buttonAC = findViewById(R.id.button_ac);
        buttonDot = findViewById(R.id.button_dot);

        btnList = new ArrayList<>();
        btnList.add(buttonDivide);
        btnList.add(buttonMultiply);
        btnList.add(buttonPlus);
        btnList.add(buttonMinus);
        btnList.add(button0);
        btnList.add(button1);
        btnList.add(button2);
        btnList.add(button3);
        btnList.add(button4);
        btnList.add(button5);
        btnList.add(button6);
        btnList.add(button7);
        btnList.add(button8);
        btnList.add(button9);
        btnList.add(buttonAC);
        btnList.add(buttonDot);
        btnList.add(buttonBrackClose);
        btnList.add(buttonBrackOpen);

        for (Button button: btnList) {
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Button btnClicked = (Button) v;
                    String btnText = btnClicked.getText().toString();
                    solutionTv.setText(solutionTv.getText().toString() + btnText);
                }
            });
        }

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solutionTv.setText("");
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String memory = solutionTv.getText().toString();
                    Expression expression = new Expression(memory);
                    String answer = expression.eval().toString();
                    solutionTv.setText(answer);
                } catch (Exception e)  {
                    solutionTv.setText("Error");
                }
            }
        });
    }


}