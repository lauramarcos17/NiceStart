package com.lmarcos.nicestart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView mycontext=findViewById(R.id.añadido);
        registerForContextMenu(mycontext);






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //implemento context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuinfo)
    {
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
       int id=item.getItemId();
            if (id==R.id.item1) {
                final ConstraintLayout mLayout=findViewById(R.id.main);
                Snackbar snackbar=Snackbar
                        .make(mLayout,"fancy a Snack ",Snackbar.LENGTH_SHORT)
                        .setAction("UNDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar snackbar1=Snackbar.make(mLayout,"aCTION IS RESTORED",Snackbar.LENGTH_SHORT);
                                        snackbar1.show();
                            }
                        });
                snackbar.show();
               // Toast.makeText(this, "ITEM COPIADO", Toast.LENGTH_SHORT).show();
                return true;
            }
            else if( id==R.id.item2)
            {
                Toast.makeText(this, "DOWLOAD ITEM", Toast.LENGTH_SHORT).show();
                return true;
            }
           else
                return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_appbar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();//numero segun orden de creacion en xml
        if(id==R.id.item1)
        {
            Toast.makeText(this, "Infecting", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.item2)
        {
            Toast.makeText(this, "Fixing", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this, Profile.class);
            startActivity(intent);

        }
            return super.onOptionsItemSelected(item);
    }
}