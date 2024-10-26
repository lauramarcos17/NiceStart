package com.lmarcos.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ImageView mgirl=findViewById(R.id.chica);
        Glide.with(this)
                .load("https://images.unsplash.com/photo-1727210348417-bf83db804168?q=80&w=1912&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                .centerCrop()
                .into(mgirl);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //el click del boton
    public void openSignup(View v)
    {
        //CLASE QUE PERMITE ABRIR ACTIVITYS
        Intent intent=new Intent(Login.this, Signup.class);
        startActivity(intent);
    }


    public void openMain(View view) {
        Intent intent=new Intent(Login.this, Main.class);
        startActivity(intent);
    }
}