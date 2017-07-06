package com.example.arek.imagegallery;

import android.os.Environment;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Arek on 2017-05-27.
 */
public class SongsManager {

    //ACCESS SD CARD

    final String MEDIA_PATH = Environment.getExternalStorageDirectory().getPath()+"/Music/";

//    final String

    private ArrayList<HashMap<String,String>> mySongsList = new ArrayList<HashMap<String, String>>();

    public SongsManager(){

    }

    //We want to read mp3 files from sd card

    public ArrayList<HashMap<String,String>> getMySongsList(){



        return mySongsList;

    }

}
