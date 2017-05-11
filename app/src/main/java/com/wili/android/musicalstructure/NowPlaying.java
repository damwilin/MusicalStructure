package com.wili.android.musicalstructure;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class NowPlaying extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        ImageView library = (ImageView) findViewById(R.id.library);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NowPlaying.this, MusicLibraryActivity.class));
            }
        });
        ImageView search = (ImageView) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NowPlaying.this, SearchActivity.class));
            }
        });
        //Adding song to player
        mediaPlayer = MediaPlayer.create(this, R.raw.bensound_cute);

        final ImageView playButton = (ImageView) findViewById(R.id.play_song);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    playButton.setImageResource(R.drawable.ic_pause_black_24dp);
                } else {
                    mediaPlayer.pause();
                    playButton.setImageResource(R.drawable.arrow_black_24dp);
                }
            }
        });
        ImageView nextSong = (ImageView) findViewById(R.id.next_song);
        nextSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void moveSongToMiddle() {
        int currPosition = mediaPlayer.getCurrentPosition();
        int duration = mediaPlayer.getDuration();
        if ((duration - currPosition) > 15)
            mediaPlayer.seekTo(currPosition + 15);
    }
}
