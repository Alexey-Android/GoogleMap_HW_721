package com.example.googlemap_hw_721;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {

        Button button_search = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.editText);

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                final String place = editText.getText().toString();
                boolean flag = false;
                char[] chars = place.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    if (Character.isLetter(chars[i])) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    intent.setData(Uri.parse("geo:?q=" + place));
                } else {
                    intent.setData(Uri.parse("geo:" + place));
                }
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}