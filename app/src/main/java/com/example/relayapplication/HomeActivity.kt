package com.example.relayapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*

enum class ProviderType {
    BASIC
}

class HomeActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //SETUP
        val bunlde = intent.extras
        val email = bunlde?.getString("email")
        val provider = bunlde?.getString("provider")
        setup(email ?:"", provider ?:"")
    }

    private fun setup(email: String, provider: String){

        title = "first" //始まり
        emailTextView.text = email
        providerTextView.text = provider

        logoutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
    }
}




