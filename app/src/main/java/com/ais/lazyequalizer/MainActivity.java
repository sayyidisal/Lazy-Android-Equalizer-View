package com.ais.lazyequalizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ais.lazylibequalizer.LazyEqualizer;

public class MainActivity extends AppCompatActivity {
    LazyEqualizer equalizer;
    Button button;
    boolean isplaying;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isplaying = false;
        equalizer = findViewById(R.id.lazy_eq);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
                @Override
                 public void onClick(View view) {
                    if (isplaying) {
                        button.setText("STOP");
                        isplaying = false;
                        equalizer.startView();
                    }
                    else {
                        button.setText("START");
                        isplaying = true;
                        equalizer.stopView();
                    }
                }
            });
     }

}
