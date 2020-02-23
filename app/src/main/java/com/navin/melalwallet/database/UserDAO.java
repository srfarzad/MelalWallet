package com.navin.melalwallet.database;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.navin.melalwallet.models.Basket;
import com.navin.melalwallet.models.User;

import java.util.List;

@Dao
public interface UserDAO {


    @Insert
    public void insert(User... users);

    @Delete
    void delete(User user);


    @Query("SELECT * FROM user")
    List<User> getAll();


    @Insert
    public void insertToBasket(Basket... basket);

    @Query("SELECT * FROM basket")
    List<Basket> getAllBasket();

    @Delete
    void deleteItemBasket(Basket basket);


}
