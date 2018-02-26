package com.easv.oe.intent01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    public static final String LOG_TAG = "LogIntent01";

    TextView txtHeader;
    EditText txtBox;
    Button btnNext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHeader = (TextView)findViewById(R.id.header);
        txtBox = (EditText)findViewById(R.id.EditText01);
        btnNext = (Button)findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MainActivity.this.onClickNext();

            }
        });
    }



    public void onClickNext()
    {
        BEPerson p = new BEPerson(txtBox.getText().toString(), "12345678", 180);
        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        intent.putExtra("Person", p);

        startActivity(intent);

        Log.d(LOG_TAG, "Second Activity started!");
        //<editor-fold desc="Delay the launcher...">
        /*
        for (int i=0; i < 10; i++)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(LOG_TAG, "Waiting...");
        }
        */
        //</editor-fold>

        Log.d(LOG_TAG, "onClickNext finished");
    }
}
