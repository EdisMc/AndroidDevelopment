package bg.tu.varna.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumber, secondNumber;
    private TextView resultView;
    private String first, second;
    private int s1, s2, result;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNumber = findViewById(R.id.firstNumber);
        secondNumber = findViewById(R.id.secondNumber);
        resultView = findViewById(R.id.resultView);
    }

    public void calculateButton(View view) {
        first = firstNumber.getText().toString();
        second = secondNumber.getText().toString();

        if (!TextUtils.isEmpty(first) && !TextUtils.isEmpty(second)) {
            s1 = Integer.valueOf(first);
            s2 = Integer.valueOf(second);
            calculator = new Calculator(s1, s2);

            switch (view.getId()) {
                case R.id.addButton:
                    result = calculator.add();
                    break;

                case R.id.subtractButton:
                    result = calculator.subtract();
                    break;

                case R.id.multiplyButton:
                    result = calculator.multiply();
                    break;

                case R.id.divideButton:
                    result = calculator.divide();
                    break;
            }
            resultView.setText("The result is: "+ result);
        } else {
            resultView.setText(R.string.not_empty);
        }
    }
}