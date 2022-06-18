package bg.tu.varna.intents;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private TextView result;
    private String kUsername, kPassword, validUsername = "Edis", validPassword = "1234E";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.editUsername);
        password = findViewById(R.id.editPassword);
        result = findViewById(R.id.viewResult);
    }

    public void login(View view) {
        kUsername = username.getText().toString();
        kPassword = password.getText().toString();

        if (!TextUtils.isEmpty(kUsername)) {
            if (!TextUtils.isEmpty(kPassword)) {
                if (kUsername.equals(validUsername)) {
                    if (kPassword.equals(validPassword)) {
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        intent.putExtra("username", kUsername);
                        startActivity(intent);

                    } else {
                        result.setText(R.string.wrong_pass);
                    }
                } else {
                    result.setText(R.string.wrong_username);
                }
            } else {
                result.setText(R.string.empty_pass);
            }
        } else {
            result.setText(R.string.empty_username);
        }
    }
}