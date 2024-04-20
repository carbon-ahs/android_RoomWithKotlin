package com.axiagroups.roomwithkotlin.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.axiagroups.roomwithkotlin.model.Contacts

@Dao
interface ContactDao {
    @Query("Select * from Contacts")
    fun getAllContacts() : LiveData<List<Contacts>>

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun insertContact(contact : Contacts)

    @Delete
    fun delete(contact: Contacts)
}
