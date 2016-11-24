package elgun.com.calculator;
import android.net.ParseException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button  zero, one, two, three, four, five, six,
            seven, eight, nine, add, sub, div,
            mul, point, clear, equal, in, out, del;

    TextView display ;
    String value1= "", value2 ="";
    double vOne , vTwo, result;
    String op = "";
    String buffer = "";
    String inBuffer = "";
    // boolean mAddition , mSubtract ,mMultiplication ,mDivision ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zero = (Button) findViewById(R.id.zero);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        point = (Button) findViewById(R.id.point);
        add = (Button) findViewById(R.id.plus);
        sub = (Button) findViewById(R.id.minus);
        mul = (Button) findViewById(R.id.product);
        div = (Button) findViewById(R.id.divide);
        clear = (Button) findViewById(R.id.clear);
        equal = (Button) findViewById(R.id.equals);
        in = (Button) findViewById(R.id.in_button);
        out = (Button) findViewById(R.id.out_button);
        del = (Button) findViewById(R.id.del);
        display = (TextView) findViewById(R.id.display);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1  = value1+"1";
                display.setText(buffer + value1);

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = value1 +"2";
                display.setText(buffer+value1);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = value1 +"3";
                display.setText(buffer+value1);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = value1 +"4";
                display.setText(buffer+value1);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = value1 +"5";
                display.setText(buffer+value1);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = value1 +"6";
                display.setText(buffer+value1);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = value1 +"7";
                display.setText(buffer+value1);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = value1 +"8";
                display.setText(buffer+value1);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = value1 +"9";
                display.setText(buffer+value1);
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = value1 +"0";
                display.setText(buffer+value1);
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!value1.contains(".")) value1 =  value1 + ".";
                display.setText(buffer+ value1);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = "";
                value2 = "";
                buffer = "";
                display.setText("");
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value1.length()!= 0) {
                    int j = value1.length();
                    value1 = value1.substring(0, j - 1);
                    display.setText(value1);
                }
            }
        });
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    vTwo = Double.parseDouble(value1);
                }
                catch(Exception e) {
                }

                inBuffer =  String.valueOf(vTwo+vOne);
                display.setText("");
            }
        });
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value1 = inBuffer;
                display.setText(value1);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                display.setText(value1+"+");
                buffer =  (String)display.getText();
                try {
                    vOne = Double.parseDouble(value1);
                }
                catch(Exception e) {
                }
                value1 = "";
                op = "add";
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(value1+"-");
                buffer = (String)display.getText();
                try {
                    vOne = Double.parseDouble(value1);
                }
                catch (Exception e) {
                }
                value1 = "";
                op ="sub";
            }
        });



        equal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                display.setText(buffer+value1);
                try {
                    vTwo = Double.parseDouble(value1);
                }
                catch(Exception e) {
                }
                if(op.equals("add")){
                    result = vOne+vTwo;
                    op ="";
                }
                if(op.equals("sub")){
                    result = vOne-vTwo;
                    op="";
                }
                value1 =  String.valueOf(result);
                display.setText(value1)      ;
            }
        });

    }
}