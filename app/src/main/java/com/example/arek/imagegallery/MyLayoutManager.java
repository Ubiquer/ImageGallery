package com.example.arek.imagegallery;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * Created by Arek on 2017-05-26.
 */
import android.support.v7.widget.LinearSmoothScroller;

public class MyLayoutManager extends GridLayoutManager {

    private static final float MILISEC_PER_INCH =300f;
    private int mFirstVisiblePosition;

    private Context mContext;

    public MyLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
        mContext = context;
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {

        LinearSmoothScroller smoothScroller = new LinearSmoothScroller(mContext){

            @Nullable
            @Override
            public PointF computeScrollVectorForPosition(int targetPosition) {

                return MyLayoutManager.this.computeScrollVectorForPosition(targetPosition);
            }
            @Override
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {

                return MILISEC_PER_INCH/displayMetrics.densityDpi;
            }
        };

        smoothScroller.setTargetPosition(position);
        startSmoothScroll(smoothScroller);

    }
}
