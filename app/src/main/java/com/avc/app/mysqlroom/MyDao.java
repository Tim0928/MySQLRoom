package com.avc.app.mysqlroom;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface MyDao {
    @Insert
    public void addUser(User user);
    @Query("select * from users")
    public List<User>getuser();//撰寫getuser


}
