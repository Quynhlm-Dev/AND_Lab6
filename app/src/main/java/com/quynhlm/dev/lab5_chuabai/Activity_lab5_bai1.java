package com.quynhlm.dev.lab5_chuabai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_lab5_bai1 extends AppCompatActivity {

    public static String KEY_USER_NAME = "user_name";
    public static String KEY_DIA_CHI = "dia_chi";
    public static String KEY_TITLE = "title";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5_bai1);

        Spinner spinner = findViewById(R.id.spiner_title);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        EditText edt_name = findViewById(R.id.edtUserName);
        EditText edt_dia_Chi = findViewById(R.id.edtDiaChi);

        ArrayList<Thong_tin_co_so> list = new ArrayList<>();
        list.add(new Thong_tin_co_so("Fpoly Hà Nội", R.drawable.hanoi));
        list.add(new Thong_tin_co_so("Fpoly Hồ Chí Minh", R.drawable.ho_chi_minh));
        list.add(new Thong_tin_co_so("Fpoly Đà nẵng", R.drawable.danang));
        list.add(new Thong_tin_co_so("Fpoly Tây Nguyên", R.drawable.tay_nguyen));

        Co_so_Adapter co_so_adapter = new Co_so_Adapter(this, list);
        spinner.setAdapter(co_so_adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = edt_name.getText().toString();
                String dia_Chi = edt_dia_Chi.getText().toString();

                if(user_name.trim().isEmpty() && dia_Chi.trim().isEmpty()){
                    Toast.makeText(Activity_lab5_bai1.this, "Chua nhap thong tin !", Toast.LENGTH_SHORT).show();
                }else{
                    Thong_tin_co_so thong_tin_co_so = (Thong_tin_co_so) spinner.getSelectedItem();
                    String title = thong_tin_co_so.getName();
                    Intent intent = new Intent(Activity_lab5_bai1.this,Activity_lab5_bai2.class);
                    intent.putExtra(KEY_USER_NAME,user_name);
                    intent.putExtra(KEY_DIA_CHI,dia_Chi);
                    intent.putExtra(KEY_TITLE,title);
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });
    }
}