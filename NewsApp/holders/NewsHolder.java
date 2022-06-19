package bg.tu.varna.newsapp.holders;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import bg.tu.varna.newsapp.R;

public class NewsHolder extends RecyclerView.ViewHolder {
    private TextView name, author, source;

    public NewsHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.textView);
        author = itemView.findViewById(R.id.textView2);
        source = itemView.findViewById(R.id.textView3);
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public void setAuthor(String author) {
        this.author.setText(author);
    }

    public void setSource(String source) {
        this.source.setText(source);
    }
}
