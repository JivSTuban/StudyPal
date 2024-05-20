package com.example.studypal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    Intent intent;
    public static final String number="Value";
    public static final String LastIndex="Index";
    public static  final String myPref="pref";
    public static final String Day="day";

    SharedPreferences Preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        intent=new Intent(Home.this,Clock.class);
        Preferences=getSharedPreferences(myPref,MODE_PRIVATE);

        TextView Slider=findViewById(R.id.textslide);
        TextView today=findViewById(R.id.today);

        today.setText(Utils.getInstance().getData());


        int i=Preferences.getInt(LastIndex,-1);
        if(i==-1)
        {
            // first time when you open app
            SharedPreferences.Editor editor;
            editor = Preferences.edit();
            editor.putInt(LastIndex,0);
            editor.putString(Day,Utils.getInstance().getData());

            today.setText(Utils.getInstance().getData());
            editor.commit();
        }
        else{

            if(i==Utils.getInstance().getQuotes().size())
                i=0;

            Slider.setText(Utils.getInstance().getQuotes().get(i));
            i++;
            SharedPreferences.Editor editor=Preferences.edit();
            editor.putInt(LastIndex,i);
            editor.commit();
        }




    }


    // on click button
    public void TewntyFive(View view)
    {
       intent.putExtra(number,25);
       startActivity(intent);
    }
    public void ThrityFive(View view)
    {
        intent.putExtra(number,35);
        startActivity(intent);

    }
    public void Hour(View view)
    {
       intent.putExtra(number,60);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
        System.exit(0);
    }
}