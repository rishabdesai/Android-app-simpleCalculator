package com.rishabhhdesai.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    boolean isNewOp = true;
    EditText et_result;
    String op="+";
    String oldNumber="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        et_result=findViewById(R.id.et_result);

    }

    public void numberEvent(View view) {
        if(isNewOp)
            et_result.setText("");
            isNewOp=false;
        String number =et_result.getText().toString();
        switch (view.getId()){

            case R.id.btzero:
                number +='0';
                break;
            case R.id.bt1:
                number+='1';
                break;
            case R.id.bt2:
                number+='2';
                break;
            case R.id.bt3:
                number+='3';
                break;
            case R.id.bt4:
                number+='4';
                break;
            case R.id.bt5:
                number+='5';
                break;
            case R.id.bt6:
                number+='6';
                break;
            case R.id.bt7:
                number+='7';
                break;
            case R.id.bt8:
                number+='8';
                break;
            case R.id.bt9:
                number+='9';
                break;
            case R.id.btdot:
                number+='.';
                break;


        }
        et_result.setText(number);
    }

    public void operatorEvent(View view) {
    isNewOp=true;
    oldNumber=et_result.getText().toString();
    switch (view.getId()){
        case R.id.btplus:
            op="+";
            break;

        case R.id.btsub:
            op="-";
            break;

        case R.id.btmul:
            op="*";
            break;

        case R.id.btdiv:
            op="/";
            break;

        case R.id.btper:
            op="%";
            break;
    }



    }

    public void equalEvent(View view) {
        String newNumber= et_result.getText().toString();
        double result=0.0;

        switch (op){
            case "+":
                result =Double.parseDouble(oldNumber)+Double.parseDouble(newNumber);
                break;

            case "-":
                result =Double.parseDouble(oldNumber)-Double.parseDouble(newNumber);
                break;

            case "*":
                result =Double.parseDouble(oldNumber)*Double.parseDouble(newNumber);
                break;

            case "/":
                result =Double.parseDouble(oldNumber)/Double.parseDouble(newNumber);
                break;

            case "%":
                result =(Double.parseDouble(oldNumber)/100)*Double.parseDouble(newNumber);
                break;



        }
        et_result.setText(result+"");

    }

    public void acEvent(View view) {

        et_result.setText("");
        isNewOp=true;
    }
}