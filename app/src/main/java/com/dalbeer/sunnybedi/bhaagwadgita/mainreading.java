package com.dalbeer.sunnybedi.bhaagwadgita;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by sunnybedi on 20/06/17.
 */
public class mainreading extends Activity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, GestureDetector.OnGestureListener {
    int image_index = 0;
    private static final int MAX_IMAGE_COUNT = 179;

    private int[] mImageIds = {
            R.raw.englishimage1,
            R.raw.englishimage2,
            R.raw.englishimage3,
            R.raw.englishimage4,
            R.raw.englishimage5,
            R.raw.englishimage6,
            R.raw.englishimage7,
            R.raw.englishimage8,
            R.raw.englishimage9,
            R.raw.englishimage10,
            R.raw.englishimage11,
            R.raw.englishimage12,
            R.raw.englishimage13,
            R.raw.englishimage14,
            R.raw.englishimage15,
            R.raw.englishimage16,
            R.raw.englishimage17,
            R.raw.englishimage18,
            R.raw.englishimage19,
            R.raw.englishimage20,
            R.raw.englishimage21,
            R.raw.englishimage22,
            R.raw.englishimage23,
            R.raw.englishimage24,
            R.raw.englishimage25,
            R.raw.englishimage26,
            R.raw.englishimage27,
            R.raw.englishimage28,
            R.raw.englishimage29,
            R.raw.englishimage30,
            R.raw.englishimage31,
            R.raw.englishimage32,
            R.raw.englishimage33,
            R.raw.englishimage34,
            R.raw.englishimage35,
            R.raw.englishimage36,
            R.raw.englishimage37,
            R.raw.englishimage38,
            R.raw.englishimage39,
            R.raw.englishimage40,
            R.raw.englishimage41,
            R.raw.englishimage42,
            R.raw.englishimage43,
            R.raw.englishimage44,
            R.raw.englishimage45,
            R.raw.englishimage46,
            R.raw.englishimage47,
            R.raw.englishimage48,
            R.raw.englishimage49,
            R.raw.englishimage50,
            R.raw.englishimage51,
            R.raw.englishimage52,
            R.raw.englishimage53,
            R.raw.englishimage54,
            R.raw.englishimage55,
            R.raw.englishimage56,
            R.raw.englishimage57,
            R.raw.englishimage58,
            R.raw.englishimage59,
            R.raw.englishimage60,
            R.raw.englishimage61,
            R.raw.englishimage62,
            R.raw.englishimage63,
            R.raw.englishimage64,
            R.raw.englishimage65,
            R.raw.englishimage66,
            R.raw.englishimage67,
            R.raw.englishimage68,
            R.raw.englishimage69,
            R.raw.englishimage70,
            R.raw.englishimage71,
            R.raw.englishimage72,
            R.raw.englishimage73,
            R.raw.englishimage74,
            R.raw.englishimage75,
            R.raw.englishimage76,
            R.raw.englishimage77,
            R.raw.englishimage78,
            R.raw.englishimage79,
            R.raw.englishimage80,
            R.raw.englishimage81,
            R.raw.englishimage82,
            R.raw.englishimage83,
            R.raw.englishimage84,
            R.raw.englishimage85,
            R.raw.englishimage86,
            R.raw.englishimage87,
            R.raw.englishimage88,
            R.raw.englishimage89,
            R.raw.englishimage90,
            R.raw.englishimage91,
            R.raw.englishimage92,
            R.raw.englishimage93,
            R.raw.englishimage94,
            R.raw.englishimage95,
            R.raw.englishimage96,
            R.raw.englishimage97,
            R.raw.englishimage98,
            R.raw.englishimage99,
            R.raw.englishimage100,
            R.raw.englishimage101,
            R.raw.englishimage102,
            R.raw.englishimage103,
            R.raw.englishimage104,
            R.raw.englishimage105,
            R.raw.englishimage106,
            R.raw.englishimage107,
            R.raw.englishimage108,
            R.raw.englishimage109,
            R.raw.englishimage110,
            R.raw.englishimage111,
            R.raw.englishimage112,
            R.raw.englishimage113,
            R.raw.englishimage114,
            R.raw.englishimage115,
            R.raw.englishimage116,
            R.raw.englishimage117,
            R.raw.englishimage118,
            R.raw.englishimage119,
            R.raw.englishimage120,
            R.raw.englishimage121,
            R.raw.englishimage122,
            R.raw.englishimage123,
            R.raw.englishimage124,
            R.raw.englishimage125,
            R.raw.englishimage126,
            R.raw.englishimage127,
            R.raw.englishimage128,
            R.raw.englishimage129,
            R.raw.englishimage130,
            R.raw.englishimage131,
            R.raw.englishimage132,
            R.raw.englishimage133,
            R.raw.englishimage134,
            R.raw.englishimage135,
            R.raw.englishimage136,
            R.raw.englishimage137,
            R.raw.englishimage138,
            R.raw.englishimage139,
            R.raw.englishimage140,
            R.raw.englishimage141,
            R.raw.englishimage142,
            R.raw.englishimage143,
            R.raw.englishimage144,
            R.raw.englishimage145,
            R.raw.englishimage146,
            R.raw.englishimage147,
            R.raw.englishimage148,
            R.raw.englishimage149,
            R.raw.englishimage150,
            R.raw.englishimage151,
            R.raw.englishimage152,
            R.raw.englishimage153,
            R.raw.englishimage154,
            R.raw.englishimage155,
            R.raw.englishimage156,
            R.raw.englishimage157,
            R.raw.englishimage158,
            R.raw.englishimage159,
            R.raw.englishimage160,
            R.raw.englishimage161,
            R.raw.englishimage162,
            R.raw.englishimage163,
            R.raw.englishimage164,
            R.raw.englishimage165,
            R.raw.englishimage166,
            R.raw.englishimage167,
            R.raw.englishimage168,
            R.raw.englishimage169,
            R.raw.englishimage170,
            R.raw.englishimage171,
            R.raw.englishimage172,
            R.raw.englishimage173,
            R.raw.englishimage174,
            R.raw.englishimage175,
            R.raw.englishimage176,
            R.raw.englishimage177,
            R.raw.englishimage178,
            R.raw.englishimage179

    };
    private EditText pagenum;
    protected GestureDetector gestureScanner;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gestureScanner = new GestureDetector(this);
        setContentView(R.layout.activity_mainreadingscreen);


        //         Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //               .setAction("Action", null).show();
        Button btnPrevious = (Button) findViewById(R.id.btn_previous);
        btnPrevious.setOnClickListener(this);
        Button btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
        pagenum = (EditText) findViewById(R.id.edtxt_pagenum);
        Button Gopage = (Button) findViewById(R.id.btn_goenglish);
        Gopage.setOnClickListener(this);
        showImage();


         DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layoutenglish);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_viewenglish);
        navigationView.setNavigationItemSelectedListener(this);

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layoutenglish);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
       // }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_english) {
        //    Intent a = new Intent(this, mainreading.class);
          //  startActivity(a);
            // Handle the camera action
        } else if (id == R.id.nav_hindi) {
            Intent a = new Intent(this, hindigita.class);
            startActivity(a);
        } else if (id == R.id.nav_Sanskrit) {

        } else if (id == R.id.nav_Tamil) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_exit) {
            Intent a = new Intent(this, MainActivity.class);
            startActivity(a);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layoutenglish);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case (R.id.btn_previous):

                image_index--;

                if (image_index == -1) {
                    image_index = MAX_IMAGE_COUNT - 1;
                }

                //     pagenum.setText(String.valueOf(image_index));
                showImage();

                break;

            case (R.id.btn_next):

                image_index++;

                if (image_index == MAX_IMAGE_COUNT) {
                    image_index = 0;
                }
                //   pagenum.setText(String.valueOf(image_index));
                showImage();

                break;
            case (R.id.btn_goenglish):

                image_index = Integer.valueOf(pagenum.getText().toString());

                if (image_index < MAX_IMAGE_COUNT) {
                    showImage();
                }
                //   pagenum.setText(String.valueOf(image_index));
                //   showImage();

                break;

        }

    }

    private void showImage() {
        ImageView imgView = (ImageView) findViewById(R.id.imgvw_main);
        imgView.setImageResource(mImageIds[image_index]);
        pagenum.setText(String.valueOf(image_index));
    }
    @Override
    public boolean onTouchEvent(MotionEvent me) {
        return gestureScanner.onTouchEvent(me);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        try {
            if (e1.getX() > e2.getX() && Math.abs(e1.getX() - e2.getX()) > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                Toast.makeText(this.getApplicationContext(), "Left", Toast.LENGTH_SHORT).show();
                // vf.showPrevious();
                //     ll.setAnimation(slideLeftIn);
                //    ll.setAnimation(slideLeftOut);
                image_index++;
                if (image_index == MAX_IMAGE_COUNT) {
                    image_index = 0;
                }

                //     pagenum.setText(String.valueOf(image_index));
                showImage();
            } else if (e1.getX() < e2.getX() && e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                    && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                Toast.makeText(this.getApplicationContext(), "Right", Toast.LENGTH_SHORT).show();
                // vf.showNext();
                image_index--;
                //  ll.setAnimation(slideRightIn);
                //  ll.setAnimation(slideRightOut);


                if (image_index == -1) {
                    image_index = MAX_IMAGE_COUNT - 1;
                }

                //     pagenum.setText(String.valueOf(image_index));
                showImage();
            }
        } catch (Exception e) { // nothing
        } return true;
    }

}

