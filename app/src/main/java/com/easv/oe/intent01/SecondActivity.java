package com.easv.oe.intent01;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        Log.d(MainActivity.LOG_TAG, "SecondActivity Created");

        Bundle extras = getIntent().getExtras();
        BEPerson p = (BEPerson) extras.getSerializable("Person");
        if (p == null)
        {
            Log.d(MainActivity.LOG_TAG, "no person...");
            p = new BEPerson("NO NAME", "NO PHONE", 0);
        }

        String msg = p.getName() + " -- " + p.getPhone() + " -- " + p.getHeight() + "cm";
        Log.d(MainActivity.LOG_TAG, "Received person = " + msg);
        TextView header = (TextView)findViewById(R.id.tvInfo);

        header.setText(msg);
    }

    @Override protected void onPause()
    {   super.onPause();
        Log.d(MainActivity.LOG_TAG, "Second Activity paused");
    }
}
