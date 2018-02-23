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
    Button btnOK;
    Button btnNext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHeader = (TextView)findViewById(R.id.header);
        txtBox = (EditText)findViewById(R.id.EditText01);
        btnOK = (Button)findViewById(R.id.btnOK);
        btnNext = (Button)findViewById(R.id.btnNext);

        btnOK.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.onClickOK();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                MainActivity.this.onClickNext();

            }
        });
    }


    public void onClickOK()
    {
        txtHeader.setText("Hi " + txtBox.getText() + "... Have a nice day!");
        //btnOK.setClickable(false);

        Log.d(LOG_TAG, "OK button clicked");

    }

    public void onClickNext()
    {
        BEPerson p = new BEPerson(txtBox.getText().toString(), "12345678", 180);
        Intent intent = new Intent();
        intent.setClass(this, SecondActivity.class);
        intent.putExtra("Person", p);

        Log.d(LOG_TAG, "Next button clicked!");
        startActivity(intent);
        Log.d(LOG_TAG, "Second Activity started!");
        //<editor-fold desc="Delay the invoker...">
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


        txtHeader.setText("Next is clicked...;-)");
        Log.d(LOG_TAG, "onClickNext finished");


    }
}
