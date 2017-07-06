package com.example.arek.imagegallery;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DetailActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    public ArrayList<AlbumModel> data = new ArrayList<>();
    private int pos = 0;
    private String title;
    private ImageButton playButton;
    private ImageButton backwardButton;
    private ImageButton forwardButton;
    MediaPlayer mediaPlayer = new MediaPlayer();
    private int position;
    Context context;
    private Button backButton;
    private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();


//    private static final String EMINEM = ("/assets/eminem");
//    private static final String COLDPLAY = ("/assets/coldplay");
//    private static final String DEADMOU5 = ("/assets/deadmau5");
//    private static final String IMAGINE_DRAGONS = ("/assets/imagine_dragons");
//    private static final String LINKIN_PARK = ("/assets/linkin_park");
//    private static final String OF_MONSTERS_AND_MAN = ("/assets/of_monsters_and_man");
//    private static final String THE_LUMINERS = ("/assets/the_luminers");
//    private static final String CASH = ("/assets/cash");


//    String[] cashMusic = manager.list("cash");
//    String[] coldplayMusic = manager.list("coldplay");
//    String[] eminemMusic = manager.list("eminem");
//    String[] deadmou5Music = manager.list("deadmou5");
//    String[] dragonsMusic = manager.list("imagine_dragons");
//    String[] linkinParkMusic = manager.list("linkin_park");
//    String[] monstersMusic = manager.list("of_monsters_and_man");
//    String[] theLuminers = manager.list("the_luminers");
//
//    ArrayList<String> listCashMusic = new ArrayList<String>(Arrays.asList(cashMusic));
//    ArrayList<String> listEminemMusic = new ArrayList<String>(Arrays.asList(eminemMusic));
//    ArrayList<String> listColdplayMusic = new ArrayList<String>(Arrays.asList(coldplayMusic));
//    ArrayList<String> listdeadmou5Music = new ArrayList<String>(Arrays.asList(deadmou5Music));
//    ArrayList<String> listImagineDragonsMusic = new ArrayList<String>(Arrays.asList(cashMusic));
//    ArrayList<String> listLinkinParkMusic = new ArrayList<String>(Arrays.asList(cashMusic));
//    InputStream cashInputStream = getApplicationContext().getAssets().open("cash/" + listCashMusic.get(position));
//    private String test = cashInputStream.toString();
//    InputStream eminemStream =


    private ImagePagerAdapter mImagePagerAdapter;
    private ViewPager viewPager;

    public DetailActivity() throws IOException {
    }

    @Override
    public void onBackPressed() {
           }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        playButton = (ImageButton) findViewById(R.id.btn_play_id);
        backwardButton = (ImageButton) findViewById(R.id.btn_backward_id);
        forwardButton = (ImageButton) findViewById(R.id.btn_forward_id);

        data = getIntent().getParcelableArrayListExtra("data");
        pos = getIntent().getIntExtra("position", 0);
        int currentImageId = data.get(pos).getImageId();
//        title = getIntent().getParcelableExtra();
        mImagePagerAdapter = new ImagePagerAdapter(getSupportFragmentManager(), data);
        viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(mImagePagerAdapter);
        viewPager.setCurrentItem(pos);
//        manageButtons(currentImageId);

//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                finish();
//
//            }
//        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//        onBackPressed();

    }

    private void manageButtons(int imageId) {

        int currentAlbumId = imageId;


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                playSong();

            }
        });

        backwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                backwardAction();

            }
        });

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                forwardAction();

            }
        });

    }


    private void pupulateMusic() {


    }

    private void backwardAction() {


    }

    private void forwardAction() {


    }

    private void playSong(int songId) {

//        Log.d("", test);
        int song = songId;


//            mediaPlayer.reset();
//            mediaPlayer.setDataSource();
//            mediaPlayer.prepare();

//        Log.d()
            mediaPlayer.start();

            //Display song title

            //change button image to pause

            //set progressBar values

            //update progressBar



    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}