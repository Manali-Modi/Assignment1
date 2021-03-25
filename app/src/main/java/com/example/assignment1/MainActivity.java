package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    NumberPicker npage;
    EditText etname, etemail, etpwd, etcontact;
    Button btnnext;
    String name, email, pwd, contact;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        MemoryAllocation();

        SetEvent();
    }

    private void SetEvent() {
        npage.setMinValue(18);
        npage.setMaxValue(58);

        npage.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                Toast.makeText(getApplicationContext(),"Your age is "+numberPicker.getValue(),Toast.LENGTH_LONG).show();
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValidate()){
                    Toast.makeText(getApplicationContext(),"All is done",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this,Screen2.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean isValidate() {
        boolean isValid = true;
        name = etname.getText().toString();
        email = etemail.getText().toString();
        pwd = etpwd.getText().toString();
        contact = etcontact.getText().toString();

        if(name.length()==0){
            Toast.makeText(getApplicationContext(),"Please enter valid name",Toast.LENGTH_LONG).show();
            isValid = false;
        }
        if(email.length()==0 || !email.matches(emailPattern)){
            Toast.makeText(getApplicationContext(),"Please enter valid email address",Toast.LENGTH_LONG).show();
            isValid = false;
        }
        if(pwd.length()==0 || pwd.length()<6){
            Toast.makeText(getApplicationContext(),"Password atleast 6 characters long",Toast.LENGTH_LONG).show();
            isValid = false;
        }
        if(contact.length()==0 || contact.length()<10){
            Toast.makeText(getApplicationContext(),"Contact number should be 10 digit long",Toast.LENGTH_LONG).show();
            isValid = false;
        }
        return isValid;
    }

    private void MemoryAllocation() {
        etname = findViewById(R.id.etname);
        etemail = findViewById(R.id.etemail);
        etpwd = findViewById(R.id.etpwd);
        etcontact = findViewById(R.id.etcontct);
        npage = findViewById(R.id.npage);
        btnnext = findViewById(R.id.btnnext);
    }
}