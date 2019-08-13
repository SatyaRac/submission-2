package com.example.madesub2;

import android.os.Parcel;
import android.os.Parcelable;

public class Tvshow implements Parcelable {
    private String judulTv;
    private String tglrilisTv;
    private int posterTv;
    private String creatorTv;

    public String getDeskrisiTv() {
        return deskrisiTv;
    }

    public void setDeskrisiTv(String deskrisiTv) {
        this.deskrisiTv = deskrisiTv;
    }

    private String deskrisiTv;

    public String getCreatorTv() {
        return creatorTv;
    }

    public void setCreatorTv(String creatorTv) {
        this.creatorTv = creatorTv;
    }



    public Tvshow() {

    }

    public String getJudulTv() {
        return judulTv;
    }

    public void setJudulTv(String judulTv) {
        this.judulTv = judulTv;
    }

    public String getTglrilisTv() {
        return tglrilisTv;
    }

    public void setTglrilisTv(String tglrilisTv) {
        this.tglrilisTv = tglrilisTv;
    }

    public int getPosterTv() {
        return posterTv;
    }

    public void setPosterTv(int posterTv) {
        this.posterTv = posterTv;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judulTv);
        dest.writeString(this.tglrilisTv);
        dest.writeInt(this.posterTv);
        dest.writeString(this.creatorTv);
        dest.writeString(this.deskrisiTv);
    }

    protected Tvshow(Parcel in) {
        this.judulTv = in.readString();
        this.tglrilisTv = in.readString();
        this.posterTv = in.readInt();
        this.creatorTv = in.readString();
        this.deskrisiTv = in.readString();
    }

    public static final Creator<Tvshow> CREATOR = new Creator<Tvshow>() {
        @Override
        public Tvshow createFromParcel(Parcel source) {
            return new Tvshow(source);
        }

        @Override
        public Tvshow[] newArray(int size) {
            return new Tvshow[size];
        }
    };
}
