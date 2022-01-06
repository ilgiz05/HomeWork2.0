package com.example.homework20;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    EditText etTitle;
    Button btnAdd;
    TextView tvText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.image);
        etTitle = findViewById(R.id.et_title);
        btnAdd = findViewById(R.id.btn_add);
        tvText = findViewById(R.id.tv_text);


        tvText.setText("GEEKTECH");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                startActivity(intent2);

            }
        });
    }

    ActivityResultLauncher<String> resultLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    image.setImageURI(uri);


                }
            });


}

