package com.kuanggang.gankapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author KG on 2017/6/5.
 */
public class GankItem implements Parcelable {

    public String _id;
    public String type;
    public String desc;
    public String who;
    public String url;
    public List<String> images;
    public String createdAt;
    public String publishedAt;

    public GankItem() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this._id);
        dest.writeString(this.type);
        dest.writeString(this.desc);
        dest.writeString(this.who);
        dest.writeString(this.url);
        dest.writeStringList(this.images);
        dest.writeString(this.createdAt);
        dest.writeString(this.publishedAt);
    }

    protected GankItem(Parcel in) {
        this._id = in.readString();
        this.type = in.readString();
        this.desc = in.readString();
        this.who = in.readString();
        this.url = in.readString();
        this.images = in.createStringArrayList();
        this.createdAt = in.readString();
        this.publishedAt = in.readString();
    }

    public static final Creator<GankItem> CREATOR = new Creator<GankItem>() {
        @Override
        public GankItem createFromParcel(Parcel source) {
            return new GankItem(source);
        }

        @Override
        public GankItem[] newArray(int size) {
            return new GankItem[size];
        }
    };
}
