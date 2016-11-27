package elgun.com.calculator;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends Activity {

   TextView display ;
    private String v1= "", v2 ="", op = "", buffer = "", inBuffer = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView)findViewById(R.id.display);
    }
    public void clear(View v){
      Button button = (Button)v;
      v1 = "";
        display.setText("");
    }
    public void number(View v){
        Button button = (Button)v;
        if(!button.getText().toString().equalsIgnoreCase("del")) {
            v1 += button.getText().toString();
            display.setText(v1);
        }
        else if(!v1.equals("")){
            v1 = v1.substring(0, v1.length() -1);
            display.setText(v1);
        }
    }
    public void point(View v){

    }
    public void sign(View v){
        op="";
        Button button = (Button)v;
        op = button.getText().toString();
        v1 += op;
        display.setText(v1);
    }
    public void in(View v){
        Button button = (Button)v;
    }

    public void out(View v){
        Button button = (Button)v;
    }
    public void calculate(View v) {
        double result = 0;
        Button button = (Button) v;
        String[] num = display.getText().toString().split("(?<=[-+*/])|(?=[-+*/])");
        for (int i = 0; i < num.length; i++) {

            if (num[i].equals("×")) {
                result = Double.parseDouble(num[i+1])*Double.parseDouble(num[i-1]);

            }
            if (num[i].equals("÷")) {
                result = Double.parseDouble(num[i+1])/Double.parseDouble(num[i-1]);


            }
            if (num[i].equals("+")) {
                result = Double.parseDouble(num[i+1]);
            }
            if (num[i].equals("-")) {
                result = Double.parseDouble(num[i+1]);
            }
        }
        display.setText(display.getText() + "\n");
        display.setTextSize(20); display.setTextColor(Color.RED);
        display.setText(String.valueOf(result));
        result = 0;
    }
}
/* REFERENCES */
/*
Splitting of strings. from StackOverFlow.
http://stackoverflow.com/questions/13525024/how-to-split-a-mathematical-expression-on-operators-as-delimiters-while-keeping
 */