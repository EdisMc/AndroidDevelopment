package bg.tu.varna.newsapp.source;

import java.util.ArrayList;
import bg.tu.varna.newsapp.models.News;

public class NewsSource {
    private static ArrayList<News> newsCollection = new ArrayList<>();

    public static ArrayList<News> generateList() {
        for (int i = 1; i <= 10; i++) {
            newsCollection.add(new News(
                    "Title " + i,
                    "Author " + i,
                    "Source " + i
            ));
        }
        return newsCollection;
    }
  
}
