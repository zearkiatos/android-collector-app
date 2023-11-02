package com.collector.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.collector.app.brokers.RetrofitBroker
import com.google.android.material.textfield.TextInputEditText

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotrofit)

        val getButton: Button = findViewById(R.id.fetch_button_retrofit)
        val getResultTextView : TextView = findViewById(R.id.get_result_text_retrofit)
        getButton.setOnClickListener {
            RetrofitBroker.getRequest(onResponse = {
                getResultTextView.text = it
            }, onFailure = {
                getResultTextView.text = it
            })
        }

        val postButton: Button = findViewById(R.id.post_button_retrofit)
        val postResultTextView : TextView = findViewById(R.id.post_result_text_retrofit)
        postButton.setOnClickListener {
            val mailTxt : TextInputEditText = findViewById(R.id.txt_post_mail_retrofit)
            val nameTxt : TextInputEditText = findViewById(R.id.txt_post_name_retrofit)
            val phoneTxt : TextInputEditText = findViewById(R.id.txt_post_phone_retrofit)
            val postParams = mapOf<String, String>(
                "name" to nameTxt.text.toString(),
                "telephone" to phoneTxt.text.toString(),
                "email" to mailTxt.text.toString()
            )
            RetrofitBroker.postRequest(postParams,
                onResponse = {
                    postResultTextView.text = it
                }, onFailure = {
                    postResultTextView.text = it
                })
        }
    }
}