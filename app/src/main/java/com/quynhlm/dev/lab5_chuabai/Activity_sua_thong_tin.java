package com.quynhlm.dev.lab5_chuabai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Activity_sua_thong_tin extends AppCompatActivity {

    public static final String KEY_SUA_NAME = "sua_user_name";
    public static final String KEY_SUA_DIA_CHI = "sua_dia_Chi";
    public static final String KEY_SUA_TITLE = "title";
    public static final int REQUEST_CODE_SUA_THONG_TIN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_thong_tin);

        Spinner spinner = findViewById(R.id.spiner_sua);
        TextInputEditText edt_sua_name = findViewById(R.id.edt_sua_UserName);
        TextInputEditText edt_sua_dia_chi = findViewById(R.id.edt_sua_DiaChi);
        Button btnSua = findViewById(R.id.btnSua);

        ArrayList<Thong_tin_co_so> list = new ArrayList<>();
        list.add(new Thong_tin_co_so("Fpoly Hà Nội", R.drawable.hanoi));
        list.add(new Thong_tin_co_so("Fpoly Hồ Chí Minh", R.drawable.ho_chi_minh));
        list.add(new Thong_tin_co_so("Fpoly Đà nẵng", R.drawable.danang));
        list.add(new Thong_tin_co_so("Fpoly Tây Nguyên", R.drawable.tay_nguyen));

        Co_so_Adapter co_so_adapter = new Co_so_Adapter(this, list);
        spinner.setAdapter(co_so_adapter);

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = edt_sua_name.getText().toString();
                String dia_Chi = edt_sua_dia_chi.getText().toString();

                Thong_tin_co_so thong_tin_co_so = (Thong_tin_co_so) spinner.getSelectedItem();
                String title = thong_tin_co_so.getName();
                Intent intent = new Intent();
                intent.putExtra(KEY_SUA_NAME, user_name);
                intent.putExtra(KEY_SUA_DIA_CHI, dia_Chi);
                intent.putExtra(KEY_SUA_TITLE, title);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}