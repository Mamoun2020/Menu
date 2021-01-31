


package com.example.menu.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.menu.R;
import com.example.menu.database.AccountDataBase;
import com.example.menu.database.CartDrink;
import com.example.menu.database.CartMeal;
import com.example.menu.menurestaurante.Drinks;
import com.example.menu.menurestaurante.FragmentDrinks;
import com.example.menu.menurestaurante.FragmentMealsType;
import com.example.menu.menurestaurante.FragmentShoping;
import com.example.menu.menurestaurante.ItemTab;
import com.example.menu.menurestaurante.MainTab;
import com.example.menu.menurestaurante.Meals;
import com.example.menu.menurestaurante.PagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements FragmentMealsType.onFragmentClickListener,FragmentDrinks.onFragmentClickListener{
    //RecyclerView menu_recycler;
    TabLayout tab_res;
    ViewPager viewPager;
    FragmentMealsType fragmentMealsType = new FragmentMealsType();
    FragmentDrinks fragmentDrinks=new FragmentDrinks();
    FragmentShoping fragmentShoping = new FragmentShoping();
    PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab_res=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.main_viewpager);
        viewPager.setRotationY(180);
        // to add fragment in tab layout item and connect it with view pager

        // add tab Meals name in tab layout and connect this tab with view pager to show fragment Meals type and so on
        pagerAdapter.addTap(new MainTab(new ItemTab(1,getString(R.string.main_tabitem_menu),R.drawable.ic_meal), fragmentMealsType));
        pagerAdapter.addTap(new MainTab(new ItemTab(2,getString(R.string.main_tabitem_drinks),R.drawable.ic_drinks),fragmentDrinks));
        pagerAdapter.addTap(new MainTab(new ItemTab(3,getString(R.string.main_tabitem_buy),R.drawable.ic_shoping_cart), fragmentShoping));
        viewPager.setAdapter(pagerAdapter);
        tab_res.setupWithViewPager(viewPager);
        tab_res.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    // if click back button in mobile ,show dialog to user if he want to leave the app
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.main_message_dialog)
                .setTitle(R.string.main_title_dialog)
                .setCancelable(false)
                .setPositiveButton(R.string.main_yes_dialog, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent a = new Intent(Intent.ACTION_MAIN);
                        a.addCategory(Intent.CATEGORY_HOME);
                        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(a);
                    }
                })
                .setNegativeButton(R.string.main_no_dialog, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }


    AccountDataBase db;
    // to sent data from meals fragment to DB when click on buy button
    @Override
    public void onFragmentInteraction(Meals meals) {
        db = new AccountDataBase(this);
            CartMeal cartMeal = new CartMeal(meals.getName_Meal(), meals.getCount(), meals.getPrice(), meals.getImg_meal());
            boolean res = db.insertMeal(cartMeal);

    }
    // to sent data from drink fragment to DB when click on buy button
    @Override
    public void onFragmentInteraction(Drinks drinks) {
        db = new AccountDataBase(this);
        CartDrink cartDrink = new CartDrink(drinks.getName_Drink(), drinks.getCount(),drinks.getPrice(), drinks.getImg_Drink());
        boolean res = db.insertDrink(cartDrink);
    }
}