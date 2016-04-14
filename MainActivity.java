import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button one,two,three,four,five,six,seven,eight,nine,zero;
    Button plus ,minus,divide,multiply,percentage,clear,swith,equalb,dot;
    public static  boolean correct = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.abc);

        zero = (Button)findViewById(R.id.zzz);
        one = (Button)findViewById(R.id.ooo);
        two = (Button)findViewById(R.id.ttt);
        three = (Button)findViewById(R.id.TTT);
        four = (Button)findViewById(R.id.fff);
        five = (Button)findViewById(R.id.FFF);
        six = (Button)findViewById(R.id.sss);
        seven = (Button)findViewById(R.id.SSS);
        eight = (Button)findViewById(R.id.eee);
        nine = (Button)findViewById(R.id.nnn);

        dot = (Button)findViewById(R.id.DOT);
        plus = (Button)findViewById(R.id.AAAA);
        minus = (Button)findViewById(R.id.SSSS);
        divide = (Button)findViewById(R.id.DDDD);
        multiply = (Button)findViewById(R.id.MMMM);
        percentage = (Button)findViewById(R.id.PPPP);

        clear = (Button)findViewById(R.id.CLEAR);
        swith = (Button)findViewById(R.id.plusminus);
        equalb = (Button)findViewById(R.id.equal);

        editText.setText("");

        editText.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.onTouchEvent(event);
                InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                return true;
            }
        });
    }
    //0
    public void expression0(View v){
        editText.setText(editText.getText()+"0");
        editText.setSelection(editText.getText().toString().length());
    }
    //1
    public void expression1(View v){
        editText.setText(editText.getText()+"1");
        editText.setSelection(editText.getText().toString().length());
    }
    //2
    public void expression2(View v){
        editText.setText(editText.getText()+"2");
        editText.setSelection(editText.getText().toString().length());
    }
    //3
    public void expression3(View v){
        editText.setText(editText.getText()+"3");
        editText.setSelection(editText.getText().toString().length());
    }
    //4
    public void expression4(View v){
        editText.setText(editText.getText()+"4");
        editText.setSelection(editText.getText().toString().length());
    }
    //5
    public void expression5(View v){
        editText.setText(editText.getText()+"5");
        editText.setSelection(editText.getText().toString().length());
    }
    //6
    public void expression6(View v){
        editText.setText(editText.getText()+"6");
        editText.setSelection(editText.getText().toString().length());
    }
    //7
    public void expression7(View v){
        editText.setText(editText.getText()+"7");
        editText.setSelection(editText.getText().toString().length());
    }
    //8
    public void expression8(View v){
        editText.setText(editText.getText()+"8");
        editText.setSelection(editText.getText().toString().length());
    }
    //9
    public void expression9(View v){
        editText.setText(editText.getText()+"9");
        editText.setSelection(editText.getText().toString().length());
    }
    //10
    public void expressiondot(View v){
        editText.setText(editText.getText()+".");
        editText.setSelection(editText.getText().toString().length());
    }
    //11
    public void expressionac(View v){
        editText.setText("");
        editText.setSelection(editText.getText().toString().length());
    }
    //12
    public void expressionpm(View v){
        try{
            String temp = editText.getText().toString();
            editText.setText(temp.substring(0,temp.length()-1));
            editText.setSelection(editText.getText().toString().length());
        }
        catch (Exception ex){

        }
    }
    //13
    public void expressionm(View v){
        editText.setText(editText.getText()+"%");
        editText.setSelection(editText.getText().toString().length());
    }
    //14
    public void expressiond(View v){
        editText.setText(editText.getText()+"/");
        editText.setSelection(editText.getText().toString().length());
    }
    //15
    public void expressionp(View v){
        editText.setText(editText.getText()+"*");
        editText.setSelection(editText.getText().toString().length());
    }
    //16
    public void expressionss(View v){
        editText.setText(editText.getText()+"-");
        editText.setSelection(editText.getText().toString().length());
    }
    //17
    public void expressiona(View v){
        editText.setText(editText.getText()+"+");
        editText.setSelection(editText.getText().toString().length());
    }
    //18
    public void solve(View v){
        try{
            String INPUT = editText.getText().toString();
            String OUTPUT;
            int flag=0;
            if (INPUT.charAt(0) == '-')
                INPUT = "0" + INPUT;
            for(int i=0;i<INPUT.length()-1;i++){
                if (INPUT.charAt(i) == '%')
                    if(INPUT.charAt(i+1) >= '0' && INPUT.charAt(i+1) <= '9')
                        flag = 1;
            }
            if(flag== 0) {
                INPUT = INPUT.replaceAll("%", "/100");
                float ans = calculate(INPUT);

                if (correct)
                    OUTPUT = Float.toString(ans);
                else
                    OUTPUT = "Invalid Input";

                System.out.println(OUTPUT);
                editText.setText(OUTPUT);

            }
            else
                editText.setText("Invalid Expression");

            editText.setSelection(editText.getText().toString().length());
        }
        catch (Exception ex){
            editText.setText("Invalid Expression");
        }
    }

    public static  float calculate(String query)
    {

        if(query.contains("+"))
        {
            int l = query.indexOf("+");
            return calculate(query.substring(0, l)) + calculate(query.substring(l+1, query.length()));
        }
        else if(query.contains("-"))
        {
            int l = query.indexOf("-");
            return calculate(query.substring(0, l)) - calculate(query.substring(l+1, query.length()));
        }
        else if(query.contains("*"))
        {
            int l = query.indexOf("*");
            return calculate(query.substring(0, l)) * calculate(query.substring(l+1, query.length()));
        }
        else if(query.contains("/"))
        {
            int l = query.indexOf("/");
            return calculate(query.substring(0, l)) / calculate(query.substring(l+1, query.length()));
        }
        else if(query.equals(""))
        {
            correct = false;
            return -1;
        }
        else{
            return Float.parseFloat(query);
        }
    }


}
