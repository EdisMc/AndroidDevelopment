package bg.tu.varna.ex5;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class ValidateLength implements TextWatcher {
    private EditText editText;
    private Button button;
    private int min_len;
    private int max_len;

    public ValidateLength(EditText editText, Button button, int min_len, int max_len) {
        this.editText = editText;
        this.button = button;
        this.min_len = min_len;
        this.max_len = max_len;
    }

    public EditText getInputText() {
        return editText;
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

    public int getMin_len() {
        return min_len;
    }

    public void setMin_len(int min_len) {
        this.min_len = min_len;
    }

    public int getMax_len() {
        return max_len;
    }

    public void setMax_len(int max_len) {
        this.max_len = max_len;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (charSequence.length() < getMin_len() || charSequence.length() > getMax_len()) {
            editText.setError("Invalid length for field!");
            button.setEnabled(false);
        } else {
            button.setEnabled(true);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

}
