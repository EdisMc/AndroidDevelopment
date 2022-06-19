package bg.tu.varna.newsapp.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bg.tu.varna.newsapp.R;
import bg.tu.varna.newsapp.models.News;

public class ShowNewsFragment extends Fragment {

    private static final String ARG_NEWS = "news";
    private News news;
    private TextView title, author, source;

    public ShowNewsFragment() {
        // Required empty public constructor
    }

    public static ShowNewsFragment newInstance(News news) {
        ShowNewsFragment fragment = new ShowNewsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NEWS, news);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            news = getArguments().getParcelable(ARG_NEWS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.textView7);
        author = view.findViewById(R.id.textView8);
        source = view.findViewById(R.id.textView9);

        title.setText(news.getTitle());
        author.setText(news.getAuthor());
        source.setText(news.getSource());

    }
}