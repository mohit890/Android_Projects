package com.example.readwriteinternalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    Button btnRead, btnWrite;
    EditText edtRead, edtWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtRead = findViewById(R.id.edtRead);
        edtWrite = findViewById(R.id.edtWrite);
        btnRead = findViewById(R.id.btnRead);
        btnWrite = findViewById(R.id.btnWrite);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try {
                    FileOutputStream fout = openFileOutput("data1.txt", MODE_PRIVATE);

                    String str = edtWrite.getText().toString();

                    byte[] arr = str.getBytes();

                    fout.write(arr);
                    fout.close();

                    Toast.makeText(MainActivity.this, "DATA SAVED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
                    }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try {
                    FileInputStream fin = openFileInput("data1.txt");

                    String str = "";
                    int x = 0;

                    while ((x = fin.read()) != -1)
                    {
                        str = str + (char)x;
                    }
                    edtRead.setText(str);

                    edtRead.setEnabled(false);

                    Toast.makeText(MainActivity.this, "DATA READ FROM FILE", Toast.LENGTH_SHORT).show();
                    }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }

            }
        });
    }
}