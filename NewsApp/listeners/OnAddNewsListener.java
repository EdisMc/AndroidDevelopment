package bg.tu.varna.newsapp.listeners;

import java.util.ArrayList;
import bg.tu.varna.newsapp.models.News;

public interface OnAddNewsListener {
    void OnAddNews(ArrayList<News> newsList);
}
