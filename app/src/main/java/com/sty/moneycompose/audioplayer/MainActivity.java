package com.sty.moneycompose.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sty.moneycompose.audioplayer.play.AudioPlayer;

public class MainActivity extends AppCompatActivity {
    private EditText mEditView;
    private Button audioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mEditView = (EditText) findViewById(R.id.audio_edit);
        audioButton = findViewById(R.id.audio_button);
        audioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBtnAudioClicked();
            }
        });
    }

    private void onBtnAudioClicked() {
        String moneyStr = mEditView.getText().toString().trim();
        if(!TextUtils.isEmpty(moneyStr)) {
            AudioPlayer.getInstance().startPlay(getApplicationContext(), moneyStr);
        }
    }
}