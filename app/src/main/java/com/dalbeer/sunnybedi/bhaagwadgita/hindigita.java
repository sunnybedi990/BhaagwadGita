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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class hindigita extends Activity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, GestureDetector.OnGestureListener {
    int image_index = 0;
    private static final int MAX_IMAGE_COUNT = 139;

    private int[] mImageIds = {
            R.raw.hindiimage1,
            R.raw.hindiimage2,
            R.raw.hindiimage3,
            R.raw.hindiimage4,
            R.raw.hindiimage5,
            R.raw.hindiimage6,
            R.raw.hindiimage7,
            R.raw.hindiimage8,
            R.raw.hindiimage9,
            R.raw.hindiimage10,
            R.raw.hindiimage11,
            R.raw.hindiimage12,
            R.raw.hindiimage13,
            R.raw.hindiimage14,
            R.raw.hindiimage15,
            R.raw.hindiimage16,
            R.raw.hindiimage17,
            R.raw.hindiimage18,
            R.raw.hindiimage19,
            R.raw.hindiimage20,
            R.raw.hindiimage21,
            R.raw.hindiimage22,
            R.raw.hindiimage23,
            R.raw.hindiimage24,
            R.raw.hindiimage25,
            R.raw.hindiimage26,
            R.raw.hindiimage27,
            R.raw.hindiimage28,
            R.raw.hindiimage29,
            R.raw.hindiimage30,
            R.raw.hindiimage31,
            R.raw.hindiimage32,
            R.raw.hindiimage33,
            R.raw.hindiimage34,
            R.raw.hindiimage35,
            R.raw.hindiimage36,
            R.raw.hindiimage37,
            R.raw.hindiimage38,
            R.raw.hindiimage39,
            R.raw.hindiimage40,
            R.raw.hindiimage41,
            R.raw.hindiimage42,
            R.raw.hindiimage43,
            R.raw.hindiimage44,
            R.raw.hindiimage45,
            R.raw.hindiimage46,
            R.raw.hindiimage47,
            R.raw.hindiimage48,
            R.raw.hindiimage49,
            R.raw.hindiimage50,
            R.raw.hindiimage51,
            R.raw.hindiimage52,
            R.raw.hindiimage53,
            R.raw.hindiimage54,
            R.raw.hindiimage55,
            R.raw.hindiimage56,
            R.raw.hindiimage57,
            R.raw.hindiimage58,
            R.raw.hindiimage59,
            R.raw.hindiimage60,
            R.raw.hindiimage61,
            R.raw.hindiimage62,
            R.raw.hindiimage63,
            R.raw.hindiimage64,
            R.raw.hindiimage65,
            R.raw.hindiimage66,
            R.raw.hindiimage67,
            R.raw.hindiimage68,
            R.raw.hindiimage69,
            R.raw.hindiimage70,
            R.raw.hindiimage71,
            R.raw.hindiimage72,
            R.raw.hindiimage73,
            R.raw.hindiimage74,
            R.raw.hindiimage75,
            R.raw.hindiimage76,
            R.raw.hindiimage77,
            R.raw.hindiimage78,
            R.raw.hindiimage79,
            R.raw.hindiimage80,
            R.raw.hindiimage81,
            R.raw.hindiimage82,
            R.raw.hindiimage83,
            R.raw.hindiimage84,
            R.raw.hindiimage85,
            R.raw.hindiimage86,
            R.raw.hindiimage87,
            R.raw.hindiimage88,
            R.raw.hindiimage89,
            R.raw.hindiimage90,
            R.raw.hindiimage91,
            R.raw.hindiimage92,
            R.raw.hindiimage93,
            R.raw.hindiimage94,
            R.raw.hindiimage95,
            R.raw.hindiimage96,
            R.raw.hindiimage97,
            R.raw.hindiimage98,
            R.raw.hindiimage99,
            R.raw.hindiimage100,
            R.raw.hindiimage101,
            R.raw.hindiimage102,
            R.raw.hindiimage103,
            R.raw.hindiimage104,
            R.raw.hindiimage105,
            R.raw.hindiimage106,
            R.raw.hindiimage107,
            R.raw.hindiimage108,
            R.raw.hindiimage109,
            R.raw.hindiimage110,
            R.raw.hindiimage111,
            R.raw.hindiimage112,
            R.raw.hindiimage113,
            R.raw.hindiimage114,
            R.raw.hindiimage115,
            R.raw.hindiimage116,
            R.raw.hindiimage117,
            R.raw.hindiimage118,
            R.raw.hindiimage119,
            R.raw.hindiimage120,
            R.raw.hindiimage121,
            R.raw.hindiimage122,
            R.raw.hindiimage123,
            R.raw.hindiimage124,
            R.raw.hindiimage125,
            R.raw.hindiimage126,
            R.raw.hindiimage127,
            R.raw.hindiimage128,
            R.raw.hindiimage129,
            R.raw.hindiimage130,
            R.raw.hindiimage131,
            R.raw.hindiimage132,
            R.raw.hindiimage133,
            R.raw.hindiimage134,
            R.raw.hindiimage135,
            R.raw.hindiimage136,
            R.raw.hindiimage137,
            R.raw.hindiimage138,
            R.raw.hindiimage139

    };
    private EditText pagenum;
    protected GestureDetector gestureScanner;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private Animation slideLeftIn;
    private Animation slideLeftOut;
    private Animation slideRightIn;
    private Animation slideRightOut;
    private ImageView ll;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gestureScanner = new GestureDetector(this);
        setContentView(R.layout.activity_hindigita);


        //         Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //               .setAction("Action", null).show();
        Button btnPrevious = (Button) findViewById(R.id.btn_previous1);
        btnPrevious.setOnClickListener(this);
        Button btnNext = (Button) findViewById(R.id.btn_next1);
        btnNext.setOnClickListener(this);
        Button Gopage = (Button) findViewById(R.id.btn_go);
        Gopage.setOnClickListener(this);
        pagenum = (EditText) findViewById(R.id.edtxt_pagenum1);
        ll = (ImageView) findViewById(R.id.imgvw_main1);
        slideLeftIn = AnimationUtils.loadAnimation(this, R.anim.pull_in_left);
        slideLeftOut = AnimationUtils .loadAnimation(this, R.anim.push_out_left);
        slideRightIn = AnimationUtils .loadAnimation(this, R.anim.pull_in_right);
        slideRightOut = AnimationUtils.loadAnimation(this, R.anim.push_out_right);
        showImage();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layouthindi);
              ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_viewhindi);
              navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
         drawer = (DrawerLayout) findViewById(R.id.drawer_layouthindi);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
       // else {
        //    super.onBackPressed();
      //  }
    }


    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_english) {
            Intent a = new Intent(this, mainreading.class);
            startActivity(a);
            // Handle the camera action
        } else if (id == R.id.nav_hindi) {

        } else if (id == R.id.nav_Sanskrit) {

        } else if (id == R.id.nav_Tamil) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_exit) {
            Intent a = new Intent(this, MainActivity.class);
            startActivity(a);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layouthindi);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case (R.id.btn_previous1):

                image_index--;

                if (image_index == -1) {
                    image_index = MAX_IMAGE_COUNT - 1;
                }

                //     pagenum.setText(String.valueOf(image_index));
                showImage();

                break;

            case (R.id.btn_next1):

                image_index++;

                if (image_index == MAX_IMAGE_COUNT) {
                    image_index = 0;
                }
                //   pagenum.setText(String.valueOf(image_index));
                showImage();

                break;
            case (R.id.btn_go):

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
        ImageView imgView = (ImageView) findViewById(R.id.imgvw_main1);
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



