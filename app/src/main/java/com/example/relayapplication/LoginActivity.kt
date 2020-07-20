package com.example.relayapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.emailEditText
import kotlinx.android.synthetic.main.activity_main.passwordEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //SetUp
        setup()
    }

private fun setup() {
    title = "Login" //titlebar
    loginButton.setOnClickListener {
        if (emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()) {

            FirebaseAuth.getInstance().signInWithEmailAndPassword(
                emailEditText.text.toString(),
                passwordEditText.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    showHome(it.result?.user?.email ?:"", ProviderType.BASIC)
                } else {
                    showAlert()
                }
            }
        }
    }
    main_have_textView.setOnClickListener {
        onBackPressed()
    }
}

    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("エラー")
        builder.setMessage("エラーが発生しました")
        builder.setPositiveButton("わかりました", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String, provider: ProviderType){
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email",email)
            putExtra("provider",provider.name)
        }
        startActivity(homeIntent)
    }
}
