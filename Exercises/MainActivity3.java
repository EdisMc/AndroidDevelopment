package bg.tu.varna.ex5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends BaseActivity {
    private TextView nameField;
    private TextView emailField;
    private TextView addressField;
    private TextView cityField;
    private TextView phoneField;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        emailField = findViewById(R.id.emailView);
        nameField = findViewById(R.id.nameView);
        addressField = findViewById(R.id.addressView);
        cityField = findViewById(R.id.cityView);
        phoneField = findViewById(R.id.phoneView);
        backButton = findViewById(R.id.thirdAct_backButton);

        Intent i = getIntent();
        People person = i.getParcelableExtra("person");

        emailField.setText(person.getEmail());
        nameField.setText(person.getName());
        addressField.setText(person.getAddress());
        cityField.setText(person.getCity());
        phoneField.setText(person.getPhone());

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    protected Intent create_intent() {
        return null;
    }

}
