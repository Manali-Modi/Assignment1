package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Screen3 extends AppCompatActivity {

    Button btntop, btncenter, btnbottom;
    TextView txtl1, txtl2, txtr1, txtr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        getSupportActionBar().hide();

        MemoryAllocation();

        SetEvents();
    }

    private void SetEvents() {
        btntop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               txtl2.setVisibility(View.INVISIBLE);
               txtr2.setVisibility(View.INVISIBLE);
            }
        });

        btncenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtl1.setVisibility(View.VISIBLE);
                txtl2.setVisibility(View.VISIBLE);
                txtr1.setVisibility(View.VISIBLE);
                txtr2.setVisibility(View.VISIBLE);
            }
        });

        btnbottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtl1.setVisibility(View.INVISIBLE);
                txtr1.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void MemoryAllocation() {
        btntop = findViewById(R.id.btntop);
        btncenter = findViewById(R.id.btncenter);
        btnbottom = findViewById(R.id.btnbottom);
        txtl1 = findViewById(R.id.txtl1);
        txtl2 = findViewById(R.id.txtl2);
        txtr1 = findViewById(R.id.txtr1);
        txtr2 = findViewById(R.id.txtr2);
    }
}