package com.quynhlm.dev.lab5_chuabai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_dang_ky extends AppCompatActivity {

    public static String KEY_USERNAME = "user_name";
    public static String KEY_PASSWORD = "pass_word";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        EditText user_name = findViewById(R.id.edtname_dangKy);
        EditText pass_word = findViewById(R.id.edtpass_dangKy);
        EditText nhap_lai = findViewById(R.id.edtnhaplai);
        Button btnSignup = findViewById(R.id.btndangSignup);
        TextView txtDangNhap = findViewById(R.id.txtDangNhap);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user_name.getText().toString();
                String passWord = pass_word.getText().toString();
                String nhaplai = nhap_lai.getText().toString();

                Intent intent = new Intent(Activity_dang_ky.this, Activity_dang_nhap.class);
                intent.putExtra(KEY_USERNAME,username);
                intent.putExtra(KEY_PASSWORD,passWord);
                startActivity(intent);
            }
        });
        txtDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_dang_ky.this,Activity_dang_nhap.class));
            }
        });

    }
}