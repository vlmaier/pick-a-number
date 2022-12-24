package com.vladas.pickanumber;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Typeface font = Typeface.createFromAsset(getAssets(), "ostrich-regular.ttf");
        Typeface fontBold = Typeface.createFromAsset(getAssets(), "ostrich-black.ttf");

        Button pick = (Button) findViewById(R.id.pick);
        pick.setTypeface(font);
        TextView header = (TextView) findViewById(R.id.header);
        header.setTypeface(font);
        TextView result = (TextView) findViewById(R.id.result);
        result.setTypeface(fontBold);
        EditText von = (EditText) findViewById(R.id.von);
        von.setTypeface(font);
        EditText bis = (EditText) findViewById(R.id.bis);
        bis.setTypeface(font);

        pick.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText von = (EditText) findViewById(R.id.von);
                EditText bis = (EditText) findViewById(R.id.bis);
                TextView header = (TextView) findViewById(R.id.header);
                TextView result = (TextView) findViewById(R.id.result);

                if(von.getText().length() == 0 || bis.getText().length() == 0) {
                    header.setText("Falsches Intervall!");
                    result.setText("");
                }
                else {
                    header.setText("Geben Sie das Intervall an");
                    int vonvalue = Integer.parseInt(von.getText().toString());
                    int bisvalue = Integer.parseInt(bis.getText().toString());

                    if(vonvalue > bisvalue) {
                        int tmp = vonvalue;
                        vonvalue = bisvalue;
                        bisvalue = tmp;
                    }

                    int random = (int) (Math.random() * ((bisvalue - vonvalue) + 1)) + vonvalue;

                    if(random > 9999)
                        result.setTextSize(100);
                    else
                        result.setTextSize(150);
                    result.setText("" + random);
                }
            }
        });
    }
}
