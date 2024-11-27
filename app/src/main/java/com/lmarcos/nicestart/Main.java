package com.lmarcos.nicestart;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

import es.dmoral.toasty.Toasty;

public class Main extends AppCompatActivity {

    private SwipeRefreshLayout swipeLayout;
    private WebView miVisorWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView mycontext=findViewById(R.id.añadido);
        registerForContextMenu(mycontext);

        //para que cuando haga el refresh y luego en el mon le digo lo que quiero hacer

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);//llamo a lo del xml su contenedor
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        //añado esto para cargue una direccion con foto en la app que esta en la web
        miVisorWeb = (WebView) findViewById(R.id.vistaweb);
//        miVisorWeb.getSettings().setJavaScriptEnabled(true);
//        miVisorWeb.getSettings().setBuiltInZoomControls(true);
        WebSettings webSettings = miVisorWeb.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        miVisorWeb.loadUrl("https://thispersondoesnotexist.com");




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void showAlertDialogButtonClicked(Main mainActivity) {

        // setup the alert builder
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

//        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
        builder.setTitle("Achtung!");//el titulo
        builder.setMessage("Where do you go?"); //mensaje que me muestra
        builder.setIcon(R.drawable.ic_launcher_foreground);//ic_launcher es un icono que ya tengo creado
        builder.setCancelable(true);


        //boton de la derecha
        builder.setPositiveButton("Scrolling", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Toasty.info(mainActivity, "He pulsado el de la derecha", Toast.LENGTH_SHORT, true).show();
                dialog.dismiss();

            }
        });
        //el del medio
        builder.setNegativeButton("Do nothing", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...

                dialog.dismiss();
            }
        });

        //boton de la izquierda
        builder.setNeutralButton("Other", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...
                System.exit(0);

                dialog.dismiss();
            }
        });

        // create and show the alert dialog

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    //implemento monfrshlistener
    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            final ConstraintLayout mLayout=findViewById(R.id.main); //
            Snackbar snackbar=Snackbar.make(mLayout, "fancy a Sanck whhile ",Snackbar.LENGTH_SHORT).setAction("UNDO", new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    Snackbar snackbar1=Snackbar.make(mLayout,"Action is restored",Snackbar.LENGTH_SHORT);
                    snackbar1.show();
                }

            });
            snackbar.show();
            miVisorWeb.reload();// carga otra vez en bucle
            swipeLayout.setRefreshing(false);


        }
    };


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
            Toasty.info(this, "Infecting", Toast.LENGTH_SHORT, true).show();
        }
        if(id==R.id.item2)
        {
            Toasty.info(this, "Fixing", Toast.LENGTH_SHORT, true).show();
            Intent intent=new Intent(this, Profile.class);
            startActivity(intent);

        }
        if(id==R.id.item3){
            showAlertDialogButtonClicked(Main.this);
        }
            return super.onOptionsItemSelected(item);
    }
}