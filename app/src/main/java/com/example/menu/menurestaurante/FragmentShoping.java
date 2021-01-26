package com.example.menu.menurestaurante;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menu.R;
import com.example.menu.database.AccountDataBase;
import com.example.menu.database.CartDrink;
import com.example.menu.database.CartMeal;

import java.util.ArrayList;


public class
FragmentShoping extends Fragment {

    String name_meal="";
    int count_meal = 0;
    double price_meal=0;
    int img_meal=0;
    String name_drinks="";
    int count_drinks= 0;
    double price_drinks=0;
    int img_drinks=0;
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
        ArrayList<ShopingMeals> shopingMeals = new ArrayList<>();

        ArrayList<CartMeal> list = db.getAllCarts();
        // get all data from meals table when buy it from meals fragment
        for(CartMeal cartMeal :list){
            name_meal=cartMeal.getName_Meal();
            count_meal=cartMeal.getCount();
            price_meal=cartMeal.getPrice();
            img_meal=cartMeal.getImg_meal();
            if(list!=null)
                shopingMeals.add(new ShopingMeals(name_meal, count_meal, price_meal, img_meal));
        }
        ArrayList<CartDrink> list_drink=db.getAllDrink();
        // get all data from drinks table when buy it from drinks fragment
        for(CartDrink cartDrink : list_drink){
            name_drinks=cartDrink.getName_Drink();
            count_drinks=cartDrink.getCount();
            price_drinks=cartDrink.getPrice();
            img_drinks=cartDrink.getImg_Drink();
            if(list_drink!=null)
                //add it in shopping meal array list to show it in shopping tab
                shopingMeals.add(new ShopingMeals(name_drinks, count_drinks, price_drinks, img_drinks));
        }

        AdapterShoping adapterShoping=new AdapterShoping(getActivity(),shopingMeals);
        recycler.setAdapter(adapterShoping);
//        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }
 }



