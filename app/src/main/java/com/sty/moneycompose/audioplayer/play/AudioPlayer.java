package com.sty.moneycompose.audioplayer.play;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Author: tian
 * @UpdateDate: 2020/11/3 4:40 PM
 */
public class AudioPlayer {
    private Executor mNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
    private static AudioPlayer mInstance;
    private AudioPlayerRunnable mPlayerRunnable;

    private AudioPlayer() {

    }

    public static AudioPlayer getInstance() {
        if (mInstance == null) {
            mInstance = new AudioPlayer();
        }
        return mInstance;
    }

    public void startPlay(Context context, String money){
        mPlayerRunnable = new AudioPlayerRunnable(context, money);
        mNewSingleThreadExecutor.execute(mPlayerRunnable);
    }

    public void releasePlayer() {
        if(mPlayerRunnable != null){
            mPlayerRunnable.releasePlayer();
        }
    }
}
