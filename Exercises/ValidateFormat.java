package bg.tu.varna.ex5;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class ValidateFormat implements TextWatcher {
    private EditText editText;
    private Button button;
    private String pattern;

    public ValidateFormat(EditText editText, Button button, String pattern) {
        this.editText = editText;
        this.button = button;
        this.pattern = pattern;
    }

    public EditText getEditText() {
        return editText;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (!Pattern.matches(pattern,editText.getText().toString())) {
            editText.setError("Invalid format!");
            button.setEnabled(false);
        } else {
            button.setEnabled(true);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

}
