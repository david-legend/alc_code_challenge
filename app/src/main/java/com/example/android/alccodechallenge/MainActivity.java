package com.example.android.alccodechallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_about_alc, btn_check_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_about_alc = findViewById(R.id.btn_about_alc);
        btn_check_profile = findViewById(R.id.checkProfile);

        btn_about_alc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alc_website = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(alc_website);
            }
        });

        btn_check_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myProfile = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(myProfile);
            }
        });
    }
}
