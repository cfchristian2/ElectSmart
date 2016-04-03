package com.electsmart.electsmart;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

/**
 *
 * Helper class to download the passed in Url Image into a bitMap.
 */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bitMapImage;
    public DownloadImageTask(ImageView bitMapImage){
        this.bitMapImage = bitMapImage;
    }
    protected Bitmap doInBackground(String... urls){
        String urlDisplay = urls[0];
        Bitmap bmMap = null;
        try{
            InputStream inp = new URL(urlDisplay).openStream();
            bmMap = BitmapFactory.decodeStream(inp);

        }catch(Exception ex){
            //Problem building the bitmap
        }
        return bmMap;
    }

    protected void onPostExecute(Bitmap result){
        bitMapImage.setImageBitmap(result);
    }
}
