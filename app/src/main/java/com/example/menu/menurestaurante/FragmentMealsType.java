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
//      RecyclerView recycler;
//      AdapterMeals adapterMeals;
//      ConstraintLayout rootlayout;
//      View view;


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
        ArrayList<Meals> meals = new ArrayList<>();
        meals.add(new Meals(getString(R.string.Meals_Name1),getString(R.string.Meals_component1),10,R.drawable.burger_1));
        meals.add(new Meals(getString(R.string.Meals_Name2),getString(R.string.Meals_component2),15,R.drawable.shawarma_2));
        meals.add(new Meals(getString(R.string.Meals_Name3),getString(R.string.Meals_component3),20,R.drawable.pizza_3));

        AdapterMeals adapterMeals = new AdapterMeals(meals, new OnItemClickListener() {
            @Override
            public void onItemClick(Meals meals) {
                listener.onFragmentInteraction(meals);
            }
        });
        recyclerView.setRotationY(180);
        recyclerView.setAdapter(adapterMeals);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return  v;
    }
   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_meals_type, container, false);
        recycler=view.findViewById(R.id.main_recycler_meals);
        rootlayout = view.findViewById(R.id.meals_rootlayout);
        ArrayList<Meals> meals = new ArrayList<>();
        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
//        getMyitem();
        adapterMeals=new AdapterMeals(getActivity().getApplicationContext(), meals, new OnItemClickListener() {
            @Override
            public void OnItemClick(Meals meal) {
//              FragmentShoping shoping = FragmentShoping.newInstance(meal.getName_Meal());
//               FragmentManager fm = getActivity().getSupportFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.shoping_rootlayout,shoping);
//                ft.commit();
                listener.onFragmentInteraction(meal);

            }
        });
        recycler.setRotationY(180);
        // recycler.setHasFixedSize(true);
        recycler.setAdapter(adapterMeals);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
//        .putExtra("count Meals",list.)
       // int click_drawable_id=Integer.parseInt(img_meal.getTag().toString());
//        btn_buy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent gotobuy = new Intent(view.getContext(),FragmentShoping.class)
//                        .putExtra("Name Meals", meals.getName_Meal())
//                        .putExtra("price Meals",meals.getPrice())
//                        .putExtra("img",meals.getImg_meal());
//                    startActivity(gotobuy);
//            }
//        });
        return view;
    }*/

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
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        rootlayout = view.findViewById(R.id.menu_rootlayout);
//        RecyclerView recycler=view.findViewById(R.id.main_recycler_menu);
//        ArrayList<Meals> meals = new ArrayList<>();
//        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
//        AdapterMeals adapterMeals =new AdapterMeals(meals);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
//        recycler.setHasFixedSize(true);
//        recycler.setLayoutManager(layoutManager);
//        recycler.setAdapter(adapterMeals);
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        listener=null;
//    }
}