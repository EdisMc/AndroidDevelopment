package bg.tu.varna.newsapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class News implements Parcelable {
    private String title;
    private String author;
    private String source;

    public News(String title, String author, String source) {
        this.title = title;
        this.author = author;
        this.source = source;
    }

    protected News(Parcel in) {
        title = in.readString();
        author = in.readString();
        source = in.readString();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSource() {
        return source;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeString(source);
    }
}
