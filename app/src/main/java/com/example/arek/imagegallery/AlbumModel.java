package com.example.arek.imagegallery;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Arek on 2017-03-17.
 */
public class AlbumModel implements Parcelable {

    private int imageId;
    private String title;
    private String albumName;

    public AlbumModel(){

    }

    protected AlbumModel(Parcel in) {
        imageId = in.readInt();
        title = in.readString();
        albumName = in.readString();
    }

    public static final Creator<AlbumModel> CREATOR = new Creator<AlbumModel>() {
        @Override
        public AlbumModel createFromParcel(Parcel in) {
            return new AlbumModel(in);
        }

        @Override
        public AlbumModel[] newArray(int size) {
            return new AlbumModel[size];
        }
    };

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imageId);
        parcel.writeString(albumName);
        parcel.writeString(title);
    }



}
