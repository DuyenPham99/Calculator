package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private TextView textViewResult;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnZero;
    private Button btnAdd;
    private Button btnSub;
    private Button btnMul;
    private Button btnDiv;
    private Button btnDelDigits;
    private Button btnDelOperand;
    private Button btnDelAll;
    private Button btnEqual;
    private Button btnSign;
    private Button btnPoint;
    public ArrayList<String> arrPhanTu;
    public ArrayList<String> tem= new ArrayList<>();
    public Stack<String> stackPre =new Stack<>();
    public Stack<Double>  stackAft =new Stack<>();
    public Queue<String> queue =new LinkedList<>();
    private final String TAG= getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface BTFont = Typeface.createFromAsset(getAssets(), "fonts/DS-DIGIT.TTF");
        textView= findViewById(R.id.txtBieuThuc);
        textView.setTypeface(BTFont);

        textViewResult= findViewById(R.id.txtResult);
        textViewResult.setTypeface(BTFont);

        setupUIView();

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(textViewResult.getText().toString())==0)
                    textViewResult.setText("");
                textViewResult.append("0");
            }
        });
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(textViewResult.getText().toString())==0)
                    textViewResult.setText("");
                textViewResult.append("1");
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(textViewResult.getText().toString())==0)
                    textViewResult.setText("");
                textViewResult.append("2");
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(textViewResult.getText().toString())==0)
                    textViewResult.setText("");
                textViewResult.append("3");
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(textViewResult.getText().toString())==0)
                    textViewResult.setText("");
                textViewResult.append("4");
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(textViewResult.getText().toString())==0)
                    textViewResult.setText("");
                textViewResult.append("5");
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(textViewResult.getText().toString())==0)
                    textViewResult.setText("");
                textViewResult.append("6");
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(textViewResult.getText().toString())==0)
                    textViewResult.setText("");
                textViewResult.append("7");
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(textViewResult.getText().toString())==0)
                    textViewResult.setText("");
                textViewResult.append("8");
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(textViewResult.getText().toString())==0)
                    textViewResult.setText("");
                textViewResult.append("9");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(textView.getText().toString().indexOf("=") !=-1){
                    textView.setText("");
                }
                textView.append(textViewResult.getText());
                textView.append("+");
                textViewResult.setText("0");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v){
                if(textView.getText().toString().indexOf("=") !=-1){
                    textView.setText("");
                }
                textView.append(textViewResult.getText());
                textView.append("-");
                textViewResult.setText("0");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(textView.getText().toString().indexOf("=") !=-1){
                    textView.setText("");
                }
                textView.append(textViewResult.getText());
                textView.append("*");
                textViewResult.setText("0");
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(textView.getText().toString().indexOf("=") !=-1){
                    textView.setText("");
                }
                textView.append(textViewResult.getText());
                textView.append("/");
                textViewResult.setText("0");
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.append(textViewResult.getText());
                InfixtoPostfix(textView.getText().toString(), stackPre,queue);
                double res= Result(queue, stackAft);
                textView.append("=");
                textViewResult.setText(Double.toString(res));
            }
        });
        btnDelDigits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence name= textViewResult.getText().toString();
                if(name.length()==1)
                    textViewResult.setText("0");
                else
                    textViewResult.setText(name.subSequence(0, name.length()-1));
            }
        });
        btnDelAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
                textViewResult.setText("0");
            }
        });
        btnDelOperand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewResult.setText("0");
            }
        });
    }
    private void setupUIView(){
       // setContentView(R.layout.activity_main);
        textView= findViewById(R.id.txtBieuThuc);
        textViewResult= findViewById(R.id.txtResult);
        btnZero= findViewById(R.id.button0);
        btnOne= findViewById(R.id.button1);
        btnTwo= findViewById(R.id.button2);
        btnThree= findViewById(R.id.button3);
        btnFour= findViewById(R.id.button4);
        btnFive= findViewById(R.id.button5);
        btnSix= findViewById(R.id.button6);
        btnSeven=findViewById(R.id.button7);
        btnEight= findViewById(R.id.button8);
        btnNine= findViewById(R.id.button9);
        btnDiv= findViewById(R.id.buttonDiv);
        btnMul= findViewById(R.id.buttonMul);
        btnAdd= findViewById(R.id.buttonAdd);
        btnSub= findViewById(R.id.buttonSub);
        btnEqual= findViewById(R.id.buttonEqual);
        btnDelAll=findViewById(R.id.buttonC);
        btnDelOperand=findViewById(R.id.buttonCE);
        btnDelDigits=findViewById(R.id.buttonBS);
        btnSign=findViewById(R.id.buttonSign);
        btnPoint=findViewById(R.id.buttonPoint);
    }
// Lấy danh sách các số và toán tử
    public ArrayList<String> GetInfix(String input){
        int i=0, j;
        int Start;
        int End = 0;
        arrPhanTu = new ArrayList<>();
        for(i=0; i< input.length();i++){
            String temp;
            if(input.charAt(i)>='0' && input.charAt(i) <='9'){
                Start=i;
               // End= i+1;
                for( j=i+1; j< input.length(); j++){
                    if(input.charAt(j) >= '0' && input.charAt(j) <='9'){
                        continue;
                    } else{
                        break;
                    }
                }
                End = j;
                i=j-1;
                temp= input.substring(Start, End);
                arrPhanTu.add(temp);
            }else if(input.charAt(i)=='+'||input.charAt(i)=='-'||input.charAt(i)=='*'||input.charAt(i)=='/'){
                temp=Character.toString(input.charAt(i));
                arrPhanTu.add(temp);
            }
        }
        return arrPhanTu;
    }
//Hàm kiểm tra số hay toán tử
    public boolean checkNumber(String tem){
        if(tem.equals("+") || tem.equals("*") || tem.equals("-") || tem.equals("/"))
            return false;
        else  return true;
    }
//Hàm trả về độ ưu tiên của các toán tử
    public int Precedence(String o){
        if(o.equals("*") || o.equals("/"))
            return 2;
        else return 1;
    }
// Hàm chuyển biểu thức (trung tố) thành hậu tố
    public void InfixtoPostfix( String infix, Stack<String> stack1, Queue<String> queue){
        if(!infix.isEmpty()){
            tem= GetInfix(infix);
            for(int i=0; i< tem.size(); i++){
                if(checkNumber(tem.get(i))){
                    queue.add(tem.get(i));
                }else{
                    while(!stack1.empty()){
                        if(Precedence(stack1.peek()) >= Precedence(tem.get(i))){
                            queue.add(stack1.peek());
                            stack1.pop();
                        }else
                            break;
                    }
                    stack1.push(tem.get(i));
                }
            }
        }
        while (!stack1.empty()){
            queue.add(stack1.pop());
        }
    }
    public double Calculate( String opertor, double a, double b){
        double rs=0;
        if(opertor.equals("+")){
            rs= (a+b);
        }
        if(opertor.equals("-")){
            rs= (a-b);
        }
        if(opertor.equals("*")){
            rs= (a*b);
        }
        if(opertor.equals("/")){
            rs=(a/b);
        }
        return rs;
    }
// Tính giá trị biểu thức dạng hậu tố
    public double Result( Queue<String> queue, Stack<Double> stack){
        double result=0;
        while(!queue.isEmpty()){
            String tmp= queue.peek();
            queue.poll();
            if(checkNumber(tmp)){
                stack.push(Double.parseDouble(tmp.toString()));
            } else{
                double num1= stack.peek();
                stack.pop();
                double num2= stack.peek();
                stack.pop();
                result= Calculate(tmp, num2, num1);
                stack.push(result);
            }
        }
        return result;
    }
}
