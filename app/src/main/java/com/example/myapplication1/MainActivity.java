package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {


    TextView resultTv,solutionTv;

public float f1,f2;
    private final char ADD= '+';
    private final char SUB = '-';
    private final char MUL = '*';
    private final char DIV = '/';
    private double val1=Double.NaN;
    private double val2;
    private char Action;
    private final char EQU=0;
    MaterialButton buttonC,buttonln,buttonSquare;
    MaterialButton buttonDivide,buttonMultiply,buttonPlus,buttonMinus,buttonEquals;
    MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    MaterialButton buttonAC,buttonDot;




            @SuppressLint("MissingInflatedId")
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                //list the items
                resultTv = findViewById(R.id.result_tv);
                solutionTv = findViewById(R.id.solution_tv);
                buttonC = findViewById(R.id.button_0);
                buttonln = findViewById(R.id.button_ln);
                buttonSquare = findViewById(R.id.button_square);

                buttonPlus = findViewById(R.id.button_plus);
                buttonMinus = findViewById(R.id.button_minus);
                buttonMultiply = findViewById(R.id.button_multiply);
                buttonDivide = findViewById(R.id.button_divide);
                buttonEquals = findViewById(R.id.button_equals);

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

                button0.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resultTv.setText(resultTv.getText().toString() + "0");
                    }
                });
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resultTv.setText(resultTv.getText().toString()+"1");
                    }
                });

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resultTv.setText(resultTv.getText().toString()+"2");
                    }
                });

                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resultTv.setText(resultTv.getText().toString()+"3");
                    }
                });
                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resultTv.setText(resultTv.getText().toString()+"4");
                    }
                });
                button5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resultTv.setText(resultTv.getText().toString()+"5");
                    }
                });
                button6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resultTv.setText(resultTv.getText()+"6");
                    }
                });
                button7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resultTv.setText(resultTv.getText()+"7");
                    }
                });
                button8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resultTv.setText(resultTv.getText()+"8");
                    }
                });
                button9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resultTv.setText(resultTv.getText()+"9");
                    }
                });

                buttonDot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resultTv.setText(resultTv.getText().toString()+".");
                    }
                });
                buttonln.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public
                    void onClick(View v) {

                        double d = Double.parseDouble(resultTv.getText().toString());
                        double square = d*d;
                        resultTv.setText(String.valueOf(square));
                        solutionTv.setText(d+"²");
                    }
                });
                buttonSquare.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public
                    void onClick(View v) {
                        String val = resultTv.getText().toString();
                        double r = Math.sqrt(Double.parseDouble(val));
                        resultTv.setText(String.valueOf(r));
                        solutionTv.setText("");
                    }
                });


               // buttonC.setOnClickListener(new View.OnClickListener() {
                 //   @Override
                   // public void onClick(View v) {
                     //     resultTv.setText("");
                       //  double input1 = 0.0;
                        //double input2 = 0.0;

                    //}
               //});
                buttonAC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String val = resultTv.getText().toString();
                        val = val.substring(0, val.length() - 1);
                        resultTv.setText("");

                    }
                });
                buttonEquals.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        compute();
                       Action = EQU;
                        resultTv.setText(resultTv.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));


                        solutionTv.setText(null);
                    }
                });

               buttonC.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(resultTv.getText().length()>0){
                            CharSequence name = resultTv.getText().toString();
                            resultTv.setText(name.subSequence(0, name.length()-1));

                        }
                        else{
                            val1=Double.NaN;
                           val2=Double.NaN;
                         resultTv.setText(null);
                         solutionTv.setText(null);
                        }
                    }
                });


                //add numbers when button is clicked
                buttonPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        compute();
                        Action=ADD;
                        solutionTv.setText(String.valueOf(val1)+ "+");
                        resultTv.setText(null);
                    }
                });
                buttonMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        compute();
                        Action = SUB;
                        solutionTv.setText(String.valueOf(val1)+ "-");
                        resultTv.setText(null);
                    }
                });

                buttonMultiply.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        compute();
                        Action = MUL;
                        solutionTv.setText(String.valueOf(val1)+ "*");
                        resultTv.setText(null);
                    }

                });

                buttonDivide.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        compute();
                        Action = DIV;
                        solutionTv.setText(String.valueOf(val1)+ "/");
                        resultTv.setText(null);
                    }

                });
            }

                    private  void compute(){
                if (!Double.isNaN(val1))
                {
                    val2=Double.parseDouble(resultTv.getText().toString());

                    switch (Action){
                        case ADD:
                            val1 = val1+val2;
                            break;

                        case SUB:
                            val1= val1-val2;
                            break;
                        case MUL:
                            val1= val1*val2;
                            break;
                        case DIV:
                            val1= val1/val2;
                            break;

                        case EQU:
                            break;

                    }
                }

                else {
                    val1 = Double.parseDouble(resultTv.getText().toString());


                }
}
}

