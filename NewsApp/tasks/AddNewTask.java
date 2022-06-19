package bg.tu.varna.newsapp.tasks;

import java.util.ArrayList;
import bg.tu.varna.newsapp.listeners.OnAddNewsListener;
import bg.tu.varna.newsapp.models.News;

public class AddNewsTask implements Runnable {
    private OnAddNewsListener listener;
    private ArrayList<News> newsList;

    public AddNewsTask(OnAddNewsListener listener, ArrayList<News> newsList) {
        this.listener = listener;
        this.newsList = newsList;
    }

    @Override
    public void run() {
        newsList.add(0, new News("Big new", "Edis", "Net"));
        listener.OnAddNews(newsList);
    }
}
