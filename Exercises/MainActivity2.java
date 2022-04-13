package bg.tu.varna.ex5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends BaseActivity {
    private TextView emailField;
    private EditText nameField;
    private EditText addressField;
    private EditText cityField;
    private EditText phoneField;
    private Button nextButton;
    private Button backButton;
    private final String phonePattern = "^08[0-9]{8}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        emailField = findViewById(R.id.emailEdit);
        nameField = findViewById(R.id.nameEdit);
        addressField = findViewById(R.id.addressEdit);
        cityField = findViewById(R.id.cityEdit);
        phoneField = findViewById(R.id.phoneEdit);
        nextButton = findViewById(R.id.secondActivityNextButton);
        backButton = findViewById(R.id.previousButton);

        nextButton.setEnabled(false);

        Intent i = getIntent();
        String emailContent = i.getStringExtra("email");
        emailField.setText(emailContent);

        ValidateLength nameWatcher = new ValidateLength(nameField,nextButton,2,100);
        nameField.addTextChangedListener(nameWatcher);

        ValidateLength addressWatcher = new ValidateLength(addressField,nextButton,5,255);
        addressField.addTextChangedListener(addressWatcher);

        ValidateLength cityWatcher = new ValidateLength(cityField,nextButton,5,150);
        cityField.addTextChangedListener(cityWatcher);

        nextButton.setOnClickListener(this);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    protected Intent create_intent() {
        People person = new People(nameField.getText().toString(),
                emailField.getText().toString(),
                addressField.getText().toString(),
                cityField.getText().toString(),
                phoneField.getText().toString());
        Intent i = new Intent(this,MainActivity3.class);
        i.putExtra("person",person);
        return i;
    }

}
