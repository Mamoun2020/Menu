package com.example.menu.menurestaurante;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.menu.R;
import com.example.menu.database.AccountDataBase;
import com.example.menu.database.CartDataBase;
import com.example.menu.database.CartMeal;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Objects;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;


public class
FragmentShoping extends Fragment {


    public FragmentShoping() {
        // Required empty public constructor
    }
    AccountDataBase db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        db = new AccountDataBase(getActivity());
        View v =inflater.inflate(R.layout.fragment_shoping, container, false);
        RecyclerView recycler=v.findViewById(R.id.main_recycler_shoping);
        recycler.setRotationY(180);
        String name="";
        int count = 0;
        double price=0;
        int img=0;
        ArrayList<CartMeal> list = db.getAllCarts();
        for(CartMeal cartMeal :list){
            name=cartMeal.getName_Meal();
            count=cartMeal.getCount();
            price=cartMeal.getPrice();
            img=cartMeal.getImg_meal();
        }
        ArrayList<ShopingMeals> shopingMeals = new ArrayList<>();
        shopingMeals.add(new ShopingMeals(name, count, price, img));
        AdapterShoping adapterShoping=new AdapterShoping(getActivity(),shopingMeals);
        recycler.setAdapter(adapterShoping);
//        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }
 }



