package com.example.menu.menurestaurante;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menu.R;


public class FragmentDrinks extends Fragment {


    public FragmentDrinks() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_drinks, container, false);
        RecyclerView recycler=view.findViewById(R.id.main_recycler_drinks);

        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setRotationY(180);
        return view;
    }
}