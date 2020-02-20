package com.tiandennis.lab03;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView topLeft, topRight, bottomLeft, bottomRight;
    SharedPreferences sharedPreferences;
    View.OnClickListener listener;
    SharedPreferences.Editor editor;
    SeekBar seekBar;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(seekBarListener);
        context = getApplicationContext();
        sharedPreferences = getSharedPreferences("clicks", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView temp = (TextView) v;
                String text = temp.getText().toString();
                int clicks = sharedPreferences.getInt(text, 0);
                editor.putInt(text, clicks += 1);
                editor.apply();
                String times = " times. ";
                if(clicks == 1)
                    times = " time. ";
                Toast.makeText(context, text.replace(" ", "-") + " TextView clicked " + clicks + times, Toast.LENGTH_SHORT).show();
            }
        };
        topLeft = findViewById(R.id.top_left);
        topRight = findViewById(R.id.top_right);
        bottomLeft = findViewById(R.id.bottom_left);
        bottomRight = findViewById(R.id.bottom_right);
        topLeft.setOnClickListener(listener);
        topRight.setOnClickListener(listener);
        bottomLeft.setOnClickListener(listener);
        bottomRight.setOnClickListener(listener);
    }

    private SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            topLeft.setTextSize(progress);
            topRight.setTextSize(progress);
            bottomLeft.setTextSize(progress);
            bottomRight.setTextSize(progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}
