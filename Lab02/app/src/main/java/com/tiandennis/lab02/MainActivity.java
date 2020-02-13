package com.tiandennis.lab02;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button submitButton, colorButton;
    EditText responseText;
    TextView displayText, arrayText;
    String[] array;
    long number = 1;
    int index = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton=findViewById(R.id.submitButton);
        colorButton=findViewById(R.id.colorButton);
        responseText=findViewById(R.id.responseEditText);
        displayText=findViewById(R.id.textBox);
        arrayText=findViewById(R.id.arrayBox);
        array=getResources().getStringArray(R.array.array);
        displayText.setText(displayText.getText()+" Number: " + number + ". ");
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Println");
                Log.i("submitButton","Logcat: "+responseText.getText().toString());
                String old = displayText.getText().toString();
                if(old.contains("!"))
                    displayText.setText(old.split(", ")[0] + ", " + responseText.getText()+"!");
                else
                    displayText.setText(displayText.getText() + "Thanks for using this quiz app, " + responseText.getText()+"!");
            }
        });
        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Changing color!");
                Log.i("colorButton","Logcat: ");
                int color = 0xFF000000;
                submitButton.setBackgroundColor(color | (int)(Math.random() * (0xFFFFFF + 2)));
                String[] old1 = displayText.getText().toString().split(": ");
                number *= 2;
                if (number == 0)
                    number = 1;
                displayText.setText(old1[0] + ": " + number + "." + old1[1].split("\\.")[1]);
                arrayText.setText(array[index]);
                index++;
                if(index == array.length)
                    index = 0;
            }
        });
        responseText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(responseText.getText().toString().equals("TJ")){
                        displayText.setText("TJ Rocks!");
                        responseText.setText("");
                        responseText.setHint("That's a good name.");
                    }
                }
            }
        });
    }
}