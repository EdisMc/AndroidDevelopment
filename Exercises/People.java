package bg.tu.varna.ex5;

import android.os.Parcel;
import android.os.Parcelable;

public class People implements Parcelable {
    private String name;
    private String email;
    private String address;
    private String city;
    private String phone;

    public People(String name, String email, String address, String city, String phone) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.phone = phone;
    }

    protected People(Parcel in) {
        name = in.readString();
        email = in.readString();
        address = in.readString();
        city = in.readString();
        phone = in.readString();
    }

    public static final Creator<People> CREATOR = new Creator<People>() {
        @Override
        public People createFromParcel(Parcel in) {
            return new People(in);
        }

        @Override
        public People[] newArray(int size) {
            return new People[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(address);
        parcel.writeString(city);
        parcel.writeString(phone);
    }

}
