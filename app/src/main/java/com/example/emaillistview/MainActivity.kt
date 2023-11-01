package com.example.emaillistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items:ArrayList<Email> = arrayListOf(
            Email("Tester01", "This is a test email","Just test email.Enter something here"),
            Email("Tester02", "This is a test email","Just test email.Enter something here"),
            Email("Tester03", "This is a test email","Just test email.Enter something here"),
            Email("Tester04", "This is a test email","Just test email.Enter something here"),
            Email("Tester05", "This is a test email","Just test email.Enter something here"),
            Email("Tester06", "This is a test email","Just test email.Enter something here"),
            Email("Tester07", "This is a test email","Just test email.Enter something here"),
            Email("Tester08", "This is a test email","Just test email.Enter something here"),
            Email("Tester09", "This is a test email","Just test email.Enter something here"),
            Email("Tester10", "This is a test email","Just test email.Enter something here"),
        );
        val adapter = ListViewAdapter(this, items);
        val listVIew: ListView = findViewById(R.id.email_listview);
        listVIew.adapter = adapter;
    }
}