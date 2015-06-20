package com.example.matthewell.asynctaskproject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.apache.http.HttpConnection;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_main);

        ImageDownloader imageDownloader = new ImageDownloader();
        imageDownloader.execute("https://raw.githubusercontent.com/ellm/CS6392015/master/EllMatthewSuffern.jpg");

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    private class ImageDownloader extends AsyncTask<String, Integer, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection httpCon =
                        (HttpURLConnection) url.openConnection();

                if (httpCon.getResponseCode() != 200)
                    throw new Exception("Failed to connect");

                InputStream is = httpCon.getInputStream();
                return BitmapFactory.decodeStream(is);
            } catch (Exception e) {
                Log.e("Image", "Failed to load image", e);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... params) {
            //Update a progress bar here, or ignore it, it's up to you
        }

        @Override
        protected void onPostExecute(Bitmap img) {
            ImageView iv = (ImageView) getView().findViewById(R.id.remote_image);
            if (iv != null && img != null) {
                iv.setImageBitmap(img);
            }
        }

        @Override
        protected void onCancelled() {
            //
        }

    }
}
