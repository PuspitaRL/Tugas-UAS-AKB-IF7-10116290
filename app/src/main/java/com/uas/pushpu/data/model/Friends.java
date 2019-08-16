package com.uas.pushpu.data.model;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;



@Entity(tableName = "friends")
public class Friends implements Parcelable {

    public static final Creator<Friends> CREATOR = new Creator<Friends>() {
        @Override
        public Friends createFromParcel(Parcel in) {
            return new Friends(in);
        }

        @Override
        public Friends[] newArray(int size) {
            return new Friends[size];
        }
    };
    @PrimaryKey
    @NonNull
    private String nim;
    private String name, class_, phone, email, ig;

    public Friends(String name, String nim, String class_, String phone, String email, String ig) {
        this.name = name;
        this.nim = nim;
        this.class_ = class_;
        this.phone = phone;
        this.email = email;
        this.ig = ig;
    }

    protected Friends(Parcel in) {
        name = in.readString();
        nim = in.readString();
        class_ = in.readString();
        phone = in.readString();
        email = in.readString();
        ig = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getClass_() {
        return class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIg() {
        return ig;
    }

    public void setIg(String ig) {
        this.ig = ig;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.nim);
        dest.writeString(this.class_);
        dest.writeString(this.phone);
        dest.writeString(this.email);
        dest.writeString(this.ig);
    }
}
