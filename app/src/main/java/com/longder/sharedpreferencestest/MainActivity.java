package com.longder.sharedpreferencestest;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button saveButton;
    private Button restoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveButton = (Button) findViewById(R.id.save_data);
        restoreButton = (Button) findViewById(R.id.restore_data);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit();
                editor.putInt("age", 18);
                editor.putString("name", "大表哥");
                editor.putBoolean("married", false);
                editor.commit();
            }
        });
        restoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("data", Context.MODE_PRIVATE);
                String name = sp.getString("name", "");
                int age = sp.getInt("age", 0);
                boolean married = sp.getBoolean("married", true);
                Toast.makeText(MainActivity.this, name + age + married, Toast.LENGTH_LONG).show();
            }
        });
    }
}
