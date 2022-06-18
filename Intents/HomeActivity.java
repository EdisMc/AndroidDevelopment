package bg.tu.varna.intents;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView viewUser;
    private String becUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewUser = findViewById(R.id.viewUser);

        Intent comeIntent = getIntent();
        becUsername = comeIntent.getStringExtra("username");
        viewUser.setText(becUsername);
    }
}