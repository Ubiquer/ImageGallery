package com.example.arek.imagegallery;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArraySet;
import android.support.v4.view.InputDeviceCompat;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Arek on 2017-03-18.
 */

//class responsible for displaying images

public class ImageFragment extends Fragment {

    private Context context;
    public int imageId;
    private int position;
//

//
//
//    //TODO: find out how to get data from assets subfolder, we have to populate music from each subfolder into different array dynamically accordingly to enum's drawable resource.

    private static final String ARG_IMG_ID = "image_id";
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_ALBUM_NAME = "album_name";

    private String musicList[];

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        this.imageId = args.getInt(ARG_IMG_ID);
        this.position = args.getInt(ARG_SECTION_NUMBER);
    }

    public static ImageFragment newInstance(int sectionNumber, int imageId, String albumName) throws IOException {
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putInt(ARG_IMG_ID,imageId);
        args.putString(ARG_ALBUM_NAME, albumName);
        ImageFragment fragment = new ImageFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public ImageFragment() throws IOException {

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_image, container, false);
        final ImageView imageView = (ImageView)rootView.findViewById(R.id.image_fragment);
        imageView.setImageResource(imageId);

//        populateMusic(imageId);
//        int width = display
//        CoordinatorLayout.LayoutParams params = new CoordinatorLayout.LayoutParams(width, height)
        return rootView;
    }

//    private void populateMusic(int fileId) {
//
//        Album EminemAlbum = Album.Eminem;
//        Album CashAlbum = Album.Johnny_Cash;
//        Album ImagineAlbum = Album.Imagine_Dragons;
//        Album ColdplayAlbum = Album.Coldplay;
//        Album LinkinAlbum = Album.Linkin_Park;
//        Album Deadmou5Album = Album.Deadmou5;
//        Album OfMonstersAlbum = Album.Of_Monsters_and_Man;
//        Album LuminersAlbum = Album.The_Luminers;
//
//        this.imageId = fileId;
//
//        if (fileId == EminemAlbum.getAlbumCoverImageResource()) {
//            getFromResource(EMINEM);
//        } else if (fileId == CashAlbum.getAlbumCoverImageResource()) {
//            getFromResource(CASH);
//        } else if (fileId == ImagineAlbum.getAlbumCoverImageResource()) {
//            getFromResource(IMAGINE_DRAGONS);
//        } else if (fileId == ColdplayAlbum.getAlbumCoverImageResource()) {
//            getFromResource(COLDPLAY);
//        } else if (fileId == LinkinAlbum.getAlbumCoverImageResource()) {
//            getFromResource(LINKIN_PARK);
//        } else if (fileId == Deadmou5Album.getAlbumCoverImageResource()) {
//            getFromResource(DEADMOU5);
//        } else if (fileId == OfMonstersAlbum.getAlbumCoverImageResource()) {
//            getFromResource(OF_MONSTERS_AND_MAN);
//        } else if (fileId == LuminersAlbum.getAlbumCoverImageResource()) {
//            getFromResource(THE_LUMINERS);
//        }
//    }
//
//    private void getFromResource(String dirFrom){
//
//        Resources res = getResources();
//        AssetManager am = res.getAssets();
//        musicList = new String[0];
//
//        try {
//            musicList = am.list(dirFrom);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if(musicList != null){
//
//            Log.d("size", String.valueOf(dirFrom.length()));
//
////            for (int i=0; i<dirFrom.length(); i++){
////
////                Log.d("size  ", ((toString())dirFrom.length());
////
////            }
//
//        }
//
//    }

}
