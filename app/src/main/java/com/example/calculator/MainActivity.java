package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView result ;
    Button buttonOne;
    Button buttonTwo;
    Button buttonThree;
    Button buttonFour;
    Button buttonFive;
    Button buttonSix;
    Button buttonSeven;
    Button buttonEight;
    Button buttonNine;
    Button buttonZero;
    Button buttonAdd;
    Button buttonSub;
    Button buttonMulty;
    Button buttonDivision;
    Button buttonC;
    Button buttonClose;

    float number = 0;

    float equals = 0;
    String s ;
    char opeartor = '0';
    int index = 0 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        result= findViewById(R.id.TextCalc);
        buttonOne= findViewById(R.id.ButtonOne);
        buttonTwo = findViewById(R.id.ButtonTwo);
        buttonThree= findViewById(R.id.ButtonThree);
        buttonFour = findViewById(R.id.ButtonFour);
        buttonFive = findViewById(R.id.ButtonFive);
        buttonSix = findViewById(R.id.ButtonSix);
        buttonSeven = findViewById(R.id.ButtonSeven);
        buttonEight = findViewById(R.id.ButtonEighn);
        buttonNine = findViewById(R.id.ButtonNine);
        buttonZero = findViewById(R.id.buttonZero);
        buttonAdd = findViewById(R.id.ButtonAdd);
        buttonSub= findViewById(R.id.ButtonSubtract);
        buttonMulty = findViewById(R.id.ButtonMulty);
        buttonDivision = findViewById(R.id.ButtonDivision);
        buttonC = findViewById(R.id.ButtonC);
        buttonClose = findViewById(R.id.ButtonClose);

        result.setText("0");

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcButton(buttonOne);
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcButton(buttonTwo);
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcButton(buttonThree);
            }

        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcButton(buttonFour);
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcButton(buttonFive);
            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcButton(buttonSix);
            }
        });
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcButton(buttonSeven);
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcButton(buttonEight);
            }
        });
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcButton(buttonNine);
            }
        });
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcButton(buttonZero);
            }

        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( opeartor=='0'){
                    funcEquals(buttonAdd);
                }
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcEquals(buttonSub);
            }
        });
        buttonMulty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcEquals(buttonMulty);
            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcEquals(buttonDivision);
            }
        });
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcEquals(buttonDivision);
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("0");
            }
        });

    }

    public void funcButton(View view) {
        Button button = (Button) view;
        String resultText = result.getText().toString();
        if (resultText.equals("0")){
            result.setText("");
        }
        result.append(button.getText().toString());
    }


    public void funcEquals(View view) {
        Button button =(Button) view;
        char ch = button.getText().toString().charAt(0);
        String resultText = result.getText().toString();
       number= Integer.parseInt(resultText);// число которое ввели

        switch (ch){
            case '+' :
                if (opeartor == '0'){
                    index = resultText.indexOf("+");
                    opeartor = '+';
                    s = String.valueOf(result.getText().toString().charAt(index));
                    number += Float.parseFloat(s);
                }
                else {
                    index = resultText.indexOf("+",index);
                    //secondNumber=result.getText().toString().charAt(index)+1;// от старого плюса  до конца
                   // number+=secondNumber;

                }


            case '-' :

            case '*' :

            case '/' :

            case '=' :
        }
        result.append(button.getText().toString());


    }
}