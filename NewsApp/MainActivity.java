package bg.tu.varna.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.widget.FrameLayout;
import java.util.ArrayList;
import bg.tu.varna.newsapp.adapters.NewsAdapter;
import bg.tu.varna.newsapp.fragments.ShowNewsFragment;
import bg.tu.varna.newsapp.listeners.OnAddNewsListener;
import bg.tu.varna.newsapp.listeners.OnNewsClickListener;
import bg.tu.varna.newsapp.models.News;
import bg.tu.varna.newsapp.source.NewsSource;
import bg.tu.varna.newsapp.tasks.AddNewsTask;

public class MainActivity extends AppCompatActivity implements OnNewsClickListener, OnAddNewsListener {

    private RecyclerView recyclerView;
    private FrameLayout frameLayout;
    HandlerThread handlerThread;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv);
        ArrayList<News> newsList = NewsSource.generateList();
        NewsAdapter adapter = new NewsAdapter(newsList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        handlerThread = new HandlerThread("New");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
        handler.postDelayed(new AddNewsTask(this, newsList), 3000);

    }

    @Override
    public void OnItemClick(News news) {
        ShowNewsFragment showNewsFragment = ShowNewsFragment.newInstance(news);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frameLayout, showNewsFragment, "news");
        transaction.commit();
    }

    @Override
    public void OnAddNews(ArrayList<News> newsList) {
        final NewsAdapter adapter = (NewsAdapter)recyclerView.getAdapter();
        if (adapter != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapter.addNews(newsList);
                }
            });
            handler.postDelayed(new AddNewsTask(this,newsList), 3000);
        }
    }
}