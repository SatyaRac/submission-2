package com.example.madesub2;

import android.os.Parcel;
import android.os.Parcelable;

public class Moviedab implements Parcelable {
    private String judulmov;
    private String tglrilisMov;
    private int posterMov;
    private String dierctorMov;
    private String deskripsi;

    public String getDierctorMov() {
        return dierctorMov;
    }

    public void setDierctorMov(String dierctorMov) {
        this.dierctorMov = dierctorMov;
    }

    public String getJudulmov() {
        return judulmov;
    }

    public void setJudulmov(String judulmov) {
        this.judulmov = judulmov;
    }

    public String getTglrilisMov() {
        return tglrilisMov;
    }

    public void setTglrilisMov(String tglrilisMov) {
        this.tglrilisMov = tglrilisMov;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getPosterMov() {
        return posterMov;
    }

    public void setPosterMov(int posterMov) {
        this.posterMov = posterMov;
    }





    public Moviedab() {

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judulmov);
        dest.writeString(this.tglrilisMov);
        dest.writeInt(this.posterMov);
        dest.writeString(this.dierctorMov);
        dest.writeString(this.deskripsi);
    }

    protected Moviedab(Parcel in) {
        this.judulmov = in.readString();
        this.tglrilisMov = in.readString();
        this.posterMov = in.readInt();
        this.dierctorMov = in.readString();
        this.deskripsi = in.readString();
    }

    public static final Creator<Moviedab> CREATOR = new Creator<Moviedab>() {
        @Override
        public Moviedab createFromParcel(Parcel source) {
            return new Moviedab(source);
        }

        @Override
        public Moviedab[] newArray(int size) {
            return new Moviedab[size];
        }
    };
}
