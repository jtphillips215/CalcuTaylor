package edu.volstate.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // calculation object
    private Calculation calculation;
    // array list to hold history of calculations
    private ArrayList<String> calcHistory = new ArrayList<>();

    // numbers, operator, and results
    String stringNumber1;
    String stringNumber2;
    String operator;
    double results;

    // text fields to be updated programmatically
    TextView topText;
    TextView operatorText;
    TextView bottomText;

    // buttons user can interact with
    Button clearButton;
    Button percentButton;
    Button divideButton;
    Button multiplyButton;
    Button minusButton;
    Button sevenButton;
    Button eightButton;
    Button nineButton;
    Button addButton;
    Button fourButton;
    Button fiveButton;
    Button sixButton;
    Button equalsButton;
    Button oneButton;
    Button twoButton;
    Button threeButton;
    Button zeroButton;
    Button decimalButton;
    Button historyButton;

    // menu
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringNumber1 = "";
        stringNumber2 = "";
        operator = "";

        // text fields to be updated programmatically
        topText = findViewById(R.id.textTop);
        operatorText = findViewById(R.id.textOperator);
        bottomText = findViewById(R.id.textBottom);

        // buttons user can interact with
        clearButton = findViewById(R.id.buttonClear);
        percentButton = findViewById(R.id.buttonPercent);
        divideButton = findViewById(R.id.buttonDivide);
        multiplyButton = findViewById(R.id.buttonMultiply);
        minusButton = findViewById(R.id.buttonMinus);
        sevenButton = findViewById(R.id.buttonSeven);
        eightButton = findViewById(R.id.buttonEight);
        nineButton = findViewById(R.id.buttonNine);
        addButton = findViewById(R.id.buttonAdd);
        fourButton = findViewById(R.id.buttonFour);
        fiveButton = findViewById(R.id.buttonFive);
        sixButton = findViewById(R.id.buttonSix);
        equalsButton = findViewById(R.id.buttonEquals);
        oneButton = findViewById(R.id.buttonOne);
        twoButton = findViewById(R.id.buttonTwo);
        threeButton = findViewById(R.id.buttonThree);
        zeroButton = findViewById(R.id.buttonZero);
        decimalButton = findViewById(R.id.buttonDecimal);
        historyButton = findViewById(R.id.history);

        // on click listeners for each button
        // all listeners update UI
        clearButton.setOnClickListener(view -> {
            stringNumber1 = "";
            stringNumber2 = "";
            operator = "";
            updateUI();
        });

        percentButton.setOnClickListener(view -> {
            operator = "%";
            updateUI();
        });

        divideButton.setOnClickListener(view -> {
            operator = "/";
            updateUI();
        });

        multiplyButton.setOnClickListener(view -> {
            operator = "X";
            updateUI();
        });

        minusButton.setOnClickListener(view -> {
            operator = "-";
            updateUI();
        });

        addButton.setOnClickListener(view -> {
            operator = "+";
            updateUI();
        });

        // equals calls function to calculate results, add results to history, and updates ui
        equalsButton.setOnClickListener(view -> {
            if (operator.equals("/") && Double.parseDouble(stringNumber2) == 0) {
                topText.setText(R.string.div_by_zero);
                operatorText.setText("");
                bottomText.setText("");
            }
            else if (!stringNumber1.equals("") && !stringNumber2.equals("") && !operator.equals("")) {
                calculation = new Calculation();
                calculation.setResults(Double.parseDouble(stringNumber1),
                        Double.parseDouble(stringNumber2), operator);
                results = calculation.getResults();
                calcHistory.add(String.format("%s %s %s = %s", stringNumber1, operator,
                        stringNumber2, String.valueOf(results)));
                displayResults();
                resetValues();
            }
        });

        zeroButton.setOnClickListener(view -> {
            if (operator.equals("")) {
                stringNumber1 += "0";
            } else {
                stringNumber2 += "0";
            }
            updateUI();
        });

        oneButton.setOnClickListener(view -> {
            if (operator.equals("")) {
                stringNumber1 += "1";
            } else {
                stringNumber2 += "1";
            }
            updateUI();
        });

        twoButton.setOnClickListener(view -> {
            if (operator.equals("")) {
                stringNumber1 += "2";
            } else {
                stringNumber2 += "2";
            }
            updateUI();
        });

        threeButton.setOnClickListener(view -> {
            if (operator.equals("")) {
                stringNumber1 += "3";
            } else {
                stringNumber2 += "3";
            }
            updateUI();
        });

        fourButton.setOnClickListener(view -> {
            if (operator.equals("")) {
                stringNumber1 += "4";
            } else {
                stringNumber2 += "5";
            }
            updateUI();
        });

        fiveButton.setOnClickListener(view -> {
            if (operator.equals("")) {
                stringNumber1 += "5";
            } else {
                stringNumber2 += "5";
            }
            updateUI();
        });

        sixButton.setOnClickListener(view -> {
            if (operator.equals("")) {
                stringNumber1 += "6";
            } else {
                stringNumber2 += "6";
            }
            updateUI();
        });

        sevenButton.setOnClickListener(view -> {
            if (operator.equals("")) {
                stringNumber1 += "7";
            }
            else {
                stringNumber2 += "7";
            }
            updateUI();
        });

        eightButton.setOnClickListener(view -> {
            if (operator.equals("")) {
                stringNumber1 += "8";
            } else {
                stringNumber2 += "8";
            }
            updateUI();
        });

        nineButton.setOnClickListener(view -> {
            if (operator.equals("")) {
                stringNumber1 += "9";
            } else {
                stringNumber2 += "9";
            }
            updateUI();
        });

        decimalButton.setOnClickListener(view -> {
            if (operator.equals("")) {
                if (!stringNumber1.contains(".")) {
                    stringNumber1 += ".";
                }
            }
            else {
                if (!stringNumber2.contains(".")) {
                    stringNumber2 += ".";
                }
            }
            updateUI();
        });

        // onclick listener creates new intent and passes data to history class and layout
        historyButton.setOnClickListener(view -> {

            Intent intent = new Intent(getBaseContext(), HistoryActivity.class);
            intent.putStringArrayListExtra("history", calcHistory);
            startActivity(intent);
        });
    }

    void updateUI() {
        topText.setText(stringNumber1);
        operatorText.setText(operator);
        bottomText.setText(stringNumber2);
    }

    void displayResults() {
        topText.setText(String.format("%s %s %s =", stringNumber1, operator, stringNumber2));
        // animation on text change
        Animation bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
        topText.startAnimation(bounce);
        operatorText.setText(String.valueOf(results));
        operatorText.startAnimation(bounce);
        Log.d("results", String.format("%s %s %s = %s", stringNumber1, operator,
                stringNumber2, String.valueOf(results)));
        bottomText.setText("");
    }

    void resetValues() {
        stringNumber1 = "";
        stringNumber2 = "";
        operator = "";
    }

    // on create options menu for hamburger menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    // on selecting item in drop down menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        int id = item.getItemId();

        if(id == R.id.action_about) {
            DialogAbout dialogAbout = new DialogAbout();
            dialogAbout.show(getSupportFragmentManager(), "");
            return true;
        }

        if(id == R.id.action_images) {
            DialogImages dialogImages = new DialogImages();
            dialogImages.show(getSupportFragmentManager(), "");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // methods to save our parcel and restore our parcel
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("stringNumber1", topText.getText().toString());
        outState.putString("operator", operatorText.getText().toString());
        outState.putString("stringNumber2", bottomText.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        stringNumber1 = savedInstanceState.getString("stringNumber1");
        operator = savedInstanceState.getString("operator");
        stringNumber2 = savedInstanceState.getString("stringNumber2");
        updateUI();
    }
}