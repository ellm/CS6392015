package com.example.matthewell.imageviewer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private int mrePhotoIndex = 0;
    private int[] mrePhotoID = new int[] { R.drawable.android_shark_1080x1920,
            R.drawable.android_shark_gw, R.drawable.android_shark_kp, R.drawable.android_shark_mango,
            R.drawable.android_shark_openl };

    private void showPhoto(int PhotoIndex) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        imageView.setImageResource(mrePhotoID[PhotoIndex]);
    }

    public void btnNextOnClick(View view) {
        mrePhotoIndex = (mrePhotoIndex + 1) % mrePhotoID.length;
        showPhoto(mrePhotoIndex);
    }

    public void btnPrevOnClick(View view) {
        mrePhotoIndex = ((mrePhotoIndex - 1) >= 0 ? (mrePhotoIndex - 1) : 0) % mrePhotoID.length;
        showPhoto(mrePhotoIndex);
    }
}
