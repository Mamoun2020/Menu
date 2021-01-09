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

import com.example.menu.R;

import java.util.ArrayList;
import java.util.Objects;

import static android.content.Context.MODE_APPEND;
import static android.content.Context.MODE_PRIVATE;


public class FragmentShoping extends Fragment {


    public FragmentShoping() {
        // Required empty public constructor
    }
    RecyclerView recycler;
    View view;
    ConstraintLayout rootlayout;
    AdapterShoping adapterShoping;
    ArrayList<ShopingMeals> list = new ArrayList<>();
    ShopingMeals shopingMeals ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_shoping, container, false);
        recycler=view.findViewById(R.id.main_recycler_shoping);
        rootlayout = view.findViewById(R.id.shoping_rootlayout);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        getMyitem();
        adapterShoping=new AdapterShoping(getActivity().getApplicationContext(),list);
        recycler.setRotationY(180);
        recycler.setAdapter(adapterShoping);

//        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
//        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
//        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
//        meals.add(new Meals("mamoun","fff",50,R.drawable.ic_meal));
//        recycler.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Bundle bundle = this.getArguments();
//        if (bundle != null) {
//            String i = bundle.getString("name", "un_name");
//            Log.i("BUNDLE2", i);
//        }
    }

    private ArrayList<ShopingMeals> getMyitem() {
//        Bundle bundle = this.getArguments();
//        if(bundle!=null) {
//            String i = bundle.getString("name", "un_name");
//        }
        shopingMeals = new ShopingMeals();
       String a = Objects.requireNonNull(this.getActivity()).getSharedPreferences("MySharedPref", MODE_PRIVATE).getString("name", "def");
//       SharedPreferences sh = getActivity().getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
//       String s =sh.getString("name","def");
            shopingMeals.setName_Meal(a);
            shopingMeals.setPrice(10);
            shopingMeals.setCount(5);
            shopingMeals.setImg_meal(R.drawable.burger_1);
            list.add(shopingMeals);

        return list;
    }
}