package bg.tu.varna.ex5;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected Intent intent;

    protected abstract Intent create_intent();

    @Override
    public void onClick(View view) {
        intent = create_intent();
        if (intent != null) {
            startActivity(intent);
        }
        else {
            Log.e(this.getClass().getSimpleName(), "Intent is null!");
        }
    }
}
