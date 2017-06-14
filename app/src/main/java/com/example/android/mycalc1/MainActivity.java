package com.example.android.mycalc1;

import android.graphics.PorterDuff;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.TextView;
import android.graphics.drawable.ShapeDrawable;
import android.widget.Toast;

import com.example.android.mycalc1.R;

import static android.view.View.OnClickListener;
public class MainActivity extends AppCompatActivity {

    Button one, two, three, four, five, six, seven,back,mod,root, eight, nine, zero, add, subtract, multiply, divide, clearb,answer, equal, clbrac,opbrac, exp, decimal;
    EditText disp,dm;
    Double a,result=0.0;
    int flag=0,check=0,sign=0;
    String x="",z="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);

        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        add = (Button) findViewById(R.id.add);
        answer=(Button) findViewById(R.id.answer);
        subtract = (Button) findViewById(R.id.subtract);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);
        clearb = (Button) findViewById(R.id.clearb);
        equal = (Button) findViewById(R.id.equal);
        clbrac = (Button) findViewById(R.id.clbrac);
        opbrac = (Button) findViewById(R.id.opbrac);
        exp = (Button) findViewById(R.id.exp);
        back=(Button) findViewById(R.id.back);
        root=(Button) findViewById(R.id.root);
        mod=(Button) findViewById(R.id.mod);
        decimal = (Button) findViewById(R.id.decimal);
        dm=(EditText) findViewById(R.id.dm);
        disp = (EditText) findViewById(R.id.display);
        ShapeDrawable shape = new ShapeDrawable(new RectShape());
        shape.getPaint().setColor(Color.RED);
        shape.getPaint().setStyle(Paint.Style.STROKE);
        shape.getPaint().setStrokeWidth(10);
        disp.setBackground(shape);
        disp.setBackgroundColor(Color.WHITE);
        ShapeDrawable shape1 = new ShapeDrawable(new RectShape());
        shape1.getPaint().setColor(Color.RED);
        shape1.getPaint().setStyle(Paint.Style.STROKE);
        shape1.getPaint().setStrokeWidth(20);
        dm.setBackground(shape1);
        dm.setBackgroundColor(Color.WHITE);

        one.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            disp.setText(disp.getText() + "1");
            x=x+"1";
        }
        });

        two.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            disp.setText(disp.getText() + "2");
            x=x+"2";
        }
        });

        clearb.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            result=0.0;
            disp.setText("");x="";
            dm.setText("");
            sign=0;

            check=0;
            flag=0;

        }
        });
        back.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            try {
                String w = disp.getText() + "";
                int l = w.length();
                if(w.charAt(l-1)<'0' && w.charAt(l-1)>'9')
                {

                     x="0";
                    flag = 6;
                }
                else
                    x = x.substring(0, x.length() - 1);
                w = w.substring(0, l - 1);
                disp.setText(w);


            }
            catch(Exception e)
            {

            }

        }
        });

        decimal.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            try {
                disp.setText(disp.getText() + ".");
                x = x + ".";
            }
            catch(Exception e)
            {

            }
        }
        });
        root.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            try {


                if (sign == 0) {
                    a = Double.parseDouble(x);
                    x = "";
                } else {
                    int l = x.length();
                    a = Double.parseDouble(x.substring(1, l - 1));
                    x = "";
                    sign = 0;
                }


                if (flag == 1)
                    result = result + a;
                else if (flag == 2)
                    result = result - a;
                else if (flag == 3)
                    result = result * a;
                else if (flag == 4)
                    result = result / a;
                else if (flag == 0)
                    result = a;
                else if (flag == 5)
                    result = Math.pow(result, a);
                else if(flag==6)
                    result= result*1;
                result=Math.sqrt(result);
                z=Double.toString(result);
                disp.setText("");
                dm.setText(result+"");
                x=Double.toString(result);
                flag = 6;
            }
            catch(Exception e)
            {

            }
        }
        });

        mod.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            try {


                if (sign == 0) {
                    a = Double.parseDouble(x);
                    x = "";
                } else {
                    int l = x.length();
                    a = Double.parseDouble(x.substring(1, l - 1));
                    x = "";
                    sign = 0;
                }

                if (flag == 1)
                    result = result + a;
                else if (flag == 2)
                    result = result - a;
                else if (flag == 3)
                    result = result * a;
                else if (flag == 4)
                    result = result / a;
                else if (flag == 0)
                    result = a;
                else if (flag == 5)
                    result = Math.pow(result, a);
                else if(flag==6)
                    result= result*1;
                else if(flag==7)
                    result=result%a;

                dm.setText(result+"");
                disp.setText(disp.getText()+"%");
                flag = 7;
            }
            catch(Exception e)
            {

            }
        }
        });

        three.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            disp.setText(disp.getText() + "3");
            x=x+"3";
        }
        });

        four.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            disp.setText(disp.getText() + "4");

            x=x+"4";
        }
        });

        five.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            disp.setText(disp.getText() + "5");

            x=x+"5";
        }
        });

        six.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            disp.setText(disp.getText() + "6");

            x=x+"6";
        }
        });

        seven.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            disp.setText(disp.getText() + "7");

            x=x+"7";
        }
        });

        eight.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            disp.setText(disp.getText() + "8");

            x=x+"8";
        }
        });

        nine.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            disp.setText(disp.getText() + "9");

            x=x+"9";
        }
        });

        zero.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            disp.setText(disp.getText() + "0");

            x=x+"0";
        }
        });
        clbrac.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            if(x.charAt(0)!='(')
                 {
                    Toast.makeText(getApplicationContext(), "No Opening Braces!", Toast.LENGTH_SHORT).show();
                }
            else {
                disp.setText(disp.getText() + ")");
                x = x + ")";
                check = 0;
                sign = 1;
            }
        }
        });
        opbrac.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            disp.setText(disp.getText() + "(");

            x=x+"(";
            check=1;
        }
        });

        answer.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            if((dm.getText()+"")=="") {
                Toast.makeText(getApplicationContext(), "Value Field Empty!", Toast.LENGTH_SHORT).show();
            }
            else {
                x=z;
                disp.setText(x + "");
                dm.setText("");

            }
        }
        });
        add.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            try{
                   if((disp.getText()+"")=="") {
                       Toast.makeText(getApplicationContext(), "Value Field Empty!", Toast.LENGTH_SHORT).show();
                   }
                else {

                       if (sign == 0) {
                           a = Double.parseDouble(x);
                           x = "";
                       } else {
                           int l = x.length();
                           a = Double.parseDouble(x.substring(1, l - 1));
                           x = "";
                           sign = 0;
                       }

                       if (flag == 1)
                           result = result + a;
                       else if (flag == 2)
                           result = result - a;
                       else if (flag == 3)
                           result = result * a;
                       else if (flag == 4)
                           result = result / a;
                       else if (flag == 5)
                           result = Math.pow(result, a);
                       else if (flag == 0)
                           result = a;
                       else if(flag==6)
                           result= result*1;
                       else if(flag==7)
                           result=result%a;
                       dm.setText(result+"");
                       disp.setText(disp.getText()+"+");
                       flag = 1;

                   }

            }
            catch(Exception e) {

            }

        }
        });

        subtract.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            try {
                if((disp.getText()+"")=="") {
                    Toast.makeText(getApplicationContext(), "Value Field Empty!", Toast.LENGTH_SHORT).show();
                }
                   else {

                    if (check == 1) {
                        x = x + "-";

                        disp.setText(disp.getText() + "-");
                    } else {

                        if (sign == 0) {
                            a = Double.parseDouble(x);
                            x = "";
                        } else {
                            int l = x.length();
                            a = Double.parseDouble(x.substring(1, l - 1));
                            x = "";
                            sign = 0;
                        }


                        if (flag == 1)
                            result = result + a;
                        else if (flag == 2)
                            result = result - a;
                        else if (flag == 3)
                            result = result * a;
                        else if (flag == 4)
                            result = result / a;
                        else if (flag == 0)
                            result = a;
                        else if (flag == 5)
                            result = Math.pow(result, a);
                        else if(flag==6)
                            result= result*1;
                        else if(flag==7)
                            result=result%a;
                        disp.setText(disp.getText()+"-");
                        dm.setText(result+"");
                        flag = 2;
                    }
                }

            }
            catch (Exception e)
            {

            }

        }
        });

        multiply.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
         try {
             if((disp.getText()+"")=="") {
                 Toast.makeText(getApplicationContext(), "Value Field Empty!", Toast.LENGTH_SHORT).show();
             }
             else {

                 if (sign == 0) {
                     a = Double.parseDouble(x);
                     x = "";
                 } else {
                     int l = x.length();
                     a = Double.parseDouble(x.substring(1, l - 1));
                     x = "";
                     sign = 0;
                 }

                 if (flag == 1)
                     result = result + a;
                 else if (flag == 2)
                     result = result - a;
                 else if (flag == 3)
                     result = result * a;
                 else if (flag == 4)
                     result = result / a;
                 else if (flag == 0)
                     result = a;
                 else if (flag == 5)
                     result = Math.pow(result, a);
                 else if(flag==6)
                     result= result*1;
                 else if(flag==7)
                     result=result%a;
                 disp.setText(disp.getText()+"*");
                 dm.setText(result+"");
                 flag = 3;

             }
         }
         catch (Exception e)
         {

         }

        }
        });

        divide.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
  try {
      if((disp.getText()+"")=="") {
          Toast.makeText(getApplicationContext(), "Value Field Empty!", Toast.LENGTH_SHORT).show();
      }
      else {

          if (sign == 0) {
              a = Double.parseDouble(x);
              x = "";
          } else {
              int l = x.length();
              a = Double.parseDouble(x.substring(1, l - 1));
              x = "";
              sign = 0;
          }

          if (flag == 1)
              result = result + a;
          else if (flag == 2)
              result = result - a;
          else if (flag == 3)
              result = result * a;
          else if (flag == 4)
              result = result / a;
          else if (flag == 0)
              result = a;
          else if (flag == 5)
              result = Math.pow(result, a);
          else if(flag==6)
              result= result*1;
          else if(flag==7)
              result=result%a;
          disp.setText(disp.getText()+"/");
          dm.setText(result+"");
          flag = 4;

      }
  }
  catch (Exception e)
  {

  }

        }
        });

        exp.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
            try {
                if((disp.getText()+"")=="") {
                    Toast.makeText(getApplicationContext(), "Value Field Empty!", Toast.LENGTH_SHORT).show();
                }
                else {

                    if (sign == 0) {
                        a = Double.parseDouble(x);
                        x = "";
                    } else {
                        int l = x.length();
                        a = Double.parseDouble(x.substring(1, l - 1));
                        x = "";
                        sign = 0;
                    }
                    if (flag == 1)
                        result = result + a;
                    else if (flag == 2)
                        result = result - a;
                    else if (flag == 3)
                        result = result * a;
                    else if (flag == 4)
                        result = result / a;
                    else if (flag == 0)
                        result = a;
                    else if (flag == 5)
                        result = Math.pow(result, a);
                    else if(flag==6)
                        result= result*1;
                    else if(flag==7)
                        result=result%a;
                    disp.setText(disp.getText()+"^");

                    dm.setText(result+"");
                    flag = 5;

                }
            }
            catch(Exception e)
            {

            }

        }
        });


        equal.setOnClickListener(new View.OnClickListener(){ @Override
        public void onClick(View v){
try {
    if ((disp.getText() + "") == "") {
        Toast.makeText(getApplicationContext(), "Value Field Empty!", Toast.LENGTH_SHORT).show();
    } else {

        if (sign == 0) {
            a = Double.parseDouble(x);
            x = "";
        } else {
            int l = x.length();
            a = Double.parseDouble(x.substring(1, l - 1));
            x = "";
            sign = 0;
        }

        if (flag == 1) {
            result = a + result;
            dm.setText(result + "");

            z = Double.toString(result);
        }
        if (flag == 2) {
            result = result - a;
            dm.setText(result + "");

            z = Double.toString(result);
        }
        if (flag == 3) {
            result = a * result;
            dm.setText(result + "");

            z = Double.toString(result);


        }
        if (flag == 4) {
            result = result / a;
            dm.setText(result + "");

            z = Double.toString(result);
        }
        if (flag == 5) {
            result = Math.pow(result, a);
            dm.setText(result + "");

            z = Double.toString(result);

        }
        if (flag == 0) {
            result = a;
            z = Double.toString(result);

        }
        else if(flag==7) {
            result = result % a;
            dm.setText(result+"");
            z = Double.toString(result);
        }
        x="";
        disp.setText("");
        flag = 0;
    }
}
    catch (Exception e)
    {

    }
        }
        });
    }





}

