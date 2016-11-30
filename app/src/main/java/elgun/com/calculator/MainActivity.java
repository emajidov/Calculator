package elgun.com.calculator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private TextView display;
    private String v1 = "", operand = "", memory = "";
    private boolean isResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView) findViewById(R.id.display);
    }
    public void clear(View v) {
        v1 = "";
        display.setText("");
    }
    public void number(View v) {
        if(isResult) {
            v1 = "";
            isResult = false;
        }
          Button button = (Button) v;
            if (!button.getText().toString().equalsIgnoreCase("del")) {
                v1 += button.getText().toString();
                display.setText(v1);
            } else if (!v1.equals("")) {
                v1 = v1.substring(0, v1.length() - 1);
                display.setText(v1);
            }
    }
    public void point(View v){
        String[] a = v1.split("(?<=[-+])|(?=[-+])");
        if(!a[a.length-1].contains(".")) { v1 += ".";}
        display.setText(v1);
    }
    public void sign(View v) {
        isResult = false;
        Button button = (Button)v;
        operand = button.getText().toString();
        if(!v1.isEmpty()) {
            if ((v1.substring(v1.length() - 1, v1.length()).equals("+")) ||
                    (v1.substring(v1.length() - 1, v1.length()).equals("-")) ||
                    (v1.substring(v1.length() - 1, v1.length()).equals("×")) ||
                    (v1.substring(v1.length() - 1, v1.length()).equals("÷"))) {
                v1 = v1.substring(0, v1.length() - 1);
            }
        }
        if(v1.isEmpty()&&(operand.equals("×")||operand.equals("÷"))) {operand = "";}
            v1 += operand;
            display.setText(v1);
    }
    public void in(View v) {
        try{
            memory = String.valueOf((calculate(v1)));
            display.setText("");
            v1 = "";
        }
        catch (Exception e) {
            Toast.makeText(MainActivity.this, "Please do not do this!", Toast.LENGTH_SHORT).show();
        }
    }
    public void out(View v) {
        v1 += memory;
        display.setText(v1);
    }
    public void calculate(View v) {
       try {
            double result = calculate(display.getText().toString());
            display.setText(display.getText() + "\n" + String.valueOf(result));
            v1 = String.valueOf(result);
            isResult = true;
        }
        catch(Exception e) {
            Toast.makeText(this.getApplicationContext(),"Please, do not do that!",Toast.LENGTH_SHORT).show();
            isResult = false;
        }
    }

    public static  double calculate(String ex){
        double res = 0;
        String[] a = ex.split("(?<=[-+])|(?=[-+])");
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals("")){ a[i] = "0";}
            if (a[i].contains("÷") || a[i].contains("×")) {
                String[] mul = a[i].split("(?<=[×÷])|(?=[×÷])");
                double r = Double.parseDouble(mul[0]);
                for (int j = 0; j < mul.length; j++) {
                    if (mul[j].equals("×"))
                        r = r * Double.parseDouble(mul[j + 1]);
                    if (mul[j].equals("÷"))
                        r = r / Double.parseDouble(mul[j + 1]);
                }
                a[i] = String.valueOf(r);
            }
        }
        res = Double.parseDouble(a[0]);
        for (int i = 0 ; i < a.length; i++) {
            if (a[i].equals("+"))
                res += Double.parseDouble(a[i + 1]);
            if (a[i].equals("-"))
                res -= Double.parseDouble(a[i + 1]);
        }
       return res;
    }
}
/* REFERENCES */
/*
Splitting of strings. from StackOverFlow.
http://stackoverflow.com/questions/13525024/how-to-split-a-mathematical-expression-on-operators-as-delimiters-while-keeping
 */