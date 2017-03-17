package com.example.fortuneball;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String fortuneList[] = {"Don't count on it","Ask again later","You may rely on it",
    "Without a doubt", "Outlook not so good", "It's decidedly so","Signs point to yes",
    "Yes definitely yes","Yes","My sources say NO"};

    TextView mFortuneText;
    Button mGenerateFortuneButton;
    ImageView mFortuneBallImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //set up layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //create relations between variables and data
        mFortuneText = (TextView) findViewById(R.id.fortuneText);
        mFortuneBallImage = (ImageView) findViewById(R.id.fortunateImage);
        mGenerateFortuneButton = (Button) findViewById(R.id.fortuneButton);

        //button code
        mGenerateFortuneButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                int index = new Random().nextInt(fortuneList.length);
                mFortuneText.setText(fortuneList[index]);
                YoYo.with(Techniques.Swing)
                        .duration(500)
                        .playOn(mFortuneBallImage);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
