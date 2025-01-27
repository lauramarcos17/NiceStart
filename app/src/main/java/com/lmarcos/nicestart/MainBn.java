package com.lmarcos.nicestart;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lmarcos.nicestart.ui.main.SectionsPagerAdapter;

public class MainBn extends AppCompatActivity {
    private SectionsPagerAdapter sectionsPagerAdapter;
    private MenuItem prevMenuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_bn);


        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
//        ViewPager viewPager = binding.viewPager;
        ViewPager viewPager1 = findViewById(R.id.view_pager);
        viewPager1.setAdapter(sectionsPagerAdapter);





//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        BottomNavigationView mybottomNavView = findViewById(R.id.bottom_navigation);





        mybottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                    if( item.getItemId()==R.id.heart) {
                        item.setChecked(true);
                        Toast.makeText(MainBn.this, "Likes clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(mybottomNavView, item.getItemId());
                        viewPager1.setCurrentItem(0);
                        return true;
                    }

                    if(item.getItemId()== R.id.search) {
                        item.setChecked(true);
                        Toast.makeText(MainBn.this, "Add clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(mybottomNavView, item.getItemId());
                        viewPager1.setCurrentItem(1);
                        return true;
                    }

                    if( item.getItemId()==R.id.heart2) {
                        item.setChecked(true);
                        Toast.makeText(MainBn.this, "Browse clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(mybottomNavView, item.getItemId());
                        viewPager1.setCurrentItem(2);
                        return true;
                    }

                    if( item.getItemId()== R.id.search2) {
                        item.setChecked(true);
                        Toast.makeText(MainBn.this, "Personal clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(mybottomNavView, item.getItemId());
                        viewPager1.setCurrentItem(3);
                        return true;
                    }

                return false;
            }
        });


//        here we listen to viewpager moves and set navigations items checked or not

        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    mybottomNavView.getMenu().getItem(0).setChecked(false);
                    mybottomNavView.getMenu().getItem(position).setChecked(true);
                    removeBadge(mybottomNavView, mybottomNavView.getMenu().getItem(position).getItemId());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    /**
     * Remove badge.
     *
     * @param bottomNavigationView the bottom navigation view
     * @param itemId               the item id
     */
//removing badges
    public static void removeBadge(BottomNavigationView bottomNavigationView, @IdRes int itemId) {
        @SuppressLint("RestrictedApi") BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);
        if (itemView.getChildCount() == 3) {
            itemView.removeViewAt(2);
        }
    }

    }
