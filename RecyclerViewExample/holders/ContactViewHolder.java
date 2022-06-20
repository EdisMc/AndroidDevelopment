package bg.tu.varna.recyclerviewexample.holders;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import bg.tu.varna.recyclerviewexample.R;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView phone;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.textView);
        phone = itemView.findViewById(R.id.textView2);
    }

    public TextView getName() {
        return name;
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public TextView getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.setText(phone);
    }
}
