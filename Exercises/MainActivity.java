package bg.tu.varna.ex5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends BaseActivity {
    private EditText emailField;
    private Button passData;
    private final String emailPattern = Patterns.EMAIL_ADDRESS.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailField = findViewById(R.id.emailEdit);
        passData = findViewById(R.id.nextButton);
        passData.setEnabled(false);

        ValidateFormat emailValidate = new ValidateFormat(emailField, passData, emailPattern);
        emailField.addTextChangedListener(emailValidate);

        passData.setOnClickListener(this);
    }

    @Override
    protected Intent create_intent() {
        Intent i = new Intent(this,MainActivity2.class);
        i.putExtra("email",emailField.getText().toString());
        return i;
    }

}