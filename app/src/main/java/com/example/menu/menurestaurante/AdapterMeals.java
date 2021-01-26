package com.example.menu.menurestaurante;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.R;
import com.example.menu.ui.MainActivity;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class AdapterMeals extends RecyclerView.Adapter<AdapterMeals.MealsViewHolder>{
    ArrayList<Meals>meals;
    OnItemClickListener  listener;
    public AdapterMeals(ArrayList<Meals> meals,OnItemClickListener listener) {
        this.meals = meals;

        this.listener=listener;
    }

    // created the first time the objects are displayed
    @NonNull
    @Override
    public MealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal_custom_item,parent,false);
        final ViewGroup.LayoutParams lp = v.getLayoutParams();
        lp.width = parent.getWidth();
        v.setLayoutParams(lp);
        // it is called once for every object or item that first displays on the screen
        return new MealsViewHolder(v);

    }

    // take holder and position ,to get information from meals object to save in holder/ custom item layout
    @Override
    public void onBindViewHolder(@NonNull MealsViewHolder holder, int position) {
        Meals meal = meals.get(position);
        holder.bind(meal);
        double price_meal=holder.meals.getPrice();
        // to plus value the count of meals when click on +
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int price_count =1;
                double Price_all=0.0;
                int count_meal = Integer.parseInt(holder.et_count.getText().toString());
                int sum = count_meal+price_count;
                holder.et_count.setText(sum+"");
                if (count_meal >= 1) {
                    // double price_meal=Double.parseDouble(price.getText().toString());
                    Price_all =sum*price_meal;
                    holder.price.setText(Price_all + "");
                }
                meal.setCount(count_meal+1);
                meal.setPrice(Price_all);
            }
        });
        // to minus value the count of meals when click on -
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int price_count =1;
                double Price_all=0.0;
                int count_meal = Integer.parseInt(holder.et_count.getText().toString());
                if(count_meal>1) {
                    int mins = count_meal - price_count;
                    holder.et_count.setText(mins + "");

                    if (count_meal >= 1) {
                        // double price_meal=Double.parseDouble(price.getText().toString());
                        Price_all = mins * price_meal;
                        holder.price.setText(Price_all + "");
                    }
                }
                meal.setCount(count_meal+1);
                meal.setPrice(Price_all);
            }

        });



    }
    // return size of array list
    @Override
    public int getItemCount() {
        return meals.size();
    }
      // save pointer object in custom item layout
    class MealsViewHolder extends  RecyclerView.ViewHolder{
        TextView Name_Meal,components,price;
        ImageView img_meal;
        EditText et_count;
        Button btn_tobuy,minus,plus;
        Meals meals;
        public MealsViewHolder(@NonNull View itemView) {
            super(itemView);
            Name_Meal=itemView.findViewById(R.id.item_tv_namemeal);
            components=itemView.findViewById(R.id.item_tv_components);
            price=itemView.findViewById(R.id.item_tv_price);
            img_meal=itemView.findViewById(R.id.item_iv_meal);
            btn_tobuy=itemView.findViewById(R.id.item_btn_tobuy);
            minus=itemView.findViewById(R.id.item_btn_minus);
            plus=itemView.findViewById(R.id.item_btn_plus);
            et_count=itemView.findViewById(R.id.item_et_count);
            // get meals object when click on buy to send it to main Activity then save it in DB shopping to show it in Shopping fragment
            btn_tobuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        listener.onItemClick(meals);
                }
            });
        }
        void bind(Meals meals){
            this.meals=meals;
            img_meal.setImageResource(meals.getImg_meal());
            Name_Meal.setText(meals.getName_Meal());
            components.setText(meals.getComponents());
            price.setText(meals.getPrice()+"");
            et_count.setText(meals.getCount()+"");
            et_count.setKeyListener(null);
        }

    }


}
