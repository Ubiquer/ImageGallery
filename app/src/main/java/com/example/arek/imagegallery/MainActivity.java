package com.example.arek.imagegallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    RecyclerView galleryRecyclerView;
    AlbumGalleryAdapter galleryAdapter;
    ArrayList<AlbumModel> albumModelArrayList = new ArrayList<>();


    GridLayoutManager layoutManager;
    private static final String POSITION = "position";
    private static final String DATA = "data";
    private static final String ALBUMNAME = "album_name";

    private final Integer imageIds[] = {R.drawable.coldplay, R.drawable.eminem,
                                        R.drawable.imaginedragons, R.drawable.johnnycash,
                                        R.drawable.linkinpark, R.drawable.of_monsters_and_man,
                                        R.drawable.deadmou5e, R.drawable.theluminers};

    private final String albumNames[] = {"Coldplay", "Eminem", "Imagine Dragons", "Johnny Cash",
                                         "Linkin Park", "Of Monsters and Man", "The Beatles", "The Luminers"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        galleryRecyclerView = (RecyclerView) findViewById(R.id.image_gallery);
        layoutManager = new MyLayoutManager(this,2);

        galleryRecyclerView.setLayoutManager(layoutManager);
        galleryRecyclerView.setHasFixedSize(true);
        albumModelArrayList = prepareData();
        galleryAdapter = new AlbumGalleryAdapter(MainActivity.this, albumModelArrayList);
        galleryRecyclerView.setAdapter(galleryAdapter);
        setRecyclerViewScrollListener();

        galleryRecyclerView.addOnItemTouchListener(new AlbumGalleryAdapter.RecyclerTouchListener
                (getApplicationContext(), galleryRecyclerView, new AlbumGalleryAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putParcelableArrayListExtra(DATA, albumModelArrayList);
                intent.putExtra(POSITION, position);
//                intent.putExtra(ALBUMNAME, )
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }
    public ArrayList<AlbumModel> prepareData(){

        ArrayList<AlbumModel> albumModels = new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++){
            AlbumModel albumModel = new AlbumModel();
            albumModel.setTitle(albumNames[i]);
            albumModel.setImageId(imageIds[i]);
            albumModels.add(albumModel);
        }
        return albumModels;
    }


    private void setRecyclerViewScrollListener(){

        galleryRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                View firstVisibleItemView = layoutManager.findViewByPosition(firstVisibleItemPosition);
                View lastVisibleItemView = layoutManager.findViewByPosition(lastVisibleItemPosition);
//                int lastItemHeight = lastVisibleItemView.getLayoutParams().height;
                int firstItemHeight = firstVisibleItemView.getLayoutParams().height;
//                int parentViewHeight = galleryRecyclerView.getLayoutParams().height;
//
                //TODO: 265 stands for half of itemView height, get itemHeight and pass it to if statement
                final int fixedHeight = 265;
                if(firstItemHeight>fixedHeight){

                    galleryRecyclerView.smoothScrollToPosition(firstVisibleItemPosition);

                }
                else if (firstItemHeight<fixedHeight){

                    galleryRecyclerView.smoothScrollToPosition(lastVisibleItemPosition);

                }
            }
        });

    }

//    boolean isLastItemVisible(){
//
//        GridLayoutManager gridLayoutManager = ((GridLayoutManager))
//
//    }

}
