package com.example.project;

import java.io.Serializable;

public class tempStoreData implements Serializable {
    static int store_calorie;
    static int store_filter1;
    static int store_filter2;
    static int store_pick;
    static int store_price;
    static int store_score;
    static double store_latitude;
    static double store_longitude;

    static String store_recommand;
    static String store_name;
    static String store_img;

    public int getStore_calorie() {
        return store_calorie;
    }

    public void setStore_calorie(int store_calorie) {
        this.store_calorie = store_calorie;
    }

    public int getStore_filter1() {
        return store_filter1;
    }

    public void setStore_filter1(int store_filter1) {
        this.store_filter1 = store_filter1;
    }

    public int getStore_filter2() {
        return store_filter2;
    }

    public void setStore_filter2(int store_filter2) {
        this.store_filter2 = store_filter2;
    }

    public int getStore_pick() {
        return store_pick;
    }

    public void setStore_pick(int store_pick) {
        this.store_pick = store_pick;
    }

    public int getStore_price() {
        return store_price;
    }

    public void setStore_price(int store_price) {
        this.store_price = store_price;
    }

    public int getStore_score() {
        return store_score;
    }

    public void setStore_score(int store_score) {
        this.store_score = store_score;
    }

    public double getStore_latitude() {
        return store_latitude;
    }

    public void setStore_latitude(double store_latitude) {
        this.store_latitude = store_latitude;
    }

    public double getStore_longitude() {
        return store_longitude;
    }

    public void setStore_longitude(double store_longitude) {
        this.store_longitude = store_longitude;
    }

    public String getStore_recommand() {
        return store_recommand;
    }

    public void setStore_recommand(String store_recommand) {
        this.store_recommand = store_recommand;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_img() {
        return store_img;
    }

    public void setStore_img(String store_img) {
        this.store_img = store_img;
    }
}

