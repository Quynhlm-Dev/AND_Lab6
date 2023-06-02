package com.quynhlm.dev.lab5_chuabai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity_lab5_bai2 extends AppCompatActivity {

    ListView list_view_item;
    ArrayList<Thong_tin_sinh_vien> list;

    String sua_name;
    String sua_dia_chi;
    String sua_title;

    private static final int REQUEST_ADD_PRODUCT = 1;
    private static final int REQUEST_CODE_EDIT = 2;
    Sinh_Vien_Adapter sinh_vien_adapter;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ADD_PRODUCT && resultCode == RESULT_OK) {
            String user_name = data.getStringExtra(Activity_lab5_bai1.KEY_USER_NAME);
            String dia_chi = data.getStringExtra(Activity_lab5_bai1.KEY_DIA_CHI);
            String title = data.getStringExtra(Activity_lab5_bai1.KEY_TITLE);

            Thong_tin_sinh_vien newProduct = new Thong_tin_sinh_vien(user_name, dia_chi, title);
            list.add(newProduct);
            sinh_vien_adapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_addsudent) {
            Intent intent = new Intent(Activity_lab5_bai2.this, Activity_lab5_bai1.class);
            startActivityForResult(intent, REQUEST_ADD_PRODUCT);
            return true;
        } else if (item.getItemId() == R.id.menu_diemDanh) {
            return true;
        } else if (item.getItemId() == R.id.menu_DangXuat) {

            startActivity(new Intent(Activity_lab5_bai2.this, Activity_dang_nhap.class));
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5_bai2);
        list_view_item = findViewById(R.id.list_view_item);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setLogo(R.drawable.dehaze);
        getSupportActionBar().setTitle("   "+"Home");


        Intent intent = this.getIntent();
        String user_name = intent.getStringExtra(Activity_lab5_bai1.KEY_USER_NAME);
        String dia_chi = intent.getStringExtra(Activity_lab5_bai1.KEY_DIA_CHI);
        String title = intent.getStringExtra(Activity_lab5_bai1.KEY_TITLE);
        list = new ArrayList<>();
        list.add(new Thong_tin_sinh_vien("Quynh", "vinh phuc", "Fpoly ha noi"));
        list.add(new Thong_tin_sinh_vien("Chinh", "Nam Dinh", "Fpoly ha noi"));
        list.add(new Thong_tin_sinh_vien("Minh", "vinh phuc", "Fpoly ha noi"));
        list.add(new Thong_tin_sinh_vien("Hieu", "ba vi", "Fpoly Tay Nguyen"));

        sinh_vien_adapter = new Sinh_Vien_Adapter(this, list);
        list_view_item.setAdapter(sinh_vien_adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }


    public class Sinh_Vien_Adapter extends BaseAdapter {

        private Context ctx;
        private ArrayList<Thong_tin_sinh_vien> list;


        public Sinh_Vien_Adapter(Context ctx, ArrayList<Thong_tin_sinh_vien> list) {
            this.ctx = ctx;
            this.list = list;
        }

        public Context getCtx() {
            return ctx;
        }

        public void setCtx(Context ctx) {
            this.ctx = ctx;
        }

        public ArrayList<Thong_tin_sinh_vien> getList() {
            return list;
        }

        public void setList(ArrayList<Thong_tin_sinh_vien> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = ((Activity) ctx).getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_list_view, parent, false);

            Thong_tin_sinh_vien thongTin = list.get(position);
            TextView txt_title = convertView.findViewById(R.id.txttitle);
            TextView txtusername = convertView.findViewById(R.id.txt_username);
            TextView txtDiaChi = convertView.findViewById(R.id.txt_diachi);
            Button btnDelete = convertView.findViewById(R.id.btnDelete);
            Button btnUpdate = convertView.findViewById(R.id.btnUpdate);

            if (thongTin != null) {
                txt_title.setText(thongTin.getTitle());
                txtusername.setText(thongTin.getName());
                txtDiaChi.setText(thongTin.getDiaChi());
            }
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = list_view_item.getPositionForView(v);
                    if (position != ListView.INVALID_POSITION) {
                        list.remove(position);
                        sinh_vien_adapter.notifyDataSetChanged();
                        Toast.makeText(Activity_lab5_bai2.this, "Đã xóa thành công", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Activity_lab5_bai2.this, "Danh sách trống", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            return convertView;
        }
    }
}