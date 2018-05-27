package com.example.test.instagram.Profile;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toolbar;

import com.example.test.instagram.R;
import com.example.test.instagram.Utils.BottomNavigationViewHelper;
import com.example.test.instagram.Utils.GridImageAdapter;
import com.example.test.instagram.Utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM = 4;
    private static final int NUM_GRID_COLUMNS = 3;

    private Context mContext = ProfileActivity.this;
    private ImageView profilePhoto;

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: stared.");

        init();

//        setupBottomNavigationView();
//        setupToolbar();
//        setupActivityWidgets();
//        setProfileImage();
//
//        tempGridSetup();

    }

    private void init(){
        Log.d(TAG, "init: inflating " + getString(R.string.profile_fragment));

        ProfileFragment fragment = new ProfileFragment();
        FragmentTransaction transaction = ProfileActivity.this.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(getString(R.string.profile_fragment));
        transaction.commit();
    }
//    private  void tempGridSetup(){
//        ArrayList<String> imgURLs = new ArrayList<>();
//        imgURLs.add("http://cfile6.uf.tistory.com/image/99F6B63359F06F0E2A1596");
//        imgURLs.add("https://i.pinimg.com/originals/fe/56/e7/fe56e70988f931767854b0f43ae87cba.jpg");
//        imgURLs.add("http://image.news1.kr/system/photos/2017/3/31/2459746/article.jpg");
//        imgURLs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTOVDo4peMRmfgCHww9FPSrk9aksBmfS_zCR5K3Kga6qiOgqTzM");
//        imgURLs.add("http://www.redkspot.com/wp-content/uploads/2017/11/%E1%84%8B%E1%85%A1%E1%84%8B%E1%85%B5%E1%84%85%E1%85%B5%E1%86%AB.jpg");
//        imgURLs.add("http://img.etoday.co.kr/pto_db/2018/02/20180207224254_1184560_600_818.jpg");
//        imgURLs.add("http://www.fashionn.com/files/board/2018/image/p1c43eesgkvibf9h18p535djeb1.jpg");
//        imgURLs.add("http://www.topstarnews.net/news/photo/first/201712/img_341904_1_org.jpg");
//        imgURLs.add("http://cdninterfootball.heraldcorp.com/news/photo/201803/189148_212380_473.jpg");
//
//        setupImageGrid(imgURLs);
//
//    }
//
//    private void setupImageGrid(ArrayList<String> imgURLs){
//        GridView gridView = (GridView) findViewById(R.id.gridView);
//
//        int gridWidth = getResources().getDisplayMetrics().widthPixels;
//        int imageWidth = gridWidth/NUM_GRID_COLUMNS;
//        gridView.setColumnWidth(imageWidth);
//
//        GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview, "", imgURLs);
//        gridView.setAdapter(adapter);
//    }
//
//    private void setProfileImage(){
//        Log.d(TAG, "setProfileImage: setting profile photo.");
//        String imgURL = "cfile21.uf.tistory.com/image/235E8E33597B3F3529A9BD";
//        UniversalImageLoader.setImage(imgURL, profilePhoto, mProgressBar, "http://");
//
//    }
//
//    private void setupActivityWidgets(){
//        mProgressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
//        mProgressBar.setVisibility(View.GONE);
//        profilePhoto = (ImageView) findViewById(R.id.profile_photo);
//    }
//
//    /**
//     * Responsible for setting up the profile toolbar
//     */
//
//    private void setupToolbar(){
//        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.profileToolBar);
//        setSupportActionBar(toolbar);
//
//        ImageView profilemenu = (ImageView) findViewById(R.id.profileMenu);
//        profilemenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "onClick: navigating to account settings. ");
//                Intent intent = new Intent(mContext, AccountSettingsActivity.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    /**
//     * BottomNavigationView setup
//     */
//    private void setupBottomNavigationView() {
//        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
//        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
//        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
//        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
//        Menu menu = bottomNavigationViewEx.getMenu();
//        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
//        menuItem.setChecked(true);
//    }

}
