package com.jacksonhu.idiotcounter;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
{
    private SharedPreferences sharedPreferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load data from settings (Shared preferences)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Update GUI
        TextView textView = (TextView)findViewById(R.id.countTextView);
        Integer count = sharedPreferences.getInt("count_idiot", 0);
        textView.setText(String.format(Locale.ENGLISH, "%d", count));
    }

    public void addCounter(View view)
    {
        // Prepare shared preferences
        SharedPreferences.Editor preferenceEditor = sharedPreferences.edit();

        // Update GUI
        TextView textView = (TextView)findViewById(R.id.countTextView);
        Integer count = sharedPreferences.getInt("count_idiot", 0) + 1;
        textView.setText(String.format(Locale.ENGLISH, "%d", count));

        // Save to settings
        preferenceEditor.putInt("count_idiot", count);
        preferenceEditor.apply();
    }
}
