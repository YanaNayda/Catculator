package com.example.calculator;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView result;
    TextView history;

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
    Button buttonDelete;
    Button buttonEquals;
    Button buttonMeow;
    Button buttonPercent;
    Button buttonPoint;

    ImageView image_meow_top;
    ImageView image_meow_right;
    ImageView image_meow_left;
    ImageView image_mouse;
    ImageView image_paw;

    MediaPlayer cat_voice_1;
    MediaPlayer cat_voice_2;


    float number = 0;
    String error = "Meow!Error!";
    char opeartor = '0';
    String[] parts;




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

        result = findViewById(R.id.TextCalc);
        history = findViewById(R.id.textHistory);

        buttonOne = findViewById(R.id.ButtonOne);
        buttonTwo = findViewById(R.id.ButtonTwo);
        buttonThree = findViewById(R.id.ButtonThree);
        buttonFour = findViewById(R.id.ButtonFour);
        buttonFive = findViewById(R.id.ButtonFive);
        buttonSix = findViewById(R.id.ButtonSix);
        buttonSeven = findViewById(R.id.ButtonSeven);
        buttonEight = findViewById(R.id.ButtonEight);
        buttonNine = findViewById(R.id.ButtonNine);
        buttonZero = findViewById(R.id.buttonZero);

        buttonAdd = findViewById(R.id.ButtonAdd);
        buttonSub = findViewById(R.id.ButtonSubtract);
        buttonMulty = findViewById(R.id.ButtonMulty);
        buttonDivision = findViewById(R.id.ButtonDivision);
        buttonC = findViewById(R.id.ButtonC);
        buttonDelete = findViewById(R.id.ButtonDelete);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonMeow = findViewById(R.id.buttonMeow);
        buttonPoint = findViewById(R.id.buttonPoint);
        buttonPercent = findViewById(R.id.buttonPercent);

        image_meow_right= findViewById(R.id.image_meow_right);
        image_meow_left= findViewById(R.id.image_meow_left);
        image_meow_top= findViewById(R.id.image_meow_top);
        image_mouse= findViewById(R.id.image_mouse);
        image_paw= findViewById(R.id.image_paw_black);

        cat_voice_1= MediaPlayer.create(this,R.raw.cat_voice);
        cat_voice_2= MediaPlayer.create(this,R.raw.cat_voice_second);


        Animation animBlink = AnimationUtils.loadAnimation(this, R.anim.blink_animation);
        Animation animRotation = AnimationUtils.loadAnimation(this, R.anim.rotate__mouse_animation);
        Animation animRotationPaw = AnimationUtils.loadAnimation(this, R.anim.rotate_paw);



        result.setText("MeowСalculator");
        result.setText("0");
        history.setText("Result");
        history.setText("");
       image_meow_top.setVisibility(image_meow_top.INVISIBLE);
       image_meow_right.setVisibility(image_meow_right.INVISIBLE);
       image_meow_left.setVisibility(image_meow_left.INVISIBLE);
       image_mouse.setVisibility(image_mouse.INVISIBLE);

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
                    funcEquals(buttonAdd);
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
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcButton(buttonDelete);
            }
        });
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcEquals(buttonEquals);
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_paw.startAnimation(animRotationPaw);

                number = 0;
                opeartor = '0';
                result.setText("0");
                history.setText("");
            }
        });
        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcEquals(buttonPercent);
            }
        });
        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                funcButton(buttonPoint);
            }
        });
        buttonMeow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cat_voice_1.start();

                //Start voice and animation
                image_meow_top.startAnimation(animBlink);

                //Delay for animation  and voice
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        image_meow_right.startAnimation(animBlink);
                        cat_voice_2.start();
                    }
                }, 1000);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        image_meow_left.startAnimation(animBlink);
                    }
                }, 750);

                //Start anomation
                image_mouse.startAnimation(animRotation);
                image_meow_top.setVisibility(image_meow_top.INVISIBLE);
                image_meow_right.setVisibility(image_meow_right.INVISIBLE);
                image_meow_left.setVisibility(image_meow_left.INVISIBLE);
                image_mouse.setVisibility(image_mouse.INVISIBLE);


            }
        });

    }


    public void funcButton(View view) {
        Button button = (Button) view;
        String resultText = result.getText().toString();
        String newNumberFromButton = button.getText().toString();
        history.setText("0");


        //Check if result is too long
        if (resultText.length() > 20) {
            result.setText(error);
            return;
        }



        //Check if Button is Delete
        if (newNumberFromButton.equals("Del")) {
            if (resultText.length() > 1) {
                result.setText(resultText.substring(0, resultText.length() - 1));
            }
            else {

                result.setText("0");
            }
            return;
        }


        // check if it was error
        if (resultText.equals(error)) {
            result.setText("");
        }


        //Separation of numbers with symbols
        parts = result.getText().toString().split("\\+|\\-|\\/|\\*|\\%");



        //Check if Button is Point and if  the number already have a point
        if (newNumberFromButton.equals(".")) {
            if (parts.length > 0 && !parts[parts.length - 1].contains(".")) {
                result.append(newNumberFromButton);
            }
        }
        else {

            //Check if we need to remove a zero before a number( 05 -> 5)
            if (parts.length > 0 && parts[parts.length - 1].startsWith("0") && parts[parts.length - 1].length() > 1 && !parts[parts.length - 1].contains(".")) {
                result.setText(resultText.substring(0, result.getText().toString().length() - parts[parts.length - 1].length()) +
                        parts[parts.length - 1].substring(1));
                result.append(newNumberFromButton);
            }
            else{

                if (parts.length == 2 && parts[parts.length - 1].startsWith("0") && parts[parts.length - 1].length() >= 1 && !parts[parts.length - 1].contains(".") ){
                    result.setText(resultText.substring(0, result.getText().toString().length() - parts[parts.length - 1].length()) +
                            parts[parts.length - 1].substring(1));
                    result.append(newNumberFromButton);
                }
                else {

                    //Set text if in result was zeero and number is not zero
                    if (resultText.equals("0") && (!newNumberFromButton.equals("0") || !resultText.equals("")) && !newNumberFromButton.equals("Del")) {
                        result.setText(newNumberFromButton);
                    }
                    else {

                        if (resultText.equals("0") && newNumberFromButton.equals("0")) {
                            result.setText(newNumberFromButton);
                        }
                        else {
                            //Add a number to result
                            result.append(newNumberFromButton);
                        }
                    }
                }
            }
        }
    }

    public void funcEquals(View view) {

        Button button = (Button) view;
        char newNumberFromButton = button.getText().toString().charAt(0);
        float secondNumber = 0;

       //Remove error messsage
        if (result.getText().toString().equals(error)) {
            result.setText("");
        }

       //Separate numbers with symbols
        parts = result.getText().toString().split("\\+|\\-|\\/|\\*|\\%");

       //Check if we need to remove a zero before a number( 05 -> 5)
        if ((newNumberFromButton != '=' && parts.length < 2 ) || (newNumberFromButton != '=' && parts.length<=2 && parts[0].equals(""))) {
            if (!Character.isDigit(result.getText().toString().charAt(result.getText().toString().length() - 1))) {
                result.setText(result.getText().toString().substring(0, result.length() - 1) + newNumberFromButton);
            }

            else {
                // Add a number to result
                result.append(String.valueOf(newNumberFromButton));

            }
            opeartor = newNumberFromButton;
        }

        else {
            //Check if it two parts of string or three (it could be with use "-" with  first number)
            if (parts.length == 2 || (parts.length==3 && parts[0].equals(""))) {

                //Two parts of string
                if (parts.length==2){
                    if (parts[0].equals("")) {
                        result.setText(error);
                        return;
                    }
                    number = Float.parseFloat(parts[0]);
                }

                //Three parts of string -> with use "-" with  first number
                if(parts.length==3){
                    number = Float.parseFloat( parts[1]);
                    number=(-1)*number;
                }

                 //Inizialization of second number
                if (parts.length > 1) {
                    secondNumber = Float.parseFloat(parts[parts.length-1]);

                    //Use operators
                    switch (opeartor) {
                        case '+':
                            number += secondNumber;
                            break;
                        case '-':
                            number -= secondNumber;
                            break;
                        case '*':
                            number *= secondNumber;
                            break;
                        case '/':
                            if (parts[parts.length - 1].equals("0")) {
                                result.setText(error);
                                number = 0;
                            } else {
                                number = number / secondNumber;
                            }
                            break;
                        case '%':
                            number = number / 100;
                            break;
                    }
                    opeartor = button.getText().toString().charAt(0);


                    if (result.getText().toString().isEmpty()) {
                        result.setText(error);
                    }
                    else {
                        //Update history
                        history.setText(result.getText().toString());

                        //Result is integer
                        if (number == (int) number) {
                            result.setText(String.valueOf((int) number));
                        }

                        else {
                            //Result in float , but the end  is "0"
                            if ((number % 1 == 0)) {
                                result.setText(result.getText().toString().substring(0, result.length() - 1));

                            }
                            else {
                                //Add a result
                                result.setText(String.valueOf(number));
                            }

                        }
                        //Add the operator
                        if (opeartor != '=') {
                            result.append(String.valueOf(opeartor));
                        }


                    }

                }


            }

        }
    }
}