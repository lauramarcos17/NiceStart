package com.lmarcos.nicestart;

import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
public class MainBab extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bab);



        // cast al xml
        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar);
        FloatingActionButton myfab = findViewById(R.id.fab);

        //click event en el  FAB  morado
        myfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainBab.this, "FAB Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        //click en el mas de izquierda
        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainBab.this, "Menu clicked", Toast.LENGTH_SHORT).show();
//                sheetBehavior = BottomSheetBehavior.from(sheet);
                showBottomSheetDialog();
            }


        });

        //click event en el Bottom bar menu item
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.heart) {
                    Toast.makeText(MainBab.this, "Added to favourites", Toast.LENGTH_SHORT).show();
                 }
                else{
                    Toast.makeText(MainBab.this, "Beginning search", Toast.LENGTH_SHORT).show();

                }

                return false;
            }
        });


    }
    private void showBottomSheetDialog() {
        // Inflar el diseño del BottomSheet
        View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_layout, null);

        // Crear el BottomSheetDialog
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();

        // Configurar listeners para las opciones del BottomSheet
        TextView option1 = view.findViewById(R.id.option1);
        TextView option2 = view.findViewById(R.id.option2);
        TextView option3 = view.findViewById(R.id.option3);

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción para Opción 1
                Toast.makeText(MainBab.this, "Settings clicked", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }


        });
    }
}
