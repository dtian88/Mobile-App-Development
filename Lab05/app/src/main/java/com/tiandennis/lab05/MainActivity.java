package com.tiandennis.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    LifeCycle set1;
    Button resetButton;
    TextView create, start, resume, pause, stop, restart, destroy, create_2, start_2, resume_2, pause_2, stop_2, restart_2, destroy_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetButton = findViewById(R.id.reset);
        create = findViewById(R.id.create);
        start = findViewById(R.id.start);
        resume = findViewById(R.id.resume);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);
        restart = findViewById(R.id.restart);
        destroy = findViewById(R.id.destroy);

        create_2 = findViewById(R.id.create_2);
        start_2 = findViewById(R.id.start_2);
        resume_2 = findViewById(R.id.resume_2);
        pause_2 = findViewById(R.id.pause_2);
        stop_2 = findViewById(R.id.stop_2);
        restart_2 = findViewById(R.id.restart_2);
        destroy_2 = findViewById(R.id.destroy_2);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set1.reset();
                editor.putInt("create", 0).putInt("start", 0).putInt("resume", 0).putInt("pause", 0).putInt("stop", 0).putInt("restart", 0).putInt("destroy", 0);
                editor.apply();
                create.setText("onCreate(): 0");
                create_2.setText("onCreate(): 0");
                start.setText("onStart(): 0");
                start_2.setText("onStart(): 0");
                resume.setText("onResume(): 0");
                resume_2.setText("onResume(): 0");
                pause.setText("onPause(): 0");
                pause_2.setText("onPause(): 0");
                stop.setText("onStop(): 0");
                stop_2.setText("onStop(): 0");
                restart.setText("onRestart(): 0");
                restart_2.setText("onRestart(): 0");
                destroy.setText("onDestroy(): 0");
                destroy_2.setText("onDestroy(): 0");
            }
        });
        set1 = new LifeCycle(0, 0, 0, 0, 0, 0, 0);
        sharedPreferences = getSharedPreferences("lifecycle", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt("create", sharedPreferences.getInt("create", 0) + 1);
        editor.apply();
        set1.incrementCreate();
        create.setText("onCreate(): " + set1.getCreate());
        create_2.setText("onCreate(): " + sharedPreferences.getInt("create", 0));
        start.setText("onStart(): 0");
        start_2.setText("onStart(): " + sharedPreferences.getInt("start", 0));
        resume.setText("onResume(): 0");
        resume_2.setText("onResume(): 0" + sharedPreferences.getInt("resume", 0));
        pause.setText("onPause(): 0");
        pause_2.setText("onPause(): " + sharedPreferences.getInt("pause", 0));
        stop.setText("onStop(): 0");
        stop_2.setText("onStop(): " + sharedPreferences.getInt("stop", 0));
        restart.setText("onRestart(): 0");
        restart_2.setText("onRestart(): " + sharedPreferences.getInt("restart", 0));
        destroy.setText("onDestroy(): 0");
        destroy_2.setText("onDestroy(): " + sharedPreferences.getInt("destroy", 0));
    }

    protected void onStart() {
        super.onStart();
        set1.incrementStart();
        editor.putInt("start", sharedPreferences.getInt("start", 0) + 1);
        editor.apply();
        start.setText("onStart(): " + set1.getStart());
        start_2.setText("onStart(): " + sharedPreferences.getInt("start", 0));
    }

    protected void onResume() {
        super.onResume();
        set1.incrementResume();
        editor.putInt("resume", sharedPreferences.getInt("resume", 0) + 1);
        editor.apply();
        resume.setText("onResume(): " + set1.getResume());
        resume_2.setText("onResume(): " + sharedPreferences.getInt("resume", 0));
    }

    protected void onPause() {
        super.onPause();
        set1.incrementPause();
        editor.putInt("pause", sharedPreferences.getInt("pause", 0) + 1);
        editor.apply();
        pause.setText("onPause(): " + set1.getPause());
        pause_2.setText("onPause(): " + sharedPreferences.getInt("pause", 0));
    }

    protected void onStop() {
        super.onStop();
        set1.incrementStop();
        editor.putInt("stop", sharedPreferences.getInt("stop", 0) + 1);
        editor.apply();
        stop.setText("onStop(): " + set1.getStop());
        stop_2.setText("onStop(): " + sharedPreferences.getInt("stop", 0));
    }

    protected void onRestart() {
        super.onRestart();
        set1.incrementRestart();
        editor.putInt("restart", sharedPreferences.getInt("restart", 0) + 1);
        editor.apply();
        restart.setText("onRestart(): " + set1.getRestart());
        restart_2.setText("onRestart(): " + sharedPreferences.getInt("restart", 0));
    }

    protected void onDestroy() {
        super.onDestroy();
        set1.incrementDestroy();
        editor.putInt("destroy", sharedPreferences.getInt("destroy", 0) + 1);
        editor.apply();
        destroy.setText("onDestroy(): " + set1.getDestroy());
        destroy_2.setText("onDestroy(): " + sharedPreferences.getInt("destroy", 0));
    }
}
