


package com.example.menu.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menu.R;
import com.example.menu.database.Account;
import com.example.menu.database.AccountDataBase;
import com.example.menu.database.CartDataBase;
import com.example.menu.database.CartMeal;
import com.example.menu.menurestaurante.FragmentDrinks;
import com.example.menu.menurestaurante.FragmentMealsType;
import com.example.menu.menurestaurante.FragmentShoping;
import com.example.menu.menurestaurante.ItemTab;
import com.example.menu.menurestaurante.MainTab;
import com.example.menu.menurestaurante.Meals;
import com.example.menu.menurestaurante.PagerAdapter;
import com.example.menu.menurestaurante.ShopingMeals;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements FragmentMealsType.onFragmentClickListener{
    //RecyclerView menu_recycler;
    TabLayout tab_res;
    ViewPager viewPager;
    FragmentMealsType fragmentMealsType = new FragmentMealsType();
    FragmentDrinks fragmentDrinks=new FragmentDrinks();
    FragmentShoping fragmentShoping = new FragmentShoping();
    PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
    ItemTab itemTab;
    MainTab mainTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab_res=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.main_viewpager);
        viewPager.setRotationY(180);
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

    //هان صارت المشكلة
    CartDataBase db;
    @Override
    public void onFragmentInteraction(Meals meals) {

        db = new CartDataBase(this);
        CartMeal cartMeal= new CartMeal(meals.getName_Meal(),2,meals.getPrice(),meals.getImg_meal());
        boolean res = db.insertAccount(cartMeal);
//        Toast.makeText(getBaseContext(),meals.getName_Meal(),Toast.LENGTH_LONG).show();
//        Log.i("name",meals.getName_Meal());
//        Log.i("namemeal",meals.getName_Meal());
//        Bundle bundle = new Bundle();
//        bundle.putString("name",meals.getName_Meal());
//        bundle.putInt("count",2);
//        bundle.putDouble("price",meals.getPrice());
//        bundle.putInt("img",meals.getImg_meal());
//        Toast.makeText(getBaseContext(),meals.getName_Meal(),Toast.LENGTH_LONG).show();
//        FragmentShoping fragmentShoping =new FragmentShoping();
//        fragmentShoping.setArguments(bundle);
//        FragmentShoping fragmentShoping =  FragmentShoping.newInstance(meals.getName_Meal());
//        FragmentManager fm=getSupportFragmentManager();
//        //getFragmentManager().findFragmentByTag(getString(R.string.main_tabitem_buy));
//        FragmentTransaction ft =fm.beginTransaction();
//        TabLayout.Tab tab = null;
//        ft.replace(tab.getTabLabelVisibility(),fragmentShoping);
//        ft.addToBackStack(null);
//
//        ft.commit();
    }
}