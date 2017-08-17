package com.dalbeer.sunnybedi.bhaagwadgita;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class hanumanchalisahindi extends Activity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, GestureDetector.OnGestureListener {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    int image_index = 0;
    private static final int MAX_IMAGE_COUNT = 139;

    private int[] mImageIds = {
            R.raw.hindiimage1,
            R.raw.hindiimage2,
            };
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;
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
    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            // Delayed display of UI elements
            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
            mControlsView.setVisibility(View.VISIBLE);
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            hide();
        }
    };
    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_hanumanchalisahindi);

        mVisible = true;
        mControlsView = findViewById(R.id.fullscreen_content_controls);
        mContentView = findViewById(R.id.fullscreen_content);


        // Set up the user interaction to manually show or hide the system UI.
        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
        findViewById(R.id.dummy_button).setOnTouchListener(mDelayHideTouchListener);
        Button btnPrevious = (Button) findViewById(R.id.btn_previous2);
        btnPrevious.setOnClickListener(this);
        Button btnNext = (Button) findViewById(R.id.btn_next2);
        btnNext.setOnClickListener(this);
        Button Gopage = (Button) findViewById(R.id.btn_go);
        Gopage.setOnClickListener(this);
        pagenum = (EditText) findViewById(R.id.edtxt_pagenum2);
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

            case (R.id.btn_previous2):

                image_index--;

                if (image_index == -1) {
                    image_index = MAX_IMAGE_COUNT - 1;
                }

                //     pagenum.setText(String.valueOf(image_index));
                showImage();

                break;

            case (R.id.btn_next2):

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


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in [delay] milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }
}
