package com.example.menu.menurestaurante;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
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


    private static final String EXTRA_MUSIC_LIST = "music_list";

    public FragmentMealsType() {
        // Required empty public constructor
    }


//    public static FragmentMealsType newInstance(ArrayList<Meals> mealsArrayList) {
//        FragmentMealsType fragment = new FragmentMealsType();
//        Bundle args = new Bundle();
//        args.putParcelableArrayList("meal", (ArrayList<? extends Parcelable>) mealsArrayList);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            arrayList = getArguments().<Meals>getParcelableArrayList(String.valueOf(meals));
//        }
//    }

      RecyclerView recycler;
      AdapterMeals adapterMeals;
      ArrayList<Meals> list = new ArrayList<>();
      ConstraintLayout rootlayout;
      View view;
      Meals meals ;
//      Button btn_buy;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_meals_type, container, false);
        recycler=view.findViewById(R.id.main_recycler_meals);
        rootlayout = view.findViewById(R.id.meals_rootlayout);
//        btn_buy=view.findViewById(R.id.item_btn_tobuy);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
//        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
//        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
//        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
//        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
//        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
        getMyitem();
        adapterMeals=new AdapterMeals(getActivity().getApplicationContext(),list);
        recycler.setRotationY(180);
        // recycler.setHasFixedSize(true);
        recycler.setAdapter(adapterMeals);
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
    }



    private ArrayList<Meals> getMyitem() {
        meals = new Meals();
        meals.setName_Meal(getString(R.string.Meals_Name1));
        meals.setComponents(getString(R.string.Meals_component1));
        meals.setPrice(10);
        meals.setImg_meal(R.drawable.burger_1);
        list.add(meals);

        meals = new Meals();
        meals.setName_Meal(getString(R.string.Meals_Name2));
        meals.setComponents(getString(R.string.Meals_component2));
        meals.setPrice(15);
        meals.setImg_meal(R.drawable.shawarma_2);
        list.add(meals);

        meals = new Meals();
        meals.setName_Meal(getString(R.string.Meals_Name3));
        meals.setComponents(getString(R.string.Meals_component3));
        meals.setPrice(20);
        meals.setImg_meal(R.drawable.pizza_3);
        list.add(meals);

        meals = new Meals();
        meals.setName_Meal("Mamoun");
        meals.setComponents("fff");
        meals.setPrice(50);
        meals.setImg_meal(R.drawable.ic_meal);
        list.add(meals);

        meals = new Meals();
        meals.setName_Meal("Mamoun");
        meals.setComponents("fff");
        meals.setPrice(50);
        meals.setImg_meal(R.drawable.ic_meal);
        list.add(meals);

        meals = new Meals();
        meals.setName_Meal("Mamoun");
        meals.setComponents("fff");
        meals.setPrice(50);
        meals.setImg_meal(R.drawable.ic_meal);
        list.add(meals);

        meals = new Meals();
        meals.setName_Meal("Mamoun");
        meals.setComponents("fff");
        meals.setPrice(50);
        meals.setImg_meal(R.drawable.ic_meal);
        list.add(meals);

        meals = new Meals();
        meals.setName_Meal("Mamoun");
        meals.setComponents("fff");
        meals.setPrice(50);
        meals.setImg_meal(R.drawable.ic_meal);
        list.add(meals);

        meals = new Meals();
        meals.setName_Meal("Mamoun");
        meals.setComponents("fff");
        meals.setPrice(50);
        meals.setImg_meal(R.drawable.ic_meal);
        list.add(meals);

        meals = new Meals();
        meals.setName_Meal("Mamoun");
        meals.setComponents("fff");
        meals.setPrice(50);
        meals.setImg_meal(R.drawable.ic_meal);
        list.add(meals);


        return list;
    }
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
}