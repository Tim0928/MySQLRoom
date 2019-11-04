package com.avc.app.mysqlroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")//把table name修改
public class User {
    @PrimaryKey//鑰匙
    private int id;
    @ColumnInfo(name="user_name")//欄位資訊 設定名子為user_name
    private String name;
    @ColumnInfo(name = "user_email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
