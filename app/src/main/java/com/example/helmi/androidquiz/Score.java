package com.example.helmi.androidquiz;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends Activity {

    TextView rs;
    Button   rp;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);

        rs =(TextView) findViewById(R.id.score);
        rs.setText("Your Score is: "+Quiz.score);
        rp =(Button) findViewById(R.id.replay);

        rp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz.score=0;
                Intent in = new Intent(getApplicationContext(),Quiz.class);
                startActivity(in);
                finish();

            }
        });

    }


}
