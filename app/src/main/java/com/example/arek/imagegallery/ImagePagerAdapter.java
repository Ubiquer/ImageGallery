package com.example.arek.imagegallery;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Arek on 2017-03-18.
 */
public class ImagePagerAdapter extends FragmentPagerAdapter {

    public ArrayList<AlbumModel> data = new ArrayList<>();

//    ImageFragment imageFragment = new ImageFragment();

    public ImagePagerAdapter(FragmentManager fm, ArrayList<AlbumModel> data) {
        super(fm);
        this.data = data;
    }

    public Fragment getItem(int position) {
//        return ImageFragment.newInstance(data.get(position).getImageId());
        try {
            return ImageFragment.newInstance(position, data.get(position).getImageId(),data.get(position).getAlbumName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getCount() {

        return data.size();
    }

}
