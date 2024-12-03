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

import org.w3c.dom.Text;

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

    float number = 0;
    String error = "Meow!Error!";
    char opeartor = '0';
    String[] parts;
    String[] partsDigit;


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


        result.setText("MeowСalculator");
        result.setText("0");
        history.setText("Result");
        history.setText("");

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
                result.setText(error);
            }
        });

    }


    public void funcButton(View view) {
        Button button = (Button) view; // Получаем нажатую кнопку.
        String resultText = result.getText().toString(); // Текущий текст в поле вывода результата.
        String newNumberFromButton = button.getText().toString();
        history.setText("0");// Текст нажатой кнопки.

        if (resultText.length() > 20) {
            result.setText(error); // Если длина результата больше 20, устанавливаем сообщение об ошибке.
            return; // Прекращаем выполнение метода.
        }



        if (newNumberFromButton.equals("Del")) {

            if (resultText.length() > 1) {
                result.setText(resultText.substring(0, resultText.length() - 1)); // Удаляем последний символ.
            }
            else {
                result.setText("0"); // Если длина 1, устанавливаем "0".
            }
            return; // Прекращаем выполнение метода.
        }

        if (resultText.equals(error)) {
            result.setText("0"); // Если в поле ошибка, сбрасываем на "0".
            newNumberFromButton = "0"; // Устанавливаем значение для дальнейших действий.
        }

        parts = result.getText().toString().split("\\+|\\-|\\/|\\*|\\%"); // Разделяем строку по операторам.


        if (newNumberFromButton.equals(".")) {
            if (parts.length > 0 && !parts[parts.length - 1].contains(".")) {
                result.append(newNumberFromButton); // Добавляем точку, если её ещё нет.
            }
        }
        else {
            if (parts.length > 0 && parts[parts.length - 1].startsWith("0") && parts[parts.length - 1].length() > 1 && !parts[parts.length - 1].contains(".")) {
                result.setText(resultText.substring(0, result.getText().toString().length() - parts[parts.length - 1].length()) +
                        parts[parts.length - 1].substring(1));
                // Убираем ведущий "0", если он не является частью числа с плавающей точкой.
            }
            else {
                if (resultText.equals("0") && (!newNumberFromButton.equals("0") || !resultText.equals("")) && !newNumberFromButton.equals("Del")) {
                    result.setText(newNumberFromButton); // Заменяем "0" новым значением.
                }
                else {
                    if (resultText.equals("0") && newNumberFromButton.equals("0")) {
                        result.setText(newNumberFromButton); // Устанавливаем "0".
                    } else {
                        result.append(newNumberFromButton); // Добавляем новое число.
                    }
                }
            }
        }
    }

    public void funcEquals(View view) {

        Button button = (Button) view; // Получаем нажатую кнопку.
        char ch = button.getText().toString().charAt(0); // Получаем символ нажатой кнопки.
        float secondNumber = 0;
        int flag=0;// Инициализируем переменную для второго числа.


        if (result.getText().toString().equals(error)) {
            result.setText("0"); // Сбрасываем поле результата при ошибке.

        }
        parts = result.getText().toString().split("\\+|\\-|\\/|\\*|\\%");



        if (ch != '='&& parts.length < 2 ) {


                if (!Character.isDigit(result.getText().toString().charAt(result.getText().toString().length() - 1))) {
                    result.setText(result.getText().toString().substring(0, result.length() - 1) + ch);
                    // Заменяем последний символ оператором.
                } else {
                    result.append(String.valueOf(ch));
                    opeartor = ch;
                }
                opeartor = ch;

        }

        else {
            if (parts.length == 2){

                parts = result.getText().toString().split("\\+|\\-|\\/|\\*|\\%");
                number = Float.parseFloat(parts[0]); // Парсим первое число.

                if (parts.length > 1) {
                    secondNumber = Float.parseFloat(parts[1]); // Парсим второе число.
                    switch (opeartor) {
                        case '+':
                            number += secondNumber; // Сложение.
                            break;
                        case '-':
                            number -= secondNumber; // Вычитание.
                            break;
                        case '*':
                            number *= secondNumber; // Умножение.
                            break;
                        case '/':
                            if (parts[parts.length - 1].equals("0")) {
                                result.setText(error); // Ошибка при делении на 0.
                                number = 0;
                            } else {
                                number = number / secondNumber; // Деление.
                            }
                            break;
                        case '%':
                            number = number / 100; // Вычисление процента.
                            break;
                    }
                    opeartor=button.getText().toString().charAt(0);


                    if (result.getText().toString().isEmpty()) {
                        result.setText(error); // Ошибка, если поле результата пустое.
                    }
                    else {

                        history.setText(result.getText().toString());

                        if (number == (int) number) {
                            result.setText(String.valueOf((int) number)); // Убираем дробную часть, если она равна 0.
                        }
                        else {
                            if ((number % 1 == 0)) {
                                result.setText(result.getText().toString().substring(0, result.length() - 1) );

                            }
                            else {
                                result.setText(String.valueOf(number));
                            }

                        }
                        if (opeartor!='='){
                            result.append(String.valueOf(opeartor));
                        }


                    }

                }


            }

        }
    }

}


