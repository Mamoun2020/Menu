package com.example.menu.menurestaurante;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.menu.R;

import java.util.ArrayList;


public class FragmentMealsType extends Fragment {

    private onFragmentClickListener listener;
    public FragmentMealsType() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof onFragmentClickListener)
            listener= (onFragmentClickListener) context;
        else
            throw new ClassCastException("Your Activity does not implement OnFragmentClickListener");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_meals_type, container, false);
        RecyclerView recyclerView=v.findViewById(R.id.main_recycler_meals);
        // add meals object in array list to show it when click on meals tab to show fragment with the custom layout meals
        ArrayList<Meals> meals = new ArrayList<>();
        meals.add(new Meals(getString(R.string.Meals_Name1),getString(R.string.Meals_component1),10,R.drawable.burger_1,1));
        meals.add(new Meals(getString(R.string.Meals_Name2),getString(R.string.Meals_component2),15,R.drawable.shawarma_2,1));
        meals.add(new Meals(getString(R.string.Meals_Name3),getString(R.string.Meals_component3),20,R.drawable.pizza_3,1));
        meals.add(new Meals(getString(R.string.Meal_Name4),getString(R.string.Meals_component4),29,R.drawable.kebabs_4,1));
        meals.add(new Meals(getString(R.string.Meals_Name5),getString(R.string.Meals_component5),15,R.drawable.hotchicken_5,1));
        meals.add(new Meals(getString(R.string.Meals_Name6),getString(R.string.Meals_component6),25,R.drawable.crispypin_6,1));
        meals.add(new Meals(getString(R.string.Meals_Name7),getString(R.string.Meals_component7),15,R.drawable.iskandranliver_7,1));
        meals.add(new Meals(getString(R.string.Meals_Name8),getString(R.string.Meals_component8),12,R.drawable.thaisandwich_8,1));
        meals.add(new Meals(getString(R.string.Meals_Name9),getString(R.string.Meals_component9),14,R.drawable.currychicken_9,1));
        meals.add(new Meals(getString(R.string.Meals_Name10),getString(R.string.Meals_component10),13,R.drawable.sheeshtawouk_10,1));




        AdapterMeals adapterMeals = new AdapterMeals(meals, new OnItemClickListener() {
            @Override
            public void onItemClick(Meals meals) {
                // to sent data from fragment to main activity when click on buy button
                    listener.onFragmentInteraction(meals);
            }
        });
        recyclerView.setRotationY(180);
        recyclerView.setAdapter(adapterMeals);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return  v;
    }

    public interface onFragmentClickListener {
        void  onFragmentInteraction(Meals meals);
    }

//    private ArrayList<Meals> getMyitem() {
//        meals = new Meals();
//        meals.setName_Meal(getString(R.string.Meals_Name1));
//        meals.setComponents(getString(R.string.Meals_component1));
//        meals.setPrice(10);
//        meals.setImg_meal(R.drawable.burger_1);
//        list.add(meals);
//
//        meals = new Meals();
//        meals.setName_Meal(getString(R.string.Meals_Name2));
//        meals.setComponents(getString(R.string.Meals_component2));
//        meals.setPrice(15);
//        meals.setImg_meal(R.drawable.shawarma_2);
//        list.add(meals);
//
//        meals = new Meals();
//        meals.setName_Meal(getString(R.string.Meals_Name3));
//        meals.setComponents(getString(R.string.Meals_component3));
//        meals.setPrice(20);
//        meals.setImg_meal(R.drawable.pizza_3);
//        list.add(meals);
//
//        meals = new Meals();
//        meals.setName_Meal("Mamoun");
//        meals.setComponents("fff");
//        meals.setPrice(50);
//        meals.setImg_meal(R.drawable.ic_meal);
//        list.add(meals);
//
//        meals = new Meals();
//        meals.setName_Meal("Mamoun");
//        meals.setComponents("fff");
//        meals.setPrice(50);
//        meals.setImg_meal(R.drawable.ic_meal);
//        list.add(meals);
//
//        meals = new Meals();
//        meals.setName_Meal("Mamoun");
//        meals.setComponents("fff");
//        meals.setPrice(50);
//        meals.setImg_meal(R.drawable.ic_meal);
//        list.add(meals);
//
//        meals = new Meals();
//        meals.setName_Meal("Mamoun");
//        meals.setComponents("fff");
//        meals.setPrice(50);
//        meals.setImg_meal(R.drawable.ic_meal);
//        list.add(meals);
//
//        meals = new Meals();
//        meals.setName_Meal("Mamoun");
//        meals.setComponents("fff");
//        meals.setPrice(50);
//        meals.setImg_meal(R.drawable.ic_meal);
//        list.add(meals);
//
//        meals = new Meals();
//        meals.setName_Meal("Mamoun");
//        meals.setComponents("fff");
//        meals.setPrice(50);
//        meals.setImg_meal(R.drawable.ic_meal);
//        list.add(meals);
//
//        meals = new Meals();
//        meals.setName_Meal("Mamoun");
//        meals.setComponents("fff");
//        meals.setPrice(50);
//        meals.setImg_meal(R.drawable.ic_meal);
//        list.add(meals);
//
//
//        return list;
//    }


//    @Override
//    public void onDetach() {
//        super.onDetach();
//        listener=null;
//    }
}