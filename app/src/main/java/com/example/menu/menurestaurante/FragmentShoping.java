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
import com.example.menu.database.CartDataBase;
import com.example.menu.database.CartMeal;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Objects;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;


public class
FragmentShoping extends Fragment {

     private String name_meal;
     private int count;
     private double price;
     private int img;
    public static final String NAME_KEY="name";
    public static final String count_KEY="count";
    public static final String price_KEY="price";
    public static final String img_KEY="img";
    public FragmentShoping() {
        // Required empty public constructor
    }

//    public static FragmentShoping newInstance(String name){
//        Bundle bundle = new Bundle();
//        bundle.putString(NAME_KEY,name);
//        FragmentShoping  fragmentShoping=new FragmentShoping ();
//        fragmentShoping.setArguments(bundle);
//        return fragmentShoping;
//    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle =getArguments();
        if (bundle != null) {
            name_meal = bundle.getString(NAME_KEY);
            count = bundle.getInt(count_KEY);
            price = bundle.getDouble(price_KEY);
            img = bundle.getInt(img_KEY);
            Log.i("tryaaa",name_meal);
        }
    }


//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        view= inflater.inflate(R.layout.fragment_shoping, container, false);
//        recycler=view.findViewById(R.id.main_recycler_shoping);
//        rootlayout = view.findViewById(R.id.shoping_rootlayout);
//        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
////        getMyitem();
//        adapterShoping=new AdapterShoping(getActivity().getApplicationContext(),list);
//        recycler.setRotationY(180);
//        recycler.setAdapter(adapterShoping);
//
//        list.add(new ShopingMeals(name_meal,5,50,R.drawable.ic_meal));
////        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
////        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
////        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
////        recycler.setHasFixedSize(true);
//        return view;
//    }
    CartDataBase db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        db = new CartDataBase(getActivity());
        View v =inflater.inflate(R.layout.fragment_shoping, container, false);
        RecyclerView recycler=v.findViewById(R.id.main_recycler_shoping);
//        getMyitem();
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
        ArrayList<ShopingMeals> shopingMeals=new ArrayList<>();
        shopingMeals.add(new ShopingMeals(name,count,price,img));
//        Log.i("namemeal",name_meal);
//        list.add(new CartMeal(name_meal,count,price,img));
        AdapterShoping adapterShoping=new AdapterShoping(getActivity(),shopingMeals);
        recycler.setAdapter(adapterShoping);
//        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
//        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
//        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
//        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }
 }



//    private ArrayList<ShopingMeals> getMyitem() {
//        Bundle bundle = this.getArguments();
//        if(bundle!=null) {
//            String i = bundle.getString("name", "un_name");
//        }
//        shopingMeals = new ShopingMeals();
//       String a = Objects.requireNonNull(this.getActivity()).getSharedPreferences("MySharedPref", MODE_PRIVATE).getString("name", "def");
//       SharedPreferences sh = getActivity().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
//       String s =sh.getString("name","def");
//            shopingMeals.setName_Meal(name_meal);
//            shopingMeals.setPrice(10);
//            shopingMeals.setCount(5);
//            shopingMeals.setImg_meal(R.drawable.burger_1);
//            list.add(shopingMeals);
//
//        return list;
//    }
//}