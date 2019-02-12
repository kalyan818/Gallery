package com.example.kalya.gallery;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.fingerprint.FingerprintManager;
import android.media.Image;
import android.os.Build;
import android.os.CancellationSignal;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.security.KeyStore;
import java.util.ArrayList;

import javax.crypto.Cipher;

@TargetApi(Build.VERSION_CODES.M)
public class FingerprintHandler extends FingerprintManager.AuthenticationCallback {

    private Context context;
    private KeyStore keyStore;
    private Cipher cipher;
    private String KEY_NAME = "AndroidKey";
    static ArrayList<Bitmap> temp = new ArrayList<Bitmap>();
    static String[] lang = {"java","c","python"};
    Bitmap[] bp;
    static Bitmap hj;
    static RecyclerView rec1;

    public FingerprintHandler(Context context){

        this.context = context;

    }

    public void startAuth(FingerprintManager fingerprintManager, FingerprintManager.CryptoObject cryptoObject){

        CancellationSignal cancellationSignal = new CancellationSignal();
        fingerprintManager.authenticate(cryptoObject, cancellationSignal, 0, this, null);

    }

    @Override
    public void onAuthenticationFailed() {

        Toast.makeText(context,"error",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {

        Toast.makeText(context,"ok",Toast.LENGTH_LONG).show();
            File file = new File("/sdcard/Gallery1/");
            File[] files = file.listFiles();
            for (int i = 0;i<files.length;i++)
            {
                hj = BitmapFactory.decodeFile(file +"/"+ files[i].getName());
                temp.add(hj);
            }
            MainActivity.rec1.setAdapter(new RecAdapter(temp));
        }

    }