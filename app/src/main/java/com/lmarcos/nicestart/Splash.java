package com.lmarcos.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        oppenap();

        ImageView thunder=findViewById(R.id.animacion);
        //aqui creo objeto animacion descrita en xml llamada blink
        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.blink);

        //con este metodo startanimation lo aplicamos al imagenview del logo
        thunder.startAnimation(myanim);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void oppenap()
    {
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//abre el login
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);//hace desaparecer el splash
                startActivity(intent);
            }
        },5000);//el tiempo hace desde que pone splash y luego login
    }
}