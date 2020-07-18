package com.example.relayapplication.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ApplicationViewModel : ViewModel() {

        private val _text = MutableLiveData<String>().apply {
            value = "This is home Fragment"
        }
        val text: LiveData<String> = _text
}