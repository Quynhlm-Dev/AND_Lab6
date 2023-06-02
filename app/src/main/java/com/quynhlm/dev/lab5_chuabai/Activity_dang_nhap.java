package com.quynhlm.dev.lab5_chuabai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_dang_nhap extends AppCompatActivity {

    public static String KEY_TAIKHOAN = "admin";
    public static String KEY_MATKHAU = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        EditText user_name = findViewById(R.id.edtname_dangNhap);
        EditText pass_word = findViewById(R.id.edtpass_dangnhap);
        Button btnDangNhap = findViewById(R.id.btndangNhap);
        TextView txtDangKy = findViewById(R.id.txtDangKy);

        Intent intent = this.getIntent();
        String name = intent.getStringExtra(Activity_dang_ky.KEY_USERNAME);
        String pass = intent.getStringExtra(Activity_dang_ky.KEY_PASSWORD);

        user_name.setText(name);
        pass_word.setText(pass);


        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user_name.getText().toString();
                String password = pass_word.getText().toString();

                if (username.equals(KEY_TAIKHOAN) && password.equals(KEY_MATKHAU)) {
                    Toast.makeText(Activity_dang_nhap.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Activity_dang_nhap.this, Activity_lab5_bai2.class));
                } else if (username.trim().isEmpty() && password.trim().isEmpty()) {
                    Toast.makeText(Activity_dang_nhap.this, "Chua nhap du thong tin", Toast.LENGTH_SHORT).show();
                } else if (!username.equals(name)) {
                    Toast.makeText(Activity_dang_nhap.this, "Sai tai khoan", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(pass)) {
                    Toast.makeText(Activity_dang_nhap.this, "Sai mat khau", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Activity_dang_nhap.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Activity_dang_nhap.this, Activity_lab5_bai2.class));
                }
            }
        });
        txtDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_dang_nhap.this, Activity_dang_ky.class));
            }
        });
    }
}