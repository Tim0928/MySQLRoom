package com.avc.app.mysqlroom;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MyDao {
    @Insert//這個＠代表它會幫我做insert
    public void addUser(User user);
    @Query("select * from users")
    public List<User>getuser();//撰寫getuser
    @Delete
    public void deleteUser(User user);
    @Update
    public void updateUser(User user);
}
