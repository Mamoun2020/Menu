package com.example.menu.menurestaurante;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.menu.R;
import com.example.menu.database.CartMeal;

import java.util.ArrayList;

public class AdapterShoping  extends RecyclerView.Adapter<AdapterShoping.MealsViewHolder>{
    ArrayList<ShopingMeals> meals;
    Context context;
    public AdapterShoping(Context context, ArrayList<ShopingMeals> meals) {
        this.meals = meals;
        this.context=context;
    }

    @NonNull
    @Override
    public MealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_custom_item,parent,false);
        final ViewGroup.LayoutParams lp = v.getLayoutParams();
        lp.width = parent.getWidth();
        v.setLayoutParams(lp);
        return new MealsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MealsViewHolder holder, int position) {
        ShopingMeals meal = meals.get(position);
        holder.bind(meal);
    }


    @Override
    public int getItemCount() {
        return meals.size();
    }
    class MealsViewHolder extends RecyclerView.ViewHolder {
        TextView Name_Meal,price,count;
        ImageView img_meal;
        ShopingMeals meals;
        public MealsViewHolder(@NonNull View itemView) {
            super(itemView);
            img_meal=itemView.findViewById(R.id.item_iv_shopmeal);
            Name_Meal=itemView.findViewById(R.id.item_tv_shopnamemeal);
            count=itemView.findViewById(R.id.item_tv_shopcount);
            price=itemView.findViewById(R.id.item_tv_shopprice);
        }
        void bind(ShopingMeals meals){
            this.meals=meals;
            img_meal.setImageResource(meals.getImg_meal());
            Name_Meal.setText(meals.getName_Meal());
            count.setText(meals.getCount()+"");
            price.setText(meals.getPrice()+"");

        }
    }
}
