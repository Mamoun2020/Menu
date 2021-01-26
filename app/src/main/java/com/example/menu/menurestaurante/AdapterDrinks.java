package com.example.menu.menurestaurante;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.R;

import java.util.ArrayList;

public class AdapterDrinks extends RecyclerView.Adapter<AdapterDrinks.DrinksViewHolder>{
    ArrayList<Drinks> drinks;
    OnDrinkItemClickListener  listener;
    public AdapterDrinks(ArrayList<Drinks> drinks, OnDrinkItemClickListener listener) {
        this.drinks = drinks;
        this.listener=listener;
    }
    // created the first time the objects are displayed
    @NonNull
    @Override
    public DrinksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_custom_item,parent,false);
        final ViewGroup.LayoutParams lp = v.getLayoutParams();
        lp.width = parent.getWidth();
        v.setLayoutParams(lp);
    // it is called once for every object or item that first displays on the screen
        return new DrinksViewHolder(v);
    }
    // take holder and position ,to get information from drinks object to save in holder/ custom item layout
    @Override
    public void onBindViewHolder(@NonNull DrinksViewHolder holder, int position) {
        Drinks drink = drinks.get(position);
        holder.bind(drink);
        double price_drink=holder.drinks.getPrice();
        // to plus value the count of drinks when click on +
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int price_count =1;
                double Price_all=0.0;
                int count_drink = Integer.parseInt(holder.et_count.getText().toString());
                int sum = count_drink+price_count;
                holder.et_count.setText(sum+"");
                if (count_drink >= 1) {
                    // double price_meal=Double.parseDouble(price.getText().toString());
                    Price_all =sum*price_drink;
                    holder.price.setText(Price_all + "");
                }
                drink.setCount(count_drink+1);
                drink.setPrice(Price_all);
            }
        });
        // to minus value the count of drinks when click on -
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int price_count =1;
                double Price_all=0.0;
                int count_drink = Integer.parseInt(holder.et_count.getText().toString());
                if(count_drink>1) {
                    int mins = count_drink - price_count;
                    holder.et_count.setText(mins + "");

                    if (count_drink >= 1) {
                        // double price_meal=Double.parseDouble(price.getText().toString());
                        Price_all = mins * price_drink;
                        holder.price.setText(Price_all + "");
                    }
                }
                drink.setCount(count_drink+1);
                drink.setPrice(Price_all);
            }

        });
    }
    // return size of array list
    @Override
    public int getItemCount() {
        return drinks.size();
    }
    // save pointer object in custom item layout
    class DrinksViewHolder extends  RecyclerView.ViewHolder{
        TextView Name_Drink,price;
        ImageView img_drink;
        EditText et_count;
        Button btn_tobuy,minus,plus;
        Drinks drinks;
        public DrinksViewHolder(@NonNull View itemView) {
            super(itemView);
            Name_Drink=itemView.findViewById(R.id.item_tv_namedrink);
            price=itemView.findViewById(R.id.item_tv_pricedrink);
            et_count=itemView.findViewById(R.id.item_et_count_drink);
            img_drink=itemView.findViewById(R.id.item_iv_drink);
            btn_tobuy=itemView.findViewById(R.id.item_btn_buydrink);
            minus=itemView.findViewById(R.id.item_btn_minus_drink);
            plus=itemView.findViewById(R.id.item_btn_plus_drink);
            // get drinks object when click on buy to send it to main Activity then save it in DB shopping to show it in Shopping fragment
            btn_tobuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(drinks);
                }
            });
        }
        void bind(Drinks drinks){
            this.drinks=drinks;
            Name_Drink.setText(drinks.getName_Drink());
            img_drink.setImageResource(drinks.getImg_Drink());
            price.setText(drinks.getPrice()+"");
            et_count.setText(drinks.getCount()+"");
            et_count.setKeyListener(null);
        }
    }
}
