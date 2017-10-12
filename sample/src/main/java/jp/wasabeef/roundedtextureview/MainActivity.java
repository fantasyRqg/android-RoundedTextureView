package jp.wasabeef.roundedtextureview;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;

import rqg.fantasy.roundedvideoview.RoundedTextureView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RoundedTextureView mRoundedTextureView;
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRoundedTextureView = (RoundedTextureView) findViewById(R.id.round_video);

        mRoundedTextureView.setCornerRadius(20);

        mPlayer = MediaPlayer.create(this, R.raw.sample);

        mRoundedTextureView.setSurfaceProvider(surface -> {
            mPlayer.setSurface(new Surface(surface));
            mPlayer.start();
        });
    }
}
