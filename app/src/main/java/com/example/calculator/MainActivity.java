package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int firstNum, secondNum;
    char lastOperator;
    int enterToken = 0;     // 0 = input is a new number, 1 = input is multi-digit number
    int numberToken = 1;    // determines if the first or second number in the calculation is being entered


    public class NumListener implements View.OnClickListener {

        TextView res = findViewById(R.id.result);
        @Override
        public void onClick(View view) {
            String buttonVal = ((Button)view).getText().toString();
            if (enterToken == 0) {
                if (numberToken == 1) {
                    enterToken = 1;
                    res.setText(buttonVal);
                    firstNum = Integer.parseInt(res.getText().toString());
                }
                else if (numberToken == 2) {
                    enterToken = 1;
                    res.setText(buttonVal);
                    secondNum = Integer.parseInt(res.getText().toString());
                }
            }
            else if (enterToken == 1) {
                if (numberToken == 1) {
                    String newRes = res.getText().toString() + buttonVal;
                    res.setText(newRes);
                    firstNum = Integer.parseInt(res.getText().toString());
                }
                else if (numberToken == 2) {
                    String newRes = res.getText().toString() + buttonVal;
                    res.setText(newRes);
                    secondNum = Integer.parseInt(res.getText().toString());
                }
            }
        }
    }


    public int calculate(char op, int firstNum, int secondNum) {

        int result = 0;
        if (op == '+') {
            result = firstNum + secondNum;
        }
        else if (op == '-') {
            result = firstNum - secondNum;
        }
        return result;
    }


    public void setDarkTheme() {
        findViewById(R.id.root_layout).setBackgroundResource(R.color.dark_main);
        findViewById(R.id.result).setBackgroundResource(R.color.dark_main);
        findViewById(R.id.result).setBackgroundResource(R.drawable.border);
        findViewById(R.id.num0).setBackgroundColor(getColor(R.color.dark_button1));
        findViewById(R.id.num1).setBackgroundColor(getColor(R.color.dark_button1));
        findViewById(R.id.num2).setBackgroundColor(getColor(R.color.dark_button1));
        findViewById(R.id.num3).setBackgroundColor(getColor(R.color.dark_button1));
        findViewById(R.id.num4).setBackgroundColor(getColor(R.color.dark_button1));
        findViewById(R.id.num5).setBackgroundColor(getColor(R.color.dark_button1));
        findViewById(R.id.num6).setBackgroundColor(getColor(R.color.dark_button1));
        findViewById(R.id.num7).setBackgroundColor(getColor(R.color.dark_button1));
        findViewById(R.id.num8).setBackgroundColor(getColor(R.color.dark_button1));
        findViewById(R.id.num9).setBackgroundColor(getColor(R.color.dark_button1));
        findViewById(R.id.plus).setBackgroundColor(getColor(R.color.dark_button2));
        findViewById(R.id.minus).setBackgroundColor(getColor(R.color.dark_button2));
        findViewById(R.id.equals).setBackgroundColor(getColor(R.color.dark_button2));
        findViewById(R.id.ce).setBackgroundColor(getColor(R.color.dark_button2));
    }

    public void setLightTheme() {
        findViewById(R.id.root_layout).setBackgroundResource(R.color.light_main);
        findViewById(R.id.result).setBackgroundResource(R.color.light_submain);
        findViewById(R.id.result).setBackgroundResource(R.drawable.border);
        findViewById(R.id.num0).setBackgroundColor(getColor(R.color.light_button1));
        findViewById(R.id.num1).setBackgroundColor(getColor(R.color.light_button1));
        findViewById(R.id.num2).setBackgroundColor(getColor(R.color.light_button1));
        findViewById(R.id.num3).setBackgroundColor(getColor(R.color.light_button1));
        findViewById(R.id.num4).setBackgroundColor(getColor(R.color.light_button1));
        findViewById(R.id.num5).setBackgroundColor(getColor(R.color.light_button1));
        findViewById(R.id.num6).setBackgroundColor(getColor(R.color.light_button1));
        findViewById(R.id.num7).setBackgroundColor(getColor(R.color.light_button1));
        findViewById(R.id.num8).setBackgroundColor(getColor(R.color.light_button1));
        findViewById(R.id.num9).setBackgroundColor(getColor(R.color.light_button1));
        findViewById(R.id.plus).setBackgroundColor(getColor(R.color.light_button2));
        findViewById(R.id.minus).setBackgroundColor(getColor(R.color.light_button2));
        findViewById(R.id.equals).setBackgroundColor(getColor(R.color.light_button2));
        findViewById(R.id.ce).setBackgroundColor(getColor(R.color.light_button2));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView res = findViewById(R.id.result);
        getSupportActionBar().hide();


        //Dark Theme
        Switch darkTheme = findViewById(R.id.darktheme);
        darkTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    setDarkTheme();
                }
                else {
                    setLightTheme();
                }
            }
        });

        //Num-Buttons
        NumListener enterNum = new NumListener();
        findViewById(R.id.num0).setOnClickListener(enterNum);
        findViewById(R.id.num1).setOnClickListener(enterNum);
        findViewById(R.id.num2).setOnClickListener(enterNum);
        findViewById(R.id.num3).setOnClickListener(enterNum);
        findViewById(R.id.num4).setOnClickListener(enterNum);
        findViewById(R.id.num5).setOnClickListener(enterNum);
        findViewById(R.id.num6).setOnClickListener(enterNum);
        findViewById(R.id.num7).setOnClickListener(enterNum);
        findViewById(R.id.num8).setOnClickListener(enterNum);
        findViewById(R.id.num9).setOnClickListener(enterNum);

        //OPERATORS
        findViewById(R.id.plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberToken == 2) {
                    firstNum = calculate(lastOperator, firstNum, secondNum);
                    res.setText("0");
                    lastOperator = '+';
                    enterToken = 0;
                }
                else if (numberToken == 1) {
                    res.setText("0");
                    lastOperator = '+';
                    enterToken = 0;
                    numberToken = 2;
                }}
        });


        findViewById(R.id.minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberToken == 2) {
                    firstNum = calculate(lastOperator, firstNum, secondNum);
                    res.setText("0");
                    lastOperator = '-';
                    enterToken = 0;
                }
                else if (numberToken == 1) {
                    res.setText("0");
                    lastOperator = '-';
                    enterToken = 0;
                    numberToken = 2;
                }}
        });


        findViewById(R.id.equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String calcedResult = Integer.toString(calculate(lastOperator, firstNum, secondNum));
                res.setText(calcedResult);
                enterToken = 0;
            }
        });


        findViewById(R.id.ce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.setText("0");
                enterToken = 0;
                numberToken = 1;
            }
        });

    }
}