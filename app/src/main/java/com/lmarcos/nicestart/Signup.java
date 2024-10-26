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

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        ImageView mchico=findViewById(R.id.chica);
        Glide.with(this)
                .load("https://images.unsplash.com/photo-1729742201037-b4cbf9d6abc0?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
                .centerCrop()
                .into(mchico);







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void openLogin()
    {
        Intent intent=new Intent(Signup.this, Login.class);
        // PRIMERO SE PONE NOMBRE DE LA CLASE Y LUEGO LA QUE QUEREMOS ABRIR

        startActivity(intent);
    }

    public void openMain(View view) {
        Intent intento = new Intent(Signup.this, Main.class);
        startActivity(intento);
    }
}