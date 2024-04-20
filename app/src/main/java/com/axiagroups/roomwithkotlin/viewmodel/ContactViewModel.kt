package com.axiagroups.roomwithkotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.axiagroups.roomwithkotlin.database.ContactDatabase
import com.axiagroups.roomwithkotlin.database.repository.ContactRepository
import com.axiagroups.roomwithkotlin.model.Contacts

class ContactViewModel(application: Application) : AndroidViewModel(application) {
    val repository : ContactRepository
    init {
        val dao = ContactDatabase.getDatabaseInstance(application).contactsDao()
        repository = ContactRepository(dao)
    }
    fun addContacts(contact : Contacts){
        repository.insertContact(contact)
    }
    fun getAllContacts() : LiveData<List<Contacts>> = repository.getAllContacts()
}
