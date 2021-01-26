package com.example.menu.menurestaurante;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menu.R;

import java.util.ArrayList;


public class FragmentDrinks extends Fragment {

    private onFragmentClickListener listener;
    public FragmentDrinks() {
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
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_drinks, container, false);
        RecyclerView recycler=view.findViewById(R.id.main_recycler_drinks);
        // add drinks object in array list to show it when click on drinks tab to show fragment with the custom layout drinks
        ArrayList<Drinks>drinks = new ArrayList<>();
        drinks.add(new Drinks(getString(R.string.drink_name1),5,1,R.drawable.soda_1));
        drinks.add(new Drinks(getString(R.string.drink_name2),9,1,R.drawable.cocktail_2));
        drinks.add(new Drinks(getString(R.string.drink_name3),8,1,R.drawable.freshjuice_3));
        drinks.add(new Drinks(getString(R.string.drink_name4),12,1,R.drawable.nutellamilkshake_4));
        drinks.add(new Drinks(getString(R.string.drink_name5),12,1,R.drawable.frappuccino_5));
        AdapterDrinks adapterMeals = new AdapterDrinks(drinks, new OnDrinkItemClickListener() {
            @Override
            public void onItemClickListener(Drinks drinks) {
                // to sent data from fragment to main activity when click on buy button
                listener.onFragmentInteraction(drinks);
            }
        });
        recycler.setRotationY(180);
        recycler.setAdapter(adapterMeals);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }
    public interface onFragmentClickListener {
        void  onFragmentInteraction(Drinks drinks);
    }
}