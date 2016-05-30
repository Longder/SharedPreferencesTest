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
        /**
         * 数据写入
         */
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //得到SharedPreferences.Editor对象，这个对象对应的文件名是"data"，Context.MODE_PRIVATE指定读写权限
                SharedPreferences.Editor editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit();
                /**
                 * 以下三行代码用来存储数据，editor提供putXXX方法以键值对的形式存数
                 */
                editor.putInt("age", 18);
                editor.putString("name", "大表哥");
                editor.putBoolean("married", false);
                //提交持久化
                editor.apply();
            }
        });
        /**
         * 数据读取
         */
        restoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取SharedPreferences对象，通过指定文件名"data"和读取模式Context.MODE_PRIVATE
                SharedPreferences sp = getSharedPreferences("data", Context.MODE_PRIVATE);
                /**
                 * 以下三行代码用来获取SharedPreferences中存储的数据，使用getXXX
                 * 第一个参数是key，后一个参数是默认值。当根据这个key找不到数据时返回。
                 */
                String name = sp.getString("name", "");
                int age = sp.getInt("age", 0);
                boolean married = sp.getBoolean("married", true);
                Toast.makeText(MainActivity.this, name + age + married, Toast.LENGTH_LONG).show();
            }
        });
    }
}
