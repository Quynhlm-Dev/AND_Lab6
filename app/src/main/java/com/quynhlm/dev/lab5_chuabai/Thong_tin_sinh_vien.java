package com.quynhlm.dev.lab5_chuabai;

public class Thong_tin_sinh_vien {

    private String title;
    private String name;
    private String diaChi;


    public Thong_tin_sinh_vien(String name, String diaChi, String title) {
        this.name = name;
        this.diaChi = diaChi;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
