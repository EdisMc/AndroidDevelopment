package bg.tu.varna.newsapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import bg.tu.varna.newsapp.R;
import bg.tu.varna.newsapp.holders.NewsHolder;
import bg.tu.varna.newsapp.listeners.OnNewsClickListener;
import bg.tu.varna.newsapp.models.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsHolder> {
    private List<News> newsList;
    OnNewsClickListener listener;

    public NewsAdapter(List<News> newsList, OnNewsClickListener listener) {
        this.newsList = newsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_view, parent, false);
        return new NewsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        News news = newsList.get(position);
        holder.setName(news.getTitle());
        holder.setAuthor(news.getAuthor());
        holder.setSource(news.getSource());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnItemClick(news);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public void addNews(ArrayList<News> newsList) {
        this.newsList = newsList;
        notifyDataSetChanged();
    }
}
